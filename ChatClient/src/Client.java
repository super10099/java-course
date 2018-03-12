
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class Client{

	private Client_View view;
	private Socket clientSocket;
	private BufferedWriter out;
	
	public Client(Client_View view, int port) {
		this.view = view;
		view.addchatlnListener(new chatlnListener());
		try {
			clientSocket = new Socket("localhost", port);
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			while (true) {
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private class chatlnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				out.write(view.getchatlnInput() + " ");
				out.newLine();
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new Client(new Client_View(), 9999);
	}
}
