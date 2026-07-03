package test;

import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;

public class TestAuthService {

	public static void main(String[] args) {
		
		AuthService authservice = new AuthServiceImpl();
		
        User user = authservice.login("admin", "123");

        if (user != null) {
            System.out.println("登入成功");
            System.out.println(user.getName());
        } else {
            System.out.println("登入失敗");
        }

	}

}
