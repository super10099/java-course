package applets;

import java.awt.*;
import javax.swing.*;

public class apples extends JApplet{
	private double sum;
	public void init() {
		String fn = JOptionPane.showInputDialog("first number");
		String sn = JOptionPane.showInputDialog("second number");
		
		double n1 = Double.parseDouble(fn);
		double n2 = Double.parseDouble(sn);
		
		sum = n1+n2;
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("sum is: "+sum, 25, 25);
	}
}
