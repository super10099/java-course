package pad;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame{
	
	private final static int WIDTH = 600;
	private final static int HEIGHT = 400;
	static Window window;
	static Panel drawingPane;
	static Ribbon ribbonBar;
	
	public Window(String title) {
		super(title);
	}
	
	public static void main(String[] args) {
		window = new Window("TinPad");
		window.setSize(new Dimension(WIDTH, HEIGHT));
		drawingPane = new Panel();
		ribbonBar = new Ribbon();
		ribbonBar.setLayout(new BorderLayout());
		window.add(drawingPane, BorderLayout.CENTER);
		window.add(ribbonBar, BorderLayout.NORTH);
		
		JButton openButton = new JButton();
		ribbonBar.setOpenButton(openButton);
		ribbonBar.add(openButton, BorderLayout.WEST);
		openButton.setText("open");
		openButton.setSize(new Dimension(25, ribbonBar.getHeight()));
		openButton.setLocation(new Point(0,0));
		openButton.setVisible(true);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
}
