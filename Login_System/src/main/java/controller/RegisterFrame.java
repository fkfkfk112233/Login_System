package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.AuthService;
import service.impl.AuthServiceImpl;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterFrame extends JFrame {
	
	/***************************Attribute***************************/

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbAcc;
	private JLabel lbPwd;
	
	
	private AuthService authService = new AuthServiceImpl();
	private JLabel lbName;
	private JTextField textName;
	private JTextField textAccount;
	private JTextField textPassword;
	private JLabel lbPwd_1;
	private JTextField txtConfirmPassword;
	private JButton btnRegister;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	/***************************Main***************************/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setTitle("註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("註冊");
		title.setFont(new Font("新細明體", Font.BOLD, 20));
		title.setBounds(142, 10, 90, 50);
		contentPane.add(title);
		
		lbAcc = new JLabel("帳號：");
		lbAcc.setFont(new Font("新細明體", Font.BOLD, 15));
		lbAcc.setBounds(34, 120, 46, 30);
		contentPane.add(lbAcc);
		
		lbPwd = new JLabel("密碼：");
		lbPwd.setFont(new Font("新細明體", Font.BOLD, 15));
		lbPwd.setBounds(34, 160, 46, 30);
		contentPane.add(lbPwd);
		
		lbName = new JLabel("姓名：");
		lbName.setFont(new Font("新細明體", Font.BOLD, 15));
		lbName.setBounds(34, 80, 46, 30);
		contentPane.add(lbName);
		
		textName = new JTextField();
		textName.setBounds(90, 85, 122, 21);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAccount = new JTextField();
		textAccount.setBounds(90, 125, 122, 21);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(90, 165, 122, 21);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lbPwd_1 = new JLabel("確認密碼：");
		lbPwd_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lbPwd_1.setBounds(34, 200, 90, 30);
		contentPane.add(lbPwd_1);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(116, 205, 96, 21);
		contentPane.add(txtConfirmPassword);
		
		btnRegister = new JButton("註冊");
		btnRegister.setBounds(125, 250, 87, 23);
		contentPane.add(btnRegister);
		
		btnNewButton = new JButton("返回登入");
		btnNewButton.setBounds(125, 295, 87, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("已有帳號?");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 296, 60, 20);
		contentPane.add(lblNewLabel);

	}

}
