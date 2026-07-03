package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import model.User;
import util.Session;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame extends BaseFrame {

	/***************************Attribute***************************/
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	User user = getCurrentUser();

	/***************************Main***************************/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		
		if(!requireLogin())
		{
			return;
		}
		
		setTitle("首頁");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("");
		lblWelcome.setBounds(30, 20, 230, 25);
		lblWelcome.setFont(new Font("新細明體", Font.BOLD, 16));
		contentPane.add(lblWelcome);
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tologin();
			}
		});
		btnLogout.setBounds(165, 130, 87, 23);
		contentPane.add(btnLogout);
			
		if (user != null) {
		    lblWelcome.setText("歡迎：" + user.getName());
		}

	}
	
	/***************************Method****************************/

	private void tologin()
	{
		logout();
		
		openFrame(new LoginFrame());
	}
}
