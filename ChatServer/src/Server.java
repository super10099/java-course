
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.*;

public class Server {
	
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
				broadcast("someone has joined the server.");
				Client client = new Client(newSocket);
				clients.add(client);
				client.start();
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
		
		private Socket clientSocket;
		private BufferedWriter out;
		private Scanner in;
		
		public Client(Socket clientSocket) {
			this.clientSocket = clientSocket;
			try {
				out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				in = new Scanner(clientSocket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//write message to socket output
		public void writeMessage(String msg) {
			try {
				out.write(msg);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//listen for inputs
		@Override
		public void run() {
			try {
				while (true) {
					broadcast(in.nextLine());
				}
			//user disconnected
			} catch (NoSuchElementException e) {
				clients.remove(this);
				broadcast("someone has left the server.");
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
			broadcast("[SERVER]: " + cmd);
			
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
