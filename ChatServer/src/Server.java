
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.*;

public class Server {
	
	private int user_id = 0;
	private ServerSocket serverSocket;
	private Server_View view;
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	private boolean serverRunning = true;
	
	public Server(Server_View view, int port) {
		this.view = view;
		view.addcmdlnActionListener(new cmdlnActionListener());
		
		//server socket
		try {
			serverSocket = new ServerSocket(port);
			
			while (serverRunning) {
				Socket newSocket = serverSocket.accept();
				Client client = new Client(newSocket, user_id++);
				clients.add(client);
				client.start();
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
	
	public synchronized void broadcast(String msg) {
		view.displayText(msg);
		for(Client c:clients) {
			c.writeMessage(msg);
		}
	}
	
	
	//client thread
	private class Client extends Thread {
		
		private int user_id;
		private Socket clientSocket;
		private PrintWriter out;
		private Scanner in;
		
		public Client(Socket clientSocket, int id) {
			this.user_id = id;
			this.clientSocket = clientSocket;
			try {
				out = new PrintWriter(clientSocket.getOutputStream());
				in = new Scanner(clientSocket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//write message to socket output
		public void writeMessage(String msg) {
			out.write(msg);
			System.out.println("writing out msg");
		}
		
		
		//listen for inputs
		@Override
		public void run() {
			boolean isRunning = true;
			String str = "";
			while (isRunning) {
				broadcast(in.nextLine());
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
