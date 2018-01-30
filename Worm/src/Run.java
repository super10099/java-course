import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Run extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {;
		
			public void run() {
				Border newGame = new Border();
				JFrame jf = new JFrame();
				jf.add(newGame);
				jf.setLayout(new FlowLayout());
				jf.pack();
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setLocationRelativeTo(null);
				jf.setBackground(Color.BLACK);
				jf.setVisible(true);
				jf.addKeyListener(newGame);
			}
		});
	}
}
