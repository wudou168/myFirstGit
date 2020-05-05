package util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBUtil {
	private static String driver;
	private static String username;
	private static String password;
	private static String url;
	private static Logger log = Logger.getLogger(DBUtil.class);
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	static {
		InputStream is = DBUtil.class.getResourceAsStream("/db.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			driver = p.getProperty("driver");
			username = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
			Class.forName(driver);
		} catch (IOException e) {
			log.error("读取配置文件失败;" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.error("数据库驱动类没找到;" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			log.error("数据库获取连接失败," + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement getPreparedStatement(String sql, Object params[]) {
		conn = getConnection();
		if (conn != null) {
			try {
				ps = conn.prepareStatement(sql);
				if (params != null) {
					int count = params.length;
					for (int i = 0; i < count; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
			} catch (SQLException e) {
				log.error("获取preparedStatement失败," + e.getMessage());
				e.printStackTrace();
			}
		}
		return ps;
	}

	public static void closeAll(ResultSet rs, Statement s, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("关闭ResultSet失败," + e.getMessage());
				e.printStackTrace();
			}
		}

		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				log.error("关闭Statement失败," + e.getMessage());
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("关闭Connection失败," + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static ResultSet getResultSet(String sql, Object params[]) {
		ps = getPreparedStatement(sql, params);
		if (ps != null) {
			try {
				rs = ps.executeQuery();
			} catch (SQLException e) {
				log.error("获取ResultSet失败," + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	public static <T> List<T> queryMulti(String sql, Class<T> c, Object params[]) {
		List<T> ts = null;
		if (c != null) {
			rs = getResultSet(sql, params);
			if (rs != null) {
				try {
					ts = new ArrayList<T>();
					while (rs.next()) {
						T curr = c.newInstance();
						ResultSetMetaData metaData = rs.getMetaData();
						int columnCount = metaData.getColumnCount();
						for (int i = 0; i < columnCount; i++) {
							String columnName = metaData.getColumnName(i + 1);
							Object columnValue = rs.getObject(i + 1);
							Field field = c.getDeclaredField(columnName);
							field.setAccessible(true);
							field.set(curr, columnValue);
						}
						ts.add(curr);
					}
				} catch (Exception e) {
					log.error("反射操作失败," + e.getMessage());
					e.printStackTrace();
				}finally {
					closeAll(rs, ps, conn);
				}
			}
		}
		return ts;
	}

	public static <T> T queryOne(String sql, Class<T> c, Object params[]) {
		List<T> ts =  queryMulti(sql, c, params);
		if(ts != null && ts.size()>0) {
			return ts.get(0);
		}
		return null;
	}
	
	public static int DML(String sql,Object params[]) {
		ps = getPreparedStatement(sql, params);
		if(ps != null) {
			try {
				return ps.executeUpdate();
			} catch (SQLException e) {
				log.error("PreparedStatement的DML操作失败,"+e.getMessage());
				e.printStackTrace();
			}finally {
				closeAll(rs, ps, conn);
			}
		}
		return -1;
	}

}
