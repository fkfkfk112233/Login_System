package dao.impl;

import java.sql.Connection;

import dao.UserDao;
import model.User;
import util.DbConnection;

public class UserDaoImpl implements UserDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoImpl();

		User user = dao.login("admin","");

		System.out.println(user.getName());

	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String account, String password) {
		User user=null;
		String sql="select * from users where = ?";
		
		
		
		return null;
	}

	@Override
	public User selectByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}


}
