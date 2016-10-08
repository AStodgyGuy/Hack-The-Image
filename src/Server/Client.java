import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

/*
 * get image bufferedimage reader
 * get output stream
 *	new byte array output stream
 *write image to byte array output stream
 *get image byte size
 *write szie to output stream
 *flush output stream
 */


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
	
	public boolean sendImage() {
		BufferedImage image;
		OutputStream outStream = new OutputStream;
	}
	
	
	public static void main(String[] args) {
		
	}
}