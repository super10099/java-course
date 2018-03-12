import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server_View extends JFrame{

	
	
	//date format
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	//mainframe
	private JTextArea mainFrame = new JTextArea();
	private JScrollPane mainScroll = new JScrollPane(mainFrame);
	
	//cmdln
	private JTextField textField = new JTextField("");
	
	public Server_View() {
		super("Server");
		JPanel jpanel = new JPanel(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		
		//jcomponents
		mainFrame.setBackground(Color.BLACK);
		mainFrame.setForeground(Color.WHITE);
		mainFrame.setCaretColor(Color.WHITE);
		mainFrame.setEditable(false);
		jpanel.add(mainScroll, BorderLayout.CENTER);
		
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		jpanel.setBackground(Color.BLACK);
		jpanel.add(textField, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		add(jpanel);
		setVisible(true);
	}
	
	public String getCmd() {
		return textField.getText();
	}
	
	public void clearcmdln() {
		textField.setText(null);
	}
	
	public void displayText(String msg) {
		String string = String.format("[Server] [%s] %s", sdf.format(new Date()), msg);
		mainFrame.append(string + "\n");
		JScrollBar scrollBar = mainScroll.getVerticalScrollBar();
		scrollBar.setValue(scrollBar.getMaximum());
	}
	
	public void addcmdlnActionListener(ActionListener l) {
		textField.addActionListener(l);
	}
	
	public static void main(String[] args) {
		new Server_View();
	}
}
