
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client_View extends JFrame{
	
	private static final String TITLE = "Tinsant messenger";
	
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	
	private JTextField chatln = new JTextField();
	private JTextArea mainFrame = new JTextArea();
	private JScrollPane mainScroll = new JScrollPane(mainFrame);
	
	//date
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	public Client_View() {
		super(TITLE);
		JPanel jpanel = new JPanel(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		//jcomponents
		//chatln
		chatln.setBackground(Color.BLACK);
		chatln.setForeground(Color.WHITE);
		jpanel.add(chatln, BorderLayout.SOUTH);
		
		//mainframe
		mainFrame.setBackground(Color.BLACK);
		mainFrame.setForeground(Color.WHITE);
		mainFrame.setEditable(false);
		jpanel.add(mainFrame, BorderLayout.CENTER);
		
		
		//set visible
		add(jpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void appendmainFrame(String msg, String userName) {
		sdf.format(new Date());
		String str = String.format("[%s] %s: %s ", sdf, userName, msg);
		mainFrame.append(str);
	}
	
	public String getchatlnInput() {
		return chatln.getText();
	}
	
	public void addchatlnListener(ActionListener l) {
		chatln.addActionListener(l);
	}
	
	public static void main(String[] args) {
		new Client_View();
	}
}
