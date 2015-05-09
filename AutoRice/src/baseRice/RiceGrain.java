package baseRice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Types:
 * 0. String 
 * 1. Hex color
 * 
 * */

public class RiceGrain {
	  String description;
	  int type;
	  String value;
	  JTextField textField=new JTextField();
	  JLabel label=new JLabel();
	  String line;
	  String fileName;
	  JButton colorButton = new JButton("Select");
	  Color newColor;
	  ColoredBox colorBox = new ColoredBox();
	  

	  
	  public RiceGrain(String description, int type, String value, String filename, String line) {
	    this.description = description;
	    this.label.setText(description);
	    this.type = type;
	    this.value = value;    
	    this.textField.setText(value);
	    this.fileName = filename;
	    this.line = line;
	    
	    if (this.type==1 ) {
	    	colorBox.setColor(Color.decode(textField.getText()));
			colorButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	        		newColor = JColorChooser.showDialog(
	                        Main.frame,
	                        "Choose Background Color",
	                        Color.decode(textField.getText()));
	        		if(newColor != null) {
	        			System.out.println("#"+Integer.toHexString(newColor.getRGB()).substring(2));
	        			textField.setText("#"+Integer.toHexString(newColor.getRGB()).substring(2));
	        			
	        			colorBox.setColor(Color.decode(textField.getText()));
	        			textField.setBackground(newColor);
	        			colorBox.repaint();
	        		}
	            }
	        }); 
	    	
	    }
	  }
	  


	  
public void reset(){
	textField.setText(value);
	if(type==1){
		colorBox.setColor(Color.decode(textField.getText()));
		colorBox.repaint();
	}
}

	  

}
