package test;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

public class TestUserDao {

	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();

		User user = dao.selectByAccount("admin");

        if (user != null) {

            System.out.println("登入成功");
            System.out.println(user.getUserId());
            System.out.println(user.getAccount());
            System.out.println(user.getPassword());
            System.out.println(user.getName());
            System.out.println(user.getRoleId());

        } else {

            System.out.println("找不到帳號");

        }
        
        System.out.println("================================");

        List<User> list = dao.selectAll();

        for(User user1 : list){

            System.out.println(user1.getUserId());
            System.out.println(user1.getAccount());
            System.out.println(user1.getName());
            System.out.println("----------------");
        }

	}

}
