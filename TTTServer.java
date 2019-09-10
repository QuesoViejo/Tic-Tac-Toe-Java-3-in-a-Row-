package Interfaz;
import java.io.*;
import java.net.*;
import java.net.DatagramSocket;

public class TTTServer {

	public static void main(String[] args) {

		try {
			Type_ type = Type_.Server;	
			Window v = new Window(type);
						
			
			v.setVisible(true);
			v.setTitle("Server");
			v.block();
			
			ServerSocket server = new ServerSocket(3001);
			v.setText("Server waiting...");
			
			//OTo obtain server's public ip:
			//InetAddress localhost = InetAddress.getLocalHost();
			//v.setTextIpTextField(localhost.getHostAddress().trim());
			
			
			
			/*
			 * With that method below ip will be the source ip used to send a datagram to the host specified
			 * This host doesn´t even need to be accesible, since we just want to build the datagram
			 */

			String ip = "";
			try(final DatagramSocket socket = new DatagramSocket()){
			  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			  ip = socket.getLocalAddress().getHostAddress();
			}
			v.setTextIpTextField(ip);			
			
			Socket client = server.accept();
			v.setText("Your turn");
			
			//Removing IP stuff from window:
			v.desactivateIpTextField();
			v.desactivateLblIp();
			
			
			
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
						
			//Comprobations are a coroutine
			Thread th = new compThread(v,output,input,type);
			th.start();
			try {th.join();	}catch(InterruptedException e) {}
			
			server.close();
		}catch(IOException e) {}
		
		
	}
}