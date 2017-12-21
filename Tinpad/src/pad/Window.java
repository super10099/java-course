package pad;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame{
	
	private final static int WIDTH = 600;
	private final static int HEIGHT = 400;
	static Window window;
	static Panel drawingPane;
	static Ribbon ribbonBar;
	static JScrollPane scrollPane;
	
	public Window(String title) {
		super(title);
	}
	
	public static void main(String[] args) {
		window = new Window("TinPad");
		window.setLayout(new BorderLayout());
		window.setSize(new Dimension(WIDTH, HEIGHT));
		drawingPane = new Panel();
		ribbonBar = new Ribbon();
		ribbonBar.setLayout(new BorderLayout());
		window.add(ribbonBar, BorderLayout.NORTH);
		scrollPane = new JScrollPane(drawingPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		window.add(scrollPane);
		
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
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}
	
	public void clearScreen() {
		drawingPane.setText(null);
	}
	
	public void println(String str) {
		drawingPane.append(str + "\n");
	}
}
