package util;

import model.User;

public class Session {

	private static User currentUser;
	
	/**
	 *登入 
	 */
	public static void login(User user)
	{
		currentUser = user;
	}
	
	/**
	 * 登出
	 */
	public static void logout()
	{
		currentUser = null;
	}
	
	/**
	 * 是否已登入
	 */
	public static boolean isLogin()
	{
		return currentUser != null;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		Session.currentUser = currentUser;
	}
	
	
}
