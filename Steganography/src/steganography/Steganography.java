package steganography;


import java.util.Scanner;
import javax.swing.JFileChooser;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Steganography {
	
	private static JFileChooser fileChooser;
	private static Scanner cmdln;
	private static String message = "HELO AMDKL NAW IUDHS AHDLWAHOUHASUJHAKJGIUWLA";
	
	public static void main(String[] args) {
		fileChooser = new JFileChooser();
		cmdln = new Scanner(System.in);
		while (cmdln.hasNext()) {
			String user_in = cmdln.nextLine();
			if (user_in.equalsIgnoreCase("encode img")) {
				System.out.print("Enter message: ");
				cmdln.hasNext();
				user_in = cmdln.next();
				System.out.println("Choose file path . . .");
				switch (fileChooser.showOpenDialog(null)) {
					case JFileChooser.APPROVE_OPTION:
						fileChooser.showSaveDialog(null);
						encode(fileChooser.getSelectedFile(), message);
						break;
					case (JFileChooser.CANCEL_OPTION):
						System.out.println("why");
						break;
					case (JFileChooser.ERROR_OPTION):
						System.out.println("?");
						break;
				}
				
			}
		}
	}
	
	public static void encode(File f, String msg) {
		
		BufferedImage img_orig = getImage(f);
		
	}
	
	public static void decode() {
		
	}
	
	public static void encode_text() {
		
	}
	
	public static void decode_text() {
		
	}
	
	/**
	 * 
	 * @param image file_path
	 * @return bufferedimage from ImageIO.read
	 */
	public static BufferedImage getImage(File file_path) {
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(file_path);
		} catch (Exception e) {};
		
		return null;
	}

}
