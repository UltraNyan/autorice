package baseRice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class ColoredBox extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4087971364795618113L;
	Color color = Color.WHITE;

	ColoredBox() {}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {

		setBackground(color);
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(color);
		g.fillRect(0, 0, 20, 18);
		
		g.setColor(Color.GRAY);
		g2.drawRect (0, 0, 20, 18); 
		


	}

	public void setColor(Color decode) {
		color = decode;
		repaint();

	}
}
