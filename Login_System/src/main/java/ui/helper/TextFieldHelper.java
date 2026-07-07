package ui.helper;

import javax.swing.JTextField;

public final class TextFieldHelper {
	
	private TextFieldHelper() {
		
	}
	
    /**
     * 取得輸入值（自動去除前後空白）
     */	
	public static String getValue(JTextField field){
		return field.getText().trim();
	}
	
	public static void setValue(
			JTextField field,
			String value) {
		
		 field.setText(value);
	}
	
	public static void clear(JTextField...fields) {
		
		if(fields == null) {
			return;
		}
		
		for(JTextField field : fields) {
			
			field.setText("");
		}
	}
	
	public static void focus(JTextField field) {
		
		field.requestFocus();
	}

}
