package dao;

import model.Users;

public interface UserDao {
	
	//create
	void insert(Users user);
	
	//read
	String selectAll();
	Users selectByAccountAndPassword(String account, String password);
	Users selectByAccount(String account);
	Users selectByName(String name);
	
	//update
	void update(Users user);
	
	//delete
	void delete(Users user);
	
}
