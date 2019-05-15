package Interfaz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Type_{
	Client,Server;
}

public class compThread extends Thread{
	Window v;
	ObjectOutputStream output;
	ObjectInputStream input;
	Type_ type;
	public compThread(Window v, ObjectOutputStream output, ObjectInputStream input, Type_ type) {
		this.type = type;
		this.v = v;
		this.input = input;
		this.output = output;
	}
	
	public void run() {
		v.BuildActionListeners();

		switch(type) {
		case Server:{
			while(!v.finished()) {
				v.unlock();;
				
				while(!v.getChanged()) {
					try{Thread.sleep(500);}catch(InterruptedException e) {}
				}
				
				v.block();
				
				//Server writing
				try {
					output.write(v.getPositionChanged());
					output.flush();
				}catch(IOException e) {}
				
				//waiting for client response in case the game is not finished yet
				if(!v.finished()) {					
					//Server reading
					try {
						int movimientoRival;
						movimientoRival = input.read();		//waiting client's move
						v.mark(movimientoRival);
					}catch(IOException e){}
				}
			}
		}break;
		case Client:{	
			while(!v.finished()) {
				v.block();
				
				//Client reading
				try {
					int movimientoRival;
					movimientoRival = input.read();		//Waiting server's move
					v.mark(movimientoRival);
				}catch(IOException e) {}
				
				
				if(!v.finished()) {	
					v.unlock();
					while(!v.getChanged()) {
						try{Thread.sleep(500);}catch(InterruptedException e) {}
					}
	
					//Client writing
					try {
						output.write(v.getPositionChanged());
						output.flush();
					}catch(IOException e) {}
				}
			}
		}break;


		}
	}
}
