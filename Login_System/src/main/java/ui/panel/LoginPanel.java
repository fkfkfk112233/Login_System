package ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;
import ui.listener.LoginPanelListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.RegisterFrame;

public class LoginPanel extends JPanel{
	
	/************ Attribute ************/
	private JLabel lblTitle;
	
	private JLabel lblAccount;
	
	private JLabel lblPassword;
	
	private JTextField txtAccount;
	
	private JPasswordField txtPassword;
	
	private JButton btnLogin;
	
	private JButton btnRegister;
	
	private JLabel msg;
	
	private AuthService authService =new AuthServiceImpl();
	
	private LoginPanelListener listener;
	
	/************ Constructor ************/
	
	public LoginPanel() {
		
		initialize();
	}
	
	/************ Initialize ************/

	private void initialize() {
		
		initComponents();
		
		layoutComponents();
		
		registerEvents();
		
	}
	
	private void initComponents() {
		
		lblTitle = new JLabel("歡迎回來");
		
		lblAccount = new JLabel("帳號");
		
		lblPassword = new JLabel("密碼");
		
		txtAccount = new JTextField();
		
		txtPassword = new JPasswordField();
		
		btnLogin = new JButton("登入");
		
		btnRegister = new JButton("註冊");
		
		msg = new JLabel("");

		
	}
	
	private void layoutComponents() {
		
		setLayout(null);
		
		lblTitle.setFont(new Font("新細明體", Font.BOLD, 20));
		lblTitle.setBounds(120, 10, 90, 50);
		add(lblTitle);
		
		lblAccount.setFont(new Font("新細明體", Font.BOLD, 15));
		lblAccount.setBounds(34, 69, 46, 30);
		add(lblAccount);
		
		lblPassword.setFont(new Font("新細明體", Font.BOLD, 15));
		lblPassword.setBounds(34, 112, 46, 30);
		add(lblPassword);
		
		txtAccount.setBounds(90, 70, 190, 30);
		add(txtAccount);
		//txtAccount.setColumns(10);
		
		txtPassword.setBounds(90, 112, 190, 30);
		add(txtPassword);
		//txtPassword.setColumns(10);
		
		btnLogin.setBounds(193, 170, 87, 23);
		add(btnLogin);
		
		btnRegister.setBounds(100, 170, 87, 23);
		add(btnRegister);
		
		msg.setFont(new Font("新細明體", Font.BOLD, 12));
		msg.setBounds(34, 230, 246, 30);
		msg.setForeground(Color.RED);
		add(msg);
		
	}
	
	private void setListener(LoginPanelListener listener) {
		
		this.listener = listener;
		
	}
	
	private void registerEvents() {
		
		btnRegister.addActionListener(e -> openRegister());
			
		
	}
	
	private void login() {
		
		if(!validateInput()) {
			
			return;
			
		}
		
		String account = txtAccount.getText().trim();
		
		String password = String.valueOf(txtPassword.getPassword());
		
		User user = authService.login(account, password);
		
		if(listener != null) {
			
			listener.onLoginSuccess();
			//msg.setText("歡迎" + user.getName());
			
		}else {
			
			msg.setText("帳號或密碼錯誤");
		}
	}
	
	private void openRegister() {
		
		listener.onRegisterClick();
		//new RegisterFrame().setVisible(true);
		
	}
	
	/****************** Method **********************/
	
	private boolean validateInput() {
		
		if(txtAccount.getText().trim().isEmpty()) {
			
			msg.setText("請輸入帳號");
			
			return false;
			
		}
		
		if(txtPassword.getPassword().length == 0) {
			
			msg.setText("請輸入密碼");
			
			return false;
			
		}
		
		
		return true;
		
	}
}
