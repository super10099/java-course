
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{

	private Client_View view;
	private Socket clientSocket;
	private BufferedWriter out;
	
	public Client(Client_View view) {
		this.view = view;
		view.addchatlnListener(new chatlnListener());
		
	}
	
	
	//connect to server
	private void connect(String ip, int port) {
		System.out.println("hi");
		try {
			clientSocket = new Socket(ip, port);
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			System.out.println("established");
			while (true) {
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String[] getCommand(String cmd) {
		Scanner scanner = new Scanner(cmd);
		String match = scanner.findInLine("/[\\w\\s]+");
		scanner.close();
		
		if (match != null) {
			String[] args = match.split("\\s+");
			for(String arg:args) {
				System.out.println(arg);
			}
			return args;
		} else {
			return null;
		}
	}
	
	private class chatlnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String str = view.getchatlnInput();
				String[] args = getCommand(str);
				if(args != null) {
					
					switch (args[0]) {
					case "/connect":
						System.out.println("WOO");
						connect(args[1], Integer.parseInt(args[2]));
						break;
					}
					
						
				}
				out.write(str + " ");
				out.newLine();
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new Client(new Client_View());
	}
}
