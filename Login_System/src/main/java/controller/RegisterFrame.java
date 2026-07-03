package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends BaseFrame {
	
	/***************************Attribute***************************/

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbAcc;
	private JLabel lbPwd;
	
	
	private AuthService authService = new AuthServiceImpl();
	private JLabel lbName;
	private JTextField textName;
	private JPasswordField textAccount;
	private JPasswordField textPassword;
	private JLabel lbPwd_1;
	private JTextField txtConfirmPassword;
	private JButton btnRegister;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel msgName;
	private JLabel msgAccount;
	private JLabel msgPassword;
	private JLabel msgPassword_2;
	
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
		
		lblNewLabel = new JLabel("已有帳號?");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 296, 60, 20);
		contentPane.add(lblNewLabel);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(116, 205, 96, 21);
		contentPane.add(txtConfirmPassword);
		
		btnRegister = new JButton("註冊");
		btnRegister.setBounds(125, 250, 87, 23);
		contentPane.add(btnRegister);
		
		btnNewButton = new JButton("返回登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backLogin();
			}

		});
		btnNewButton.setBounds(125, 295, 87, 23);
		contentPane.add(btnNewButton);
		
		
		msgName = new JLabel("");
		msgName.setBounds(222, 88, 80, 21);
		contentPane.add(msgName);
		
		msgAccount = new JLabel("");
		msgAccount.setBounds(222, 128, 80, 21);
		contentPane.add(msgAccount);
		
		msgPassword = new JLabel("");
		msgPassword.setBounds(222, 168, 80, 21);
		contentPane.add(msgPassword);
		
		msgName_3 = new JLabel("");
		msgName_3.setBounds(222, 208, 80, 21);
		contentPane.add(msgName_3);
	}
	/***************************Method****************************/
		
		private void backLogin() {
		
			openFrame(new LoginFrame());
		}
	
		private void register()
		{
			clearMessage();

			if(!validateInput())
			{
				return;
			}
			
			User user = new User();
			
			user.setName(textName.getText().trim());
			user.setAccount(textAccount.getText().trim());
			user.setPassword(String.valueOf(textPassword.getPassword()));
			
		    // 一般會員
		    user.setRoleId(2);

		    boolean success = authService.register(user);

		    if (success) {

		        showSuccess("註冊成功");

		    } else {

		        showError("帳號已存在");

		    }
		}
	
	

}
