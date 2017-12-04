package playground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JScrollPaneDemo extends JPanel{
	 
	public JScrollPaneDemo() {
		makeGui();
	}
	
	public void makeGui() {
		JScrollPane js = new JScrollPane(new JPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(js, BorderLayout.CENTER);
		super.setPreferredSize(new Dimension(2, 400));
	}
}