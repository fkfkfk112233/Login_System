package service;

import model.User;

public interface AuthService {
	
	//登入驗證
	User login(String account, String password);

}
