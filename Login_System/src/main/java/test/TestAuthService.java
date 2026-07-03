package test;

import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;
import util.Session;

public class TestAuthService {

	public static void main(String[] args) {
		
		AuthService authservice = new AuthServiceImpl();
		
        User user = authservice.login("admin", "123");

        if (user != null) {
            System.out.println("登入成功");
            
            System.out.println(Session.isLogin());
            
            System.out.println(user.getName());
        } else {
            System.out.println("登入失敗");
        }
        
        System.out.println("================================");
        
        Session.logout();

        System.out.println(Session.isLogin());

	}

}
