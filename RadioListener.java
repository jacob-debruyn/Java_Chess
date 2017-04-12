import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

class RadioListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	 String input = e.getActionCommand();
    	 int i = Character.getNumericValue(input.charAt(2));
    	 int order = Character.getNumericValue(input.charAt(0));
      MainDisplayTest.splitPiece(i,order);
    }
}