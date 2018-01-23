import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Run extends JFrame{
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {;
		
			public void run() {
				JFrame jf = new JFrame();
				jf.add(new Border());
				jf.pack();
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setLocationRelativeTo(null);
				jf.setBackground(Color.BLACK);
				jf.setVisible(true);
			}
			
		});
	}
}
