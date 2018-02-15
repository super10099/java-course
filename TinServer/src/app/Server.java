package app;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server {
	
	private SimpleDateFormat sdf;
	
	private int port;
	private boolean keepGoing = false;
	
	//CONSTRUCTOR
	public Server(int port) {
		sdf = new SimpleDateFormat("hh:mm a");
		this.port = port;
		start();
	}

	//start server
	public void start() {
		keepGoing = true;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(keepGoing) {
				display("Server waiting for clients on port " + port + ".");
				Socket socket = serverSocket.accept();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//stops server
	public void stop() {
		
	}
	
	
	//display messages to console
	public void display(String msg) {
		System.out.println(sdf.format(msg));
	}
	
	public static void main(String[] args) {
		try{
			Server server = new Server(Integer.parseInt(args[0]));
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: no port number provided.");
		}
		
	}
	
	//client thread
	//one instance will run for each client
	private class ClientThread implements Runnable{
		
		
		
		@Override
		public void run() {
			
		}

		
		
	}
	
	//listens for console commands
	private class CommandListener implements Runnable{

		@Override
		public void run() {
			Scanner cmdln = new Scanner(System.in);
			while(cmdln.hasNext()) {
				String command = cmdln.nextLine();
				if (command.equalsIgnoreCase("stop server")) {
					stop();
				}
			}
		}
		
	}
}
