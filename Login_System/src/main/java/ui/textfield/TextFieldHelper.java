package ui.textfield;

import javax.swing.JTextField;

public final class TextFieldHelper {
	
	private TextFieldHelper() {
		
	}
	
	public static String getValue(JTextField field){
		return field.getText().trim();
	}

}
