package util;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;

import ui.colors.AppColor;

public class SwingUtil {
	
    //========================
    // Label
    //========================

	public static void clearLabel(JLabel... labels) {
		
		for(JLabel label : labels)
		{
            label.setText("");

            label.setForeground(AppColor.NORMAL);
		}
	}

	public static void showError( JLabel label, String message)
	{
        label.setForeground(AppColor.ERROR);

        label.setText(message);
	}

	public static void showSuccess(JLabel label, String message)
	{
        label.setForeground(AppColor.SUCCESS);

        label.setText(message);
	}

    //========================
    // Text
    //========================
	
    public static void clearText(
            JTextComponent... texts) {

        for (JTextComponent text : texts) {

            text.setText("");

        }

    }
    
    //========================
    // Password
    //========================
    
    public static void clearPassword(
            JPasswordField... passwords) {

        for (JPasswordField password : passwords) {

            password.setText("");

        }

    }
    
    //========================
    // Focus
    //========================
    
    public static void focus(
            JTextComponent component) {

        component.requestFocusInWindow();

    }
    
}
