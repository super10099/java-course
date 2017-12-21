package pad;

import javax.swing.JFileChooser;
import java.io.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Ribbon extends JPanel implements ActionListener{
	
	private JFileChooser fc = new JFileChooser();
	private JButton openButton;
	
	private int width = getWidth();
	private int height = 25;
	
	public Ribbon() {
		setPreferredSize(new Dimension(width, height));
	}
	
	public void setOpenButton(JButton openButton) {
		this.openButton = openButton;
		openButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					Window.window.clearScreen();
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while ((line = reader.readLine()) != null) {
						Window.window.println(line);
						Window.scrollPane.getViewport().revalidate();
						
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
