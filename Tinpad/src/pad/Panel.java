package pad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panel extends JTextArea{
	public final int WIDTH = Window.window.getWidth();
	public final int HEIGHT = Window.window.getHeight();
	
	public Panel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);
	}
	
}
