import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

public class Client {
	Socket clientSocket = null;
	
	public boolean connect() {
		try {
			InetAddress ipHost = InetAddress.getByName("138.251.29.227");
			clientSocket = new Socket(ipHost, 10000);
			System.out.println("Connected..");
		}
		catch(IOException e) {
			System.out.println("Could not connect");			
		}
	}
	
	public void closeConnection() {
		try {
			clientSocket.close();
		}
		catch(IOException e) {
			System.out.println("Could not close");
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}