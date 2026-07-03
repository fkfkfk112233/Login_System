package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	//create
	void insert(User user);
	
	//read
	List<User> selectAll();
	User selectByAccount(String account);
	User selectByName(String name);
	
	//update
	void update(User user);
	
	//delete
	void delete(int userId);
	
}
