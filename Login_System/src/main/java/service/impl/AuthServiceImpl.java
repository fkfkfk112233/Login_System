package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.AuthService;
import util.Session;

public class AuthServiceImpl implements AuthService{
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String account, String password) {
		
		User user = userDao.selectByAccount(account);
		
		if(user == null)
		{
			return null;
		}
		
		if(!user.getPassword().equals(password))
		{
			return null;
		}
		
		Session.login(user);
		
		return user;
	}

	@Override
	public boolean register(User user) {
	    // 1. 帳號是否存在
	    if (userDao.selectByAccount(user.getAccount()) != null) {
	        return false;
	    }

	    // 2. 新增
	    userDao.insert(user);

	    return true;
	}

}
