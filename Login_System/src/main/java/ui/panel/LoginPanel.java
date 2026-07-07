package ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		
		btnRegister.setBounds(193, 170, 87, 23);
		add(btnRegister);
		
		msg.setFont(new Font("新細明體", Font.BOLD, 12));
		msg.setBounds(34, 230, 246, 30);
		msg.setForeground(Color.RED);
		add(msg);
		
	}
	
	private void registerEvents() {
		
		btnLogin.addActionListener(e -> login());
			
		
	}
	
	private void login() {
		System.out.println("Login");
	}
}
