package dao;

import entity.User;

public interface IUserDao {
	public int insertUser(User user);
	public User queryUser(User user);
	public User queryUserByUname(String uname);
}
