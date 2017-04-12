//Could this be renamed to like,menu or something?
import java.io.IOException;
import java.util.Scanner;

public class main {

	 public static void main(String[] args) throws IOException {
	    int menuLoop = 0;	
		while(menuLoop == 0) {
			System.out.println("1 Register user"); 
			System.out.println("2 start game"); 
	    	System.out.println("Enter your choice: ");
			Scanner scanner = new Scanner(System.in);
	    	String menuChoice = scanner.nextLine();
	    	
	    	if(menuChoice.equals("1"))registerMenu();
	    	else if(menuChoice.equals("2"))menuLoop = loginMenu();
    	
		}
    }
	 
	 static void registerMenu() throws IOException{
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
	    String username = scanner.nextLine();
	    
	    System.out.println("Enter your password: ");
		scanner = new Scanner(System.in);
	    String password = scanner.nextLine();
	    
	    register.registerUser(username,password);
	 }
	 static int loginMenu() throws IOException{
		 //Player[] players = new Player[2];*********************
		 int player = 1;
		 while (player == 1){
			System.out.println("Player 1 enter your username: ");
			Scanner scanner = new Scanner(System.in);
		    String username = scanner.nextLine();
		    
		    System.out.println("Player 1 enter your password: ");
			scanner = new Scanner(System.in);
		    String password = scanner.nextLine();
		    
		    System.out.println("Player 1 enter max moves: ");
			scanner = new Scanner(System.in);
		    String maxMoves = scanner.nextLine();
		    int moves = Integer.parseInt(maxMoves);
		    if(login.loginUser(username,password,1,moves)==true)player=2;
		    
		    
		 }
		 while (player == 2){
			
			
			System.out.println("Player 2 enter your username: ");
			Scanner scanner = new Scanner(System.in);
		    String username = scanner.nextLine();
		    
		    System.out.println("Player 2 enter your password: ");
			scanner = new Scanner(System.in);
		    String password = scanner.nextLine();
		    
		    System.out.println("Player 2 enter max moves: ");
			scanner = new Scanner(System.in);
		    String maxMoves = scanner.nextLine();
		    int moves = Integer.parseInt(maxMoves);
		    //if(!username.equals(player.getUser())){********stops player 2 loging in as player 1
		    if(login.loginUser(username,password,2,moves)==true){player=0;return 1;}
		 }
		 return 0;
	}
}
