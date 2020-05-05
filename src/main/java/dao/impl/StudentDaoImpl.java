package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.IStudentDao;
import entity.Paging;
import entity.Student;
import util.DBUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int delegeStudentBySid(int sid) {
		String sql = "delete from student where sid=?";
		Object[] params = {sid};
		return DBUtil.DML(sql, params);
	}

	@Override
	public int updateStudent(int sid, Student s) {
		String sql = "update student set sno=?,sname=?,semail=?,sphone_number=?,sclass=? where sid=?";
		Object[] params = {s.getSno(),s.getSname(),s.getSemail(),s.getSphone_number(),s.getSclass(),sid};
		return DBUtil.DML(sql, params);
	}

	@Override
	public Student queryStudentBySid(int sid) {
		String sql = "select * from student where sid=?";
		Object[] params = {sid};
		return DBUtil.queryOne(sql, Student.class, params);
	}

	@Override
	public List<Student> queryStudents() {
		String sql = "select * from student";
		return DBUtil.queryMulti(sql, Student.class, null);
	}

	@Override
	public int insertStudent(Student s) {
		String sql = "insert into student(sno,sname,semail,sphone_number,sclass) values(?,?,?,?,?)";
		Object[] params = {s.getSno(),s.getSname(),s.getSemail(),s.getSphone_number(),s.getSclass()};
		return DBUtil.DML(sql, params);
	}

	@Override
	public Student queryStudentBySno(String sno) {
		String sql = "select * from student where sno=?";
		Object[] params = {sno};
		return DBUtil.queryOne(sql, Student.class, params);
	}

	@Override
	public int queryTotalRecords() {
		String sql = "select count(1) from student";
		Connection conn = DBUtil.getConnection();
		Statement s = null;
		ResultSet rs = null;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return 0;
	}

	@Override
	public List<Student> queryPageStudents(Paging p) {
		String sql = "select * from student limit ?,?";
		Object[] params = {(p.getCurrPage()-1)*p.getPageSize(),p.getPageSize()};
		return DBUtil.queryMulti(sql, Student.class, params);
	}

}
