package playground;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Main extends JFrame{
	
	public Main() {
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new JScrollPaneDemo(), BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}

