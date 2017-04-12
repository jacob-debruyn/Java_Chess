import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.io.IOException;


// extremely messy code which I'll fix up, just needed it to work



public class LoginGuiTest extends JFrame implements ActionListener{

	private JTextField username1, username2, usernameReg;
	private JLabel label,p1Label, p2Label;
	private JPasswordField password1, password2, passwordReg;
	private JButton button1,button2,buttonReg, button_logout1, button_logout2;
	int players = 0;
	//JPanel panel = new JPanel();
	private String p1_name, p2_name;
	public int p1_moves, p2_moves;
	
	
	
	LoginGuiTest(){
		initialiseGUI();
	}
	
	public void initialiseGUI(){
		
		setSize(640,670);
		setLocation(300, 200);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addPlayerOne();
		addPlayerTwo();
		addRegistration();
		

	}

	private void addPlayerOne()
	{
		
		p1Label = new JLabel ("Player One");
		p1Label.setLocation(156, 55);
		p1Label.setSize(new Dimension(334, 14));
		getContentPane().add(p1Label);
		
		label = new JLabel ("Enter username:");
		label.setLocation(156,89);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		label = new JLabel ("Enter password:");
		label.setLocation(156,114);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		username1 = new JTextField();
		username1.setColumns(15);
		username1.setSize(username1.getPreferredSize());
		
		
		
		username1.setLocation(261,80);
		
		getContentPane().add(username1);
		
		password1 = new JPasswordField();
		password1.setColumns(15);
		password1.setSize(password1.getPreferredSize());
		
		password1.setLocation(261,111);
		
		getContentPane().add(password1);
		
		button1 = new JButton("LOGIN PLAYER ONE");
		button1.setSize(button1.getPreferredSize());
		button1.setLocation(261,142);
		button1.addActionListener(this);
		getContentPane().add(button1);
		
		button_logout1 = new JButton("SWITCH PLAYER");
		button_logout1.setSize(button_logout1.getPreferredSize());
		button_logout1.setLocation(261,142);
		button_logout1.addActionListener(this);
		getContentPane().add(button_logout1);
		button_logout1.setVisible(false);
	}
	
	private void addPlayerTwo(){
	
		p2Label = new JLabel ("Player Two");
		p2Label.setLocation(156, 246);
		p2Label.setSize(new Dimension(334, 14));
		getContentPane().add(p2Label);
		
		label = new JLabel ("Enter username:");
		label.setLocation(156,277);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		label = new JLabel ("Enter password:");
		label.setLocation(156,311);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		username2 = new JTextField();
		username2.setColumns(15);
		username2.setSize(username2.getPreferredSize());
		username2.setLocation(256,277);
		
		getContentPane().add(username2);
		
		password2 = new JPasswordField();
		password2.setColumns(15);
		password2.setSize(password2.getPreferredSize());
	
		password2.setLocation(256,311);
		
		getContentPane().add(password2);
		
		button2 = new JButton("LOGIN PLAYER TWO");
		button2.setSize(button2.getPreferredSize());
		button2.setLocation(256,339);
		button2.addActionListener(this);
		getContentPane().add(button2);
		
		button_logout2 = new JButton("SWITCH PLAYER");
		button_logout2.setSize(button_logout2.getPreferredSize());
		button_logout2.setLocation(256,339);
		button_logout2.addActionListener(this);
		getContentPane().add(button_logout2);
		button_logout2.setVisible(false);
		

	}
	
	private void addRegistration(){
		
		label = new JLabel ("Register new player");
		label.setLocation(156, 436);
		label.setSize(new Dimension(334, 14));
		getContentPane().add(label);
		
		usernameReg = new JTextField();
		usernameReg.setBounds(265, 461, 160, 20);
		getContentPane().add(usernameReg);
		//textField.setColumns(10);
		
		passwordReg = new JPasswordField();
		passwordReg.setBounds(265, 501, 160, 20);
		getContentPane().add(passwordReg);
		
		label = new JLabel ("Enter a username:");
		label.setLocation(156,461);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		label = new JLabel ("Enter a password:");
		label.setLocation(156,501);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		
		
		buttonReg = new JButton("REGISTER");
		buttonReg.addActionListener(this);
		buttonReg.setSize(buttonReg.getPreferredSize());
		buttonReg.setLocation(290, 529);
		//buttonReg.setBounds(256, 514, 131, 23);
		getContentPane().add(buttonReg);
	}
	
