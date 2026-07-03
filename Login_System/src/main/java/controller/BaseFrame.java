package controller;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.User;
import util.Session;

public class BaseFrame extends JFrame {
	public BaseFrame() {
	}
	
	/***************************Attribute***************************/

	private static final long serialVersionUID = 1L;

	/***************************Main***************************/
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseFrame frame = new BaseFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/***************************Constructor***************************/

	/**
	 * Create the frame.
	 */
	/*
	public BaseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}
	*/
	
    /************************************************
     * Session
     ************************************************/
	
    /**
     * 取得目前登入者
     */
    protected User getCurrentUser() {
        return Session.getCurrentUser();
    }

    /**
     * 是否已登入
     */
    protected boolean isLogin() {
        return Session.isLogin();
    }

    /**
     * 登出
     */
    protected void logout() {
        Session.logout();
    }
    
    /************************************************
     * Permission
     ************************************************/
    
    /**
     * 是否為系統管理員
     */

    protected boolean isAdmin()
    {
    	User user = getCurrentUser();
    	
    	return user != null && user.getRoleId() == 1;
    }
    
    /**
     * 是否诶管理員
     */
    
    protected boolean isManager()
    {
    	User user = getCurrentUser();
    	
    	return user != null && user.getRoleId() == 2;
    }
    
    /**
     * 是否有身分
     */
    
    protected boolean hasRole(int roleId) {

        User user = getCurrentUser();

        return user != null && user.getRoleId() == roleId;
    }
    
    /************************************************
     * Frame
     ************************************************/
    
    /**
     * 開啟新畫面並關閉目前畫面
     */
    protected void openFrame(JFrame frame) {

        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
        dispose();

    }

    /**
     * 關閉目前畫面
     */
    protected void closeFrame() {

        dispose();

    }

    /**
     * 視窗置中
     */
    protected void centerScreen() {

        setLocationRelativeTo(null);

    }
    
    /************************************************
     * Message
     ************************************************/

    /**
     * 每個畫面的提示 Label
     */
    protected JLabel messageLabel;
	
    
    /**
     * 顯示成功訊息
     */
    protected void showSuccess(String text) {
    	
    	if(messageLabel ==null) return;
    	
    		messageLabel.setForeground(Color.GREEN);
    		messageLabel.setText(text);

    }

    /**
     * 顯示錯誤訊息
     */
    protected void showError(String text) {
    	
    	if(messageLabel ==null) return;

    	messageLabel.setForeground(Color.RED);
    	messageLabel.setText(text);

    }

    /**
     * 顯示一般訊息
     */
    protected void showInfo(String text) {
    	
    	if(messageLabel ==null) return;

    	messageLabel.setForeground(Color.BLUE);
    	messageLabel.setText(text);

    }

    /**
     * 清除訊息
     */
    protected void clearMessage() {
    	
    	 if (messageLabel == null) return;

    	 messageLabel.setText("");

    }
}
