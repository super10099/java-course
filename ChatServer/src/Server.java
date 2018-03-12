
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.*;

public class Server {
	
	private int user_id = 0;
	private ServerSocket serverSocket;
	private Server_View view;
	
	private boolean serverRunning = true;
	
	public Server(Server_View view, int port) {
		this.view = view;
		view.addcmdlnActionListener(new cmdlnActionListener());
		
		//server socket
		try {
			serverSocket = new ServerSocket(port);
			
			while (serverRunning) {
				Socket newSocket = serverSocket.accept();
				Thread clientThread = new Thread(new Client(newSocket, user_id++));
				view.displayText(String.format("user %d has joined", user_id));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> parseCommand(String cmd) {
		ArrayList<String> args = new ArrayList<String>();
		
		Scanner scanner = new Scanner(cmd);
		
		int i = 0;
		while (scanner.hasNext()) {
			args.add(scanner.next());
		}
		
		return args;
	}
	
	
	
	
	//client thread
	private class Client implements Runnable {
		
		private int user_id;
		private Socket clientSocket;
		
		public Client(Socket clientSocket, int id) {
			this.user_id = id;
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			while (true) {
				
			}
		}
		
	}
	
	//cmdln actionlistener
	private class cmdlnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = view.getCmd();
			ArrayList<String> args = parseCommand(cmd);
			view.clearcmdln(); //clear cmdln
			view.displayText(cmd);
			
			for(String temp:args) {
				System.out.print(temp + " ");
			}
			System.out.println();
			
		}
		
	}
	

	
	public static void main(String[] args) {
		new Server(new Server_View(), 9999);
	}
	
}