	public boolean playersLoggedIn(){
		if(players == 2){
			
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public String getPlayerOne(){
		return p1_name;
	}
	
	public String getPlayerTwo(){
		return p2_name;
	}
	
	private boolean validateNumMoves(String playerMoves){
		
		
		try{
			Integer.parseInt(playerMoves);
		} catch(NumberFormatException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
	
	// when a button has been clicked
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button1){
			

			String pass = String.copyValueOf(password1.getPassword());
			String moves;
			
			//works if theres a whitespace though, need to change that
			if(!username2.getText().equals("") && username1.getText().equals(getPlayerTwo()))
			{
				JOptionPane.showMessageDialog(null, "User already logged in");
			}
			
			
			else if(username1.getText().equals("") || pass.equals(""))
			{
				
					JOptionPane.showMessageDialog(null, "Please fill in the missing details");
				
			}
			else if(Login.loginUser(username1.getText(),pass,1,5)==true){
				moves = JOptionPane.showInputDialog("Hello " + username1.getText() +". Number of moves?");
				
				int validate =0;
				do{
					
					
					if(validateNumMoves(moves) == true){
						p1_moves = Integer.parseInt(moves);
						validate++;
					}
					else{
						moves = JOptionPane.showInputDialog("Invalid input. Please enter a number");
					}
					
				}while(validate == 0);
				p1_name = username1.getText();
				p1Label.setText("Player One signed in");
				username1.setEditable(false);
				password1.setEditable(false);
				button1.setVisible(false);
				
				button_logout1.setVisible(true);
				players ++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid login details");
			}
			
			
		}
		else if(e.getSource() == button2){
			

			String pass = String.copyValueOf(password2.getPassword());
			String moves;
			if(!username1.getText().equals("") && username2.getText().equals(getPlayerOne()))
			{
				JOptionPane.showMessageDialog(null, "User already logged in");
			}
			
			else if(username2.getText().equals("") || pass.equals(""))
			{
				
					JOptionPane.showMessageDialog(null, "Please fill in the missing details");
				
			}
			else if(Login.loginUser(username2.getText(),pass,1,5)==true){
				//JOptionPane.showMessageDialog(null, "Hello " + username2.getText());
				moves = JOptionPane.showInputDialog("Hello " + username2.getText() +". Number of moves?");
				int validate =0;
				do{
					
					
					if(validateNumMoves(moves) == true){
						p2_moves = Integer.parseInt(moves);
						validate++;
						
					}
					else{
						moves = JOptionPane.showInputDialog("Invalid input. Please enter a number");
					}
					
				}while(validate == 0);
				
				System.out.println(moves);
				p2_name = username2.getText();
				p2Label.setText("Player Two signed in");
				players ++;
				
				//players won't be able to change their login unless they click the switch player
				username2.setEditable(false);
				password2.setEditable(false);
				button2.setVisible(false);
				
				button_logout2.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid login details");
			}
		}
		
		//Players can choose a different account etc and player count is decremented
		else if(e.getSource() == button_logout1){
			p1Label.setText("Player One");
			username1.setEditable(true);
			password1.setEditable(true);
			button1.setVisible(true);
			
			button_logout1.setVisible(false);
			players --;
		}
		
		else if(e.getSource() == button_logout2){
			p2Label.setText("Player Two");
			username2.setEditable(true);
			password2.setEditable(true);
			button2.setVisible(true);
			
			button_logout2.setVisible(false);
			players --;
		}
		
		else if(e.getSource() == buttonReg){
			String pass = String.copyValueOf(passwordReg.getPassword());
			 if(!usernameReg.getText().equals("") && !pass.equals(""))
			 {
			
				try {
				if(Register.registerUser(usernameReg.getText(),pass)== true)
				{
					JOptionPane.showMessageDialog(null, "New Player added!");
					usernameReg.setText(null);
					passwordReg.setText(null);
				}
				else{
					JOptionPane.showMessageDialog(null,"Username is already taken!");
				}
				
				//not sure what to put in the catch statement but it needs it to work
			} catch (IOException e1) {
				
			}
			 }
			 
			 else{
				 JOptionPane.showMessageDialog(null,"Please select a username & password");
				 
				 
				 
			 }
		}
	}
}