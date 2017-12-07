package allfontsdisplay;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;

public class Frame extends JFrame{
	
	private GraphicsDevice gd;
	private String selectedFont;
	
	public String getSelectedFont() {
		return selectedFont;
	}
	
	public Frame(JPanel jp) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		add(jp);
		
		ArrayList<String> allfonts = new ArrayList<String>();
		
		for(Font x:ge.getAllFonts()) {
			allfonts.add(x.getFontName());
		}
		JList<String> jlist = new JList(allfonts.toArray());
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				jp.setFont(new Font((String) ((JList) e.getSource()).getSelectedValue(), Font.ROMAN_BASELINE, 72));
				repaint();
			}
			
		});
		
		JScrollPane js = new JScrollPane(jlist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setLayout(new BorderLayout());
		jp.add(js, BorderLayout.SOUTH);
		js.setPreferredSize(new Dimension(50, 100));
		
		JPanel jLeft = new JPanel();
		JPanel jRight = new JPanel();
		JPanel jTop = new JPanel();
		JPanel jBottom = new JPanel();

		add(jLeft, "West");
		jLeft.setPreferredSize(new Dimension(300, 480));
		jLeft.setBackground(Color.PINK);

		add(jRight, "East");
		jRight.setPreferredSize(new Dimension(300, 480));
		jRight.setBackground(Color.PINK);

		add(jTop, "North");
		jTop.setPreferredSize(new Dimension(640, 40));
		jTop.setBackground(Color.PINK);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisplayMode dm = new DisplayMode(800, 600, 16, 60);
		setFullScreen(dm);
	}
	
	public void setFullScreen(DisplayMode dm) {
		setUndecorated(false);
		setResizable(false);
		setVisible(true);
		gd.setFullScreenWindow(this);
		
		if(dm != null && gd.isDisplayChangeSupported()) {
			try {
				gd.setDisplayMode(dm);
			}catch(Exception e) {}
		}
	}
	
	public static void main(String[] args) {
		JFrame window = new Frame(new DrawPanel());
	}
}
