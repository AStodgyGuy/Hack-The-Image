import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import java.net.InetAddress;
import java.io.*;
import java.nio.ByteBuffer;
import java.awt.image.BufferedImage;
import java.lang.Number;

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
	public static Socket clientSocket = null;

	public static void connect(int port) {
		try {
			InetAddress ipHost = InetAddress.getByName("138.251.29.227");
			clientSocket = new Socket(ipHost, port);
			System.out.println("Connected..");
		}
		catch(IOException e) {
			closeConnection();
			System.out.println("Could not connect");
		}
	}

	public static void closeConnection() {
		try {
			clientSocket.close();
		}
		catch(IOException e) {
			System.out.println("Could not close");
		}
	}

	public static void sendImage() {

		try {
			OutputStream outStream = clientSocket.getOutputStream();

			byte[] receiverIP = null;

			BufferedImage image = ImageIO.read(new File("screenshot.png")); //need to read image
			ByteArrayOutputStream byteArrOutStream = new ByteArrayOutputStream();

			ImageIO.write(image, "png", byteArrOutStream);

			byte[] imageSize = ByteBuffer.allocate(4).putInt(byteArrOutStream.size()).array();

			//outStream.write(receiverIP);
			outStream.write(imageSize);
			outStream.write(byteArrOutStream.toByteArray());
			outStream.flush();

			System.out.println("sent");

		} catch (IOException e) {
			closeConnection();
			System.out.println("Something went wrong");
		}
	}

	public static void receiveImage() {
		try {
			InputStreamReader inStream = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader in = new BufferedReader(inStream);

			char[] response = new char[1000];
			int n = in.read(response, 0, 1000);

			System.out.println(response.toString());

			byte[] receivedImageArray = new String(response).getBytes();

			ByteArrayInputStream is = new ByteArrayInputStream(receivedImageArray);
			BufferedImage image = ImageIO.read(is);

			System.out.println("received");

		} catch (IOException e) {
			closeConnection();
			System.out.println("Something went wrong");
			System.out.print(e.getMessage());
		}
	}


	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		connect(port);

		if (args[1].equals("send")) {
			sendImage();
		}

		if (args[1].equals("recieve")) {
			receiveImage();
		}

		closeConnection();
	}
}
