package crypt;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class View extends JPanel{
	
	private static JFrame window;
	
	
	//elements for JMenu
	private JMenuBar menuBar;
	private JMenu menu;
	
	//elements for JPanel
	
	//getters
	public JMenu getMenu() {
		return menu;
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
	
	
	//CONSTRUCTOR
	public View(Dimension d) {
		setPreferredSize(d);
	}
	
	
	//MAIN
	public static void main(String[] args) {
		//setup window
		window = new JFrame("Agent Tin Can");
		View view = new View(new Dimension(600, 400));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridBagLayout());
		window.add(view);
		
		//add Menu
		view.menuBar = new JMenuBar();
		view.menuBar.setPreferredSize(new Dimension(00, 20));
		window.setJMenuBar(view.menuBar);
		window.pack();
		
		//ready to display
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
	
}
