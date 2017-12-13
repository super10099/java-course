package playground;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class URLReader {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("Helloworld!.html");
		FileOutputStream fileIn = new FileOutputStream(file, false);
		String fileDir = file.getAbsolutePath();
		
		
		URL oracle = new URL("https://www.shmoop.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
			fileIn.write(inputLine.getBytes());
		}
		fileIn.close();
		in.close();
		
		JFrame jf = new JFrame();
		JEditorPane panel = new JEditorPane();
		jf.add(panel);
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileReader fileReader = new FileReader(fileDir);
		BufferedReader buffFileReader = new BufferedReader(fileReader);
		panel.read(buffFileReader, null);
		Desktop.getDesktop().browse(file.toURI());
	}
	
}
