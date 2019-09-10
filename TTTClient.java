package Interfaz;

import java.io.*;
import java.net.*;




public class TTTClient {
	public static void main(String[] args) {
		
		Type_ type = Type_.Client;
		
		//Window (without actionListeners)
		Window v = new Window(type);
		
		v.setVisible(true);
		v.setTitle("Client");
		v.block();
		v.setText("Searching for server");

		String ip = v.getIpTextFieldText();
		v.desactivateIpTextField();
		v.desactivateLblIp();
		try {
		Socket socket = new Socket(ip,3001);
		v.setText("Opponent's turn");
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		

		Thread th = new compThread(v,output,input,type);
		th.start();
		
		try {th.join();	}catch(InterruptedException e) {}
		
		//Aquí se le podría pedir si quiere jugar de nuevo		
		
		socket.close();
		}catch(IOException e) {}
		
	}
}
