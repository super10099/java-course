
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
		chatln.setCaretColor(Color.WHITE);
		jpanel.add(chatln, BorderLayout.SOUTH);
		
		//mainframe
		mainFrame.setBackground(Color.BLACK);
		mainFrame.setForeground(Color.WHITE);
		mainFrame.setEditable(false);
		jpanel.add(mainScroll, BorderLayout.CENTER);
		
		//icon
			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/images/POGGERS.png"));
				setIconImage(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//set visible
		add(jpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//append to main frame
	public void appendmainFrame(String msg) {
		String str = String.format("[Server][%s] %s ", sdf.format(new Date()), msg);
		mainFrame.append(str + "\n");
		JScrollBar vscrollBar = mainScroll.getVerticalScrollBar();
		vscrollBar.setValue(vscrollBar.getMaximum());
	}
	
	//get chatlninput
	public String getchatlnInput() {
		return chatln.getText();
	}
	
	//clear chatln
	public void clearchatln() {
		chatln.setText(null);
	}
	
	public void addchatlnListener(ActionListener l) {
		chatln.addActionListener(l);
	}
	
	public static void main(String[] args) {
		new Client_View();
	}
}
