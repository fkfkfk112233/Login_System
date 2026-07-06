package ui.label;

import javax.swing.JLabel;

public final class LabelHelper {

    private LabelHelper() {

    }

    public static void setText(JLabel label, String text) {
    	
    	if(label == null){
    		return;
    	}
    	
    	label.setText(text);
    }

    public static void clear(JLabel...labels) {
    	
    	for(JLabel label : labels) {
    		label.setText("");
    	}
    }

}
