package dao.impl;

import dao.IUserDao;
import entity.User;
import util.DBUtil;
import util.StringUtil;

public class UserDaoImpl implements IUserDao {
	@Override
	public int insertUser(User user) {
		String sql = "insert into user(uname,upassword,uinterests) values(?,?,?)";
		String[] params = {user.getUname(),user.getUpassword(),user.getUinterests()};
		return DBUtil.DML(sql, params);
	}

	@Override
	public User queryUser(User user) {
		String sql = "select * from user where uname=? and upassword=?";
		String[] params = {user.getUname(),user.getUpassword()};
		return DBUtil.queryOne(sql, User.class, params);
	}

	@Override
	public User queryUserByUname(String uname) {
		String sql = "select * from user where uname=?";
		String[]  params = {uname};
		return DBUtil.queryOne(sql, User.class, params);
	}

}
