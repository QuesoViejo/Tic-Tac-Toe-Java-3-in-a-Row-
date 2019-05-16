package Interfaz;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import java.awt.Color;
//import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


//JFrame implements Serializable, so it's needed to declare a serialVersionUID



public class Window extends JFrame{

	static final long serialVersionUID = 1234;
	Type_ type;

	//All those window graphic attributes are created here since they need to be used in other methods.
	//The ones that are only used in the constructor, are created in the constructor
	
	private JPanel contentPane;
	private JTextField textField;

	int[] vec = {0,0,0,0,0,0,0,0,0}; // vec is already initialized
	int turn = 1;
	boolean winner = false;
	JButton[] btts = new JButton[9];
	
	boolean changed = false;
	int positionChanged = -1;
	private JTextField ipTextField;
	private JLabel lblIp;	
	JRadioButton rdbtnConnect;
	JLabel lblConnect;
	
	//Class Action is declared inside class Window, so it can access all attributes
	//It implements ActionListener and overload the method actionPerformed
	class Action implements ActionListener{
		int i;
		public Action(int index){
			i = index;	//index to access the arrays of values(vec) and the arrays of JButtons (btts)
		}	//Ctor
		
		public void actionPerformed(ActionEvent example) {
			
			positionChanged = i;
			changed = true;
			switch(turn%2) {
				case 0:{ //Player 2
					btts[i].setText("O");
					btts[i].setEnabled(false);
					vec[i] = 2;
					
					
				};break;
				case 1:{ // Player 1
					btts[i].setText("X");
					btts[i].setEnabled(false);
					vec[i] = 1;
				};break;
		
			}
			turn++;
			
			if(turn%2 == 0&& turn < 9) {
				if(type == Type_.Client) {
					textField.setText("Your turn");
				}else {
					textField.setText("Opponent's turn");
				}
			}else {
				if(type == Type_.Server) {
					textField.setText("Your turn");
				}else {
					textField.setText("Opponent's turn");
				}			
			}
			
			winner = Comprobation(vec);				
			if(winner == true) {
				for(int i = 0 ; i < 9 ; i++) {
					btts[i].setEnabled(false);
				}
			}			

		}//Method ActionPerformed
	}//class Action
	
	
	public Window(Type_ type) {
		this.type = type;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		for(int i = 0 ; i < 9 ; i++) {
			btts[i] = new JButton("");
			contentPane.add(btts[i]);	//Maybe have to do it after setBounds() method
		}
		
		btts[0].setBounds(50, 89, 76, 65);
		btts[1].setBounds(125, 89, 76, 65);
		btts[2].setBounds(200, 89, 76, 65);
		btts[3].setBounds(50, 155, 76, 65);
		btts[4].setBounds(125, 155, 76, 65);
		btts[5].setBounds(200, 155, 76, 65);
		btts[6].setBounds(50, 220, 76, 65);
		btts[7].setBounds(125, 220, 76, 65);
		btts[8].setBounds(201, 220, 76, 65);

		//this works (as expected), but on eclipse's design tab it doesn´t show the buttons anymore.
		// This is because of changind the auto-generated code (making an array of buttons...)
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(50, 28, 226, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		if(type == Type_.Server) {
			textField.setText("Your turn");
		}else {
			textField.setText("Opponent's turn");			
		}
		
		textField.setEditable(false);
		
		JLabel PubliLabel = new JLabel("www.wuolah.com/perfil/QuesoViejo_");
		PubliLabel.setBounds(0, 301, 265, 20);
		contentPane.add(PubliLabel);
		
		JLabel lblkQuesoviejo = new JLabel("\u00A9 2018 [May 2019 Version]");
		lblkQuesoviejo.setBounds(0, 327, 167, 20);
		contentPane.add(lblkQuesoviejo);
		
		//TextField to show/read the ip address
		ipTextField = new JTextField();
		ipTextField.setBounds(104, 3, 146, 26);
		contentPane.add(ipTextField);
		ipTextField.setColumns(10);
		
		lblIp = new JLabel("");
		lblIp.setBounds(5, 3, 123, 20);
		contentPane.add(lblIp);
		

		

		
		switch(type) {
		case Server:{
			lblIp.setText("Your IP: ");
			
		};break;
		case Client:{
			lblIp.setText("Server IP: ");
			ipTextField.setEnabled(true);
			
			rdbtnConnect = new JRadioButton("");
			rdbtnConnect.setBounds(250, 3, 26, 26);
			contentPane.add(rdbtnConnect);
			
			lblConnect = new JLabel("Connect");
			lblConnect.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblConnect.setBounds(277, 6, 69, 20);
			contentPane.add(lblConnect);
			
		};break;
		}
		

	}//Ctor Window
	
	public void BuildActionListeners() {
		//Addiong ActionListeners to JButtons
		for(int i = 0; i < 9 ; i++) {
			btts[i].addActionListener(new Action(i));
		}
	}
	
	
	
	private boolean Comprobation(int vec[]){
		
		int winner = 0; // winner is initialized in 0 which is the default value to keep playing
		// Values for winner:  0(Keep playing) 1(player1 wins) 2(player2 wins) 3(tie)
		
		//Comprobation 1
        if(vec[0] != 0){
            if((vec[0] == vec[1] && vec[0] == vec[2] )  || ( vec[0] == vec[3] && vec[0] == vec[6])){
                winner = vec[0];
            }
        }
        
        //Comprobation 2
        if(winner == 0){
            if(vec[8] != 0){
                if((vec[8] == vec[7] && vec[8] == vec[6]) || (vec[8] == vec[5] && vec[8] == vec[2])){	
                    winner = vec[8];
                }
            }
        }
        
        //Comprobation 3
        if(winner == 0){
            if(vec[4] != 0){
                if((vec[4] == vec[1] && vec[4] == vec[7]) || (vec[4] == vec[3] && vec[4] == vec[5]) || (vec[4] == vec[6] && vec[4] == vec[2]) || (vec[4] == vec[0] && vec[4] == vec[8]) ){
                	winner = vec[4];
                }
            }
        }
        if(winner == 0 && turn > 9){
            winner = 3;
        }

		//End Comprobations
		if(winner != 0) {
			if(winner == 1) {
				if(type == Type_.Server) {
					textField.setText("YOU WIN \u263A");
				}else {
					textField.setText("YOU LOSE :'(");
				}
			}else if(winner == 2) {
				if(type == Type_.Client) {
					textField.setText("YOU WIN \\u263A");
				}else {
					textField.setText("YOU LOSE :'(");
				}
			}else if(winner == 3) {
				textField.setText("TIE");
			}
			return true;
		}else {
			return false;
		}
	}


	public void block() {
		for(int i = 0 ; i < 9 ; i++) {
			btts[i].setEnabled(false);
		}
	}
	
	public void unlock() {
		for(int i = 0 ; i < 9 ; i++) {
			if(vec[i] == 0) {	//If not clicked yet, it gets enabled
				btts[i].setEnabled(true);				
			}
		}
	}
	
	public void mark(int position) {
		vec[position] = (turn%2==0) ? 2 : 1;	//Saves the player that put it
		if(turn%2==0) {
			btts[position].setText("O");
		}else {
			btts[position].setText("X");
		}
		turn++;
		
		if(turn%2==0 && turn < 9) {
			if(type == Type_.Client) {
				textField.setText("Your turn");
			}else {
				textField.setText("Opponent's turn");				
			}
		}else {
			if(type == Type_.Server) {
				textField.setText("Your turn");
			}else {
				textField.setText("Opoonent's turn");
			}
		}
		changed = false;
		positionChanged = -1;
		winner = Comprobation(vec);	
		
		if(winner) {
			for(int i = 0 ; i < 9 ; i++) {
				btts[i].setEnabled(false);
			}
		}	
	}

	
	public boolean finished() {return winner;}
	public boolean getChanged() {return changed;}
	public int getPositionChanged() {return positionChanged;}
	
	public void setText(String text) {
		textField.setText(text);
	}
	
	public void activateIpTextField() {ipTextField.setVisible(true); setEnabled(true);}
	public void desactivateIpTextField(){ipTextField.setVisible(false);}
	public void setTextIpTextField(String text) {ipTextField.setText(text);}
	public void desactivateLblIp(){lblIp.setVisible(false);}
	public String getIpTextFieldText() {
		//This thread checks if the button is selected every 0'5 seconds
		while(!rdbtnConnect.isSelected()) {
			try {Thread.sleep(500);}catch(InterruptedException e) {}
		}
		rdbtnConnect.setEnabled(false);
		rdbtnConnect.setVisible(false);
		lblConnect.setEnabled(false);
		lblConnect.setVisible(false);
		return ipTextField.getText();
	}
}
