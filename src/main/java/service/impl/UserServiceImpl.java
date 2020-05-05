package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao ud = new UserDaoImpl();
	
	@Override
	public int intsertUser(User user) {
		User u = ud.queryUserByUname(user.getUname());
		if(u == null) {
			return ud.insertUser(user);
		}
		return -1;
	}

	@Override
	public User queryUser(User user) {
		return ud.queryUser(user);
	}

}
