package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.AuthService;

public class AuthServiceImpl implements AuthService{
	
	private UserDao userdao = new UserDaoImpl();

	@Override
	public User login(String account, String password) {
		
		User user = userdao.selectByAccount(account);
		
		if(user == null)
		{
			return null;
		}
		
		if(!user.getPassword().equals(password))
		{
			return null;
		}
		
		return user;
	}

}
