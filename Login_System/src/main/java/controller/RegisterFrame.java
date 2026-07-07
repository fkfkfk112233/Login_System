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
import ui.frame.BaseFrame;
import validator.UserValidator;
import model.ValidationResult;

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
	private JTextField txtName;
	private JTextField  txtAccount;
	private JPasswordField txtPassword;
	private JLabel lbPwd_1;
	private JPasswordField txtConfirmPassword;
	private JButton btnRegister;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JLabel msgName;
	private JLabel msgAccount;
	private JLabel msgPassword;
	private JLabel msgConfirmPassword;
	
	private UserValidator validator = new UserValidator();
	
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
		
		txtName = new JTextField();
		txtName.setBounds(90, 85, 122, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(90, 125, 122, 21);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 165, 122, 21);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		lbPwd_1 = new JLabel("確認密碼：");
		lbPwd_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lbPwd_1.setBounds(34, 200, 90, 30);
		contentPane.add(lbPwd_1);
		
		lblNewLabel = new JLabel("已有帳號?");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel.setBounds(55, 296, 60, 20);
		contentPane.add(lblNewLabel);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(116, 205, 96, 21);
		contentPane.add(txtConfirmPassword);
		
		btnRegister = new JButton("註冊");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}

		});
		btnRegister.setBounds(125, 250, 87, 23);
		contentPane.add(btnRegister);
		
		btnBack = new JButton("返回登入");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backLogin();
			}

		});
		btnBack.setBounds(125, 295, 87, 23);
		contentPane.add(btnBack);
		
		
		msgName = new JLabel("");
		msgName.setBounds(222, 88, 100, 21);
		contentPane.add(msgName);
		
		msgAccount = new JLabel("");
		msgAccount.setBounds(222, 128, 100, 21);
		contentPane.add(msgAccount);
		
		msgPassword = new JLabel("");
		msgPassword.setBounds(222, 168, 100, 21);
		contentPane.add(msgPassword);
		
		msgConfirmPassword = new JLabel("");
		msgConfirmPassword.setBounds(222, 208, 100, 21);
		contentPane.add(msgConfirmPassword);
		
		registerListener();
	}

	/***************************Method****************************/
		
		private void backLogin() {
		
			openFrame(new LoginFrame());
		}
	
		private void registerListener() {
		    txtName.addKeyListener(new java.awt.event.KeyAdapter() {
		        @Override
		        public void keyReleased(java.awt.event.KeyEvent e) {
		            validateName();
		        }
		    });

		    txtAccount.addKeyListener(new java.awt.event.KeyAdapter() {
		        @Override
		        public void keyReleased(java.awt.event.KeyEvent e) {
		            validateAccount();
		        }
		    });

		    txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
		        @Override
		        public void keyReleased(java.awt.event.KeyEvent e) {

		            validatePassword();
		            validateConfirmPassword();

		        }
		    });

		    txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
		        @Override
		        public void keyReleased(java.awt.event.KeyEvent e) {

		            validateConfirmPassword();

		        }
		    });
			
		}

		private boolean validateName() {

		    ValidationResult result =
		            validator.validateName(
		                    txtName.getText().trim());

		    msgName.setText(result.getMessage());

		    return result.isSuccess();

		}
		
		private boolean validateAccount() {

		    ValidationResult result =
		            validator.validateAccount(
		                    txtAccount.getText().trim());

		    msgAccount.setText(result.getMessage());

		    return result.isSuccess();

		}
		
		private boolean validatePassword() {

		    ValidationResult result =
		            validator.validatePassword(
		                    String.valueOf(
		                            txtPassword.getPassword()));

		    msgPassword.setText(result.getMessage());

		    return result.isSuccess();

		}
		
		private boolean validateConfirmPassword() {

		    ValidationResult result =
		            validator.validateConfirmPassword(

		                    String.valueOf(
		                            txtPassword.getPassword()),

		                    String.valueOf(
		                            txtConfirmPassword.getPassword())

		            );

		    msgConfirmPassword.setText(result.getMessage());

		    return result.isSuccess();

		}
		
		private void register() {
		    boolean ok = true;

		    ok &= validateName();
		    ok &= validateAccount();
		    ok &= validatePassword();
		    ok &= validateConfirmPassword();

		    if (!ok) {
		        return;
		    }

		    User user = new User();

		    user.setName(txtName.getText().trim());

		    user.setAccount(txtAccount.getText().trim());

		    user.setPassword(
		            String.valueOf(
		                    txtPassword.getPassword()));

		    user.setRoleId(2);

		    boolean success = authService.register(user);

		    if (success) {

		        openFrame(new LoginFrame());

		    } else {

		        msgAccount.setText("帳號已存在");

		    }
			
		}

	

}
