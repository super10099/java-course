
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client{
	
	private String username = "[unknown]";
	private Client_View view;
	private Socket clientSocket;
	private SocketListener socketListener;
	private BufferedWriter out;
	
	public Client(Client_View view) {
		this.view = view;
		view.addchatlnListener(new chatlnListener());
		
	}
	
	
	private void setuser_name(String username) {
		this.username = username;
	}
	
	
	
	//connect to server
	private void connect(String ip, int port) {
		System.out.println("hi");
		try {
			clientSocket = new Socket(ip, port);
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			System.out.println("established");
			socketListener = new SocketListener(clientSocket.getInputStream());
			socketListener.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//disconnect from socket
	private void disconnect() {
		try {
			clientSocket.close();
			clientSocket = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String[] getCommand(String cmd) {
		Scanner scanner = new Scanner(cmd);
		String match = scanner.findInLine("/[\\w+\\s]+");
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
						connect(args[1], Integer.parseInt(args[2]));
						view.appendmainFrame(String.format("You've successfully joined %s", clientSocket.getInetAddress()));
						break;
					case "/disconnect":
						disconnect();
						break;
					case "/setname":
						setuser_name(args[1]);
					}	
				} else {
					if (clientSocket != null) {
						out.write(String.format("%s: %s", username, str));
						out.newLine();
						out.flush();
					}
				}
				
				//clear cahtln
				view.clearchatln();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	//listen for inputstream
	private class SocketListener extends Thread{
		
		private Scanner reader;
		
		public SocketListener(InputStream in) {
			reader = new Scanner(in);
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					view.appendmainFrame(reader.nextLine());
				}
			} catch (NoSuchElementException ex) {
				//wait for gc
				socketListener = null;
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Client(new Client_View());
	}
}
