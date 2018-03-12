
import java.io.IOException;
import java.net.*;

public class Client{

	private Client_View view;
	private Socket clientSocket;
	
	public Client(Client_View view, int port) {
		this.view = view;
		try {
			clientSocket = new Socket("localhost", port);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Client(new Client_View(), 9999);
	}
}
