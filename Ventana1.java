package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;


public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	int[] vec = {0,0,0,0,0,0,0,0,0}; // vec is already initialized
	int turno = 1;
	boolean ganador = false;


	
	public Ventana1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btt1 = new JButton("");
		btt1.setBounds(50, 89, 76, 65);
		contentPane.add(btt1);
		
		JButton btt2 = new JButton("");
		btt2.setBounds(125, 89, 76, 65);
		contentPane.add(btt2);
		
		JButton btt3 = new JButton("");
		btt3.setBounds(200, 89, 76, 65);
		contentPane.add(btt3);
		
		JButton btt4 = new JButton("");
		btt4.setBounds(50, 155, 76, 65);
		contentPane.add(btt4);
		
		JButton btt5 = new JButton("");
		btt5.setBounds(125, 155, 76, 65);
		contentPane.add(btt5);
		
		JButton btt6 = new JButton("");
		btt6.setBounds(200, 155, 76, 65);
		contentPane.add(btt6);
		
		JButton btt7 = new JButton("");
		btt7.setBounds(50, 220, 76, 65);
		contentPane.add(btt7);
		
		JButton btt8 = new JButton("");
		btt8.setBounds(125, 220, 76, 65);
		contentPane.add(btt8);
		
		JButton btt9 = new JButton("");
		btt9.setBounds(201, 220, 76, 65);
		contentPane.add(btt9);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(50, 28, 226, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Player 1 Turn");
		textField.setEditable(false);
		
		JLabel PubliLabel = new JLabel("www.wuolah.com/perfil/QuesoViejo_");
		PubliLabel.setBounds(0, 301, 265, 20);
		contentPane.add(PubliLabel);
		
		JLabel lblkQuesoviejo = new JLabel("\u00A9 2k18");
		lblkQuesoviejo.setBounds(0, 327, 167, 20);
		contentPane.add(lblkQuesoviejo);

		
		btt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example1) {
				
				switch(turno%2) {
					case 0:{ //Player 2
						btt1.setText("O");
						btt1.setEnabled(false);
						vec[0] = 2;
						
						
					};break;
					case 1:{ // Player 1
							btt1.setText("X");
							btt1.setEnabled(false);
							vec[0] = 1;
					};break;
				
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
				
				
				
			}
			
		});
		
		btt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example2) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt2.setText("O");
						btt2.setEnabled(false);
						vec[1] = 2;
						
						
					};break;
					case 1:{ // Player 1
							btt2.setText("X");
							btt2.setEnabled(false);
							vec[1] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
			
			
		});
		
		btt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example3) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt3.setText("O");
						btt3.setEnabled(false);
						vec[2] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt3.setText("X");
						btt3.setEnabled(false);
						vec[2] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example4) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt4.setText("O");
						btt4.setEnabled(false);
						vec[3] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt4.setText("X");
						btt4.setEnabled(false);
						vec[3] = 1;
					};break;
			
				}
				turno++;	
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example5) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt5.setText("O");
						btt5.setEnabled(false);
						vec[4] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt5.setText("X");
						btt5.setEnabled(false);
						vec[4] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example6) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt6.setText("O");
						btt6.setEnabled(false);
						vec[5] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt6.setText("X");
						btt6.setEnabled(false);
						vec[5] = 1;
					};break;
			
				}
				turno++;	
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example7) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt7.setText("O");
						btt7.setEnabled(false);
						vec[6] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt7.setText("X");
						btt7.setEnabled(false);
						vec[6] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example8) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt8.setText("O");
						btt8.setEnabled(false);
						vec[7] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt8.setText("X");
						btt8.setEnabled(false);
						vec[7] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		btt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent example9) {
				switch(turno%2) {
					case 0:{ //Player 2
						btt9.setText("O");
						btt9.setEnabled(false);
						vec[8] = 2;
						
						
					};break;
					case 1:{ // Player 1
						btt9.setText("X");
						btt9.setEnabled(false);
						vec[8] = 1;
					};break;
			
				}
				turno++;
				
				if(turno%2 == 0&& turno < 9) {
					textField.setText("Player 2 Turn");
				}else {
					textField.setText("Player 1 Turn");
				}
				
				ganador = Comprobacion(vec);				
				if(ganador == true) {
					btt1.setEnabled(false);
					btt2.setEnabled(false);
					btt3.setEnabled(false);
					btt4.setEnabled(false);
					btt5.setEnabled(false);
					btt6.setEnabled(false);
					btt7.setEnabled(false);
					btt8.setEnabled(false);
					btt9.setEnabled(false);
				}
			}
			
		});
		
		
		
	}	
	
	private boolean Comprobacion(int vec[]){
		
		int winner = 0; // winner is initialized in 0 which is the default value to keep playing
		// Values for winner:  0(Keep playing) 1(player1 wins) 2(player2 wins) 3(tie)
		
		//Comprobation number 1
        if(vec[0] != 0){

            if((vec[0] == vec[1] && vec[0] == vec[2] )  || ( vec[0] == vec[3] && vec[0] == vec[6])){

                winner = vec[0];
            }

        }


        //Comprobation Number 2
        if(winner == 0){

            if(vec[8] != 0){
                if((vec[8] == vec[7] && vec[8] == vec[6]) || (vec[8] == vec[5] && vec[8] == vec[2])){
                	
                    winner = vec[8];
                }


            }
        }
        //Comprobation Number 3

        if(winner == 0){

            if(vec[4] != 0){

                if((vec[4] == vec[1] && vec[4] == vec[7]) || (vec[4] == vec[3] && vec[4] == vec[5]) || (vec[4] == vec[6] && vec[4] == vec[2]) || (vec[4] == vec[0] && vec[4] == vec[8]) ){

                	winner = vec[4];
                }
            }

        }
        if(winner == 0 && turno > 9){
            winner = 3;
        }

		
		//End Comprobations
		if(winner != 0) {
			if(winner == 1) {
				textField.setText("PLAYER 1 WINS");
			}else if(winner == 2) {
				textField.setText("PLAYER 2 WINS");
			}else if(winner == 3) {
				textField.setText("TIE");
			}
			return true;
			
			
		}else {
			return false;
		}
			// I will just disable all buttons since I don't know how to use an Sleep in java yet.
		
			
			
			
			
		
	}
}


