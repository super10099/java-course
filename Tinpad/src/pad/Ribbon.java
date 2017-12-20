package pad;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Ribbon extends JPanel implements ActionListener{
	
	private JButton openButton;
	
	private int width = getWidth();
	private int height = 25;
	
	public Ribbon() {
		setPreferredSize(new Dimension(width, height));
	}
	
	public void setOpenButton(JButton openButton) {
		this.openButton = openButton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
