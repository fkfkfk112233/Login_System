package dao;

import model.User;

public interface UserDao {
	
	//create
	void insert(User user);
	
	//read
	String selectAll();
	User login(String account, String password);
	User selectByAccount(String account);
	User selectByName(String name);
	
	//update
	void update(User user);
	
	//delete
	void delete(User user);
	
}
