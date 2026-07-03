package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;

public class LoginFrame extends BaseFrame {

	/***************************Attribute***************************/
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbAcc;
	private JLabel lbPwd;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	private JLabel msg;
	
	private JButton btnLogin;
	
	private AuthService authService = new AuthServiceImpl();

			
	/***************************Main***************************/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/***************************Constructor***************************/

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("登入系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("歡迎回來");
		title.setFont(new Font("新細明體", Font.BOLD, 20));
		title.setBounds(120, 10, 90, 50);
		contentPane.add(title);
		
		msg = new JLabel("");
		msg.setFont(new Font("新細明體", Font.BOLD, 12));
		msg.setBounds(34, 230, 246, 30);
		msg.setForeground(Color.RED);
		contentPane.add(msg);
	
		
		txtAccount = new JTextField("");		
		txtAccount.setBounds(90, 70, 190, 30);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);
		
		
		txtPassword = new JPasswordField("");
		txtPassword.setBounds(90, 112, 190, 30);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("登入");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(193, 170, 87, 23);
		contentPane.add(btnLogin);
		
		lbAcc = new JLabel("帳號：");
		lbAcc.setFont(new Font("新細明體", Font.BOLD, 15));
		lbAcc.setBounds(34, 69, 46, 30);
		contentPane.add(lbAcc);
		
		lbPwd = new JLabel("密碼：");
		lbPwd.setFont(new Font("新細明體", Font.BOLD, 15));
		lbPwd.setBounds(34, 112, 46, 30);
		contentPane.add(lbPwd);
	}
	/***************************Method****************************/

	private void login() {
		
		 msg.setText("");

	    if(!validateInput()) {
	        return;
	    }

	    String account = txtAccount.getText().trim();
	    String password = String.valueOf(txtPassword.getPassword());

	    User user = authService.login(account, password);

	    if(user != null) {

	    	showSuccess("歡迎 " + user.getName());
	        
	    	openFrame(new HomeFrame());
	        
	        clearMessage();

	    }else {

	    	showError("帳號或密碼錯誤");

	    }

	}
	
	private boolean validateInput() {

	    String account = txtAccount.getText().trim();
	    String password = String.valueOf(txtPassword.getPassword());

	    if(account.isEmpty() || account.equals("請輸入帳號")) {

	    	msg.setText("請輸入帳號");
	        return false;
	    }

	    if(password.isEmpty()) {

	    	msg.setText("請輸入密碼");
	        return false;
	    }

	    return true;
	}
}
