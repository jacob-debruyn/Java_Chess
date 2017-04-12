import java.util.*;


	public class PlayerTest {
		private static Player[] playerList = new Player[100];
		private static int playerCount = 0;
		
		
		
		
		private static final Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args)
		{
			
			int selection ;
			 
	        
	        do{
	        	System.out.println("*** Select an option ***");
		         System.out.println();
		         System.out.println("1   -   Register a new player");
		         System.out.println("2   -   Play as existing players");
		         System.out.println("3   -   Quit");
		         System.out.println();
		         
		         
		        System.out.print("Enter your selection: ");
		        
		        selection = sc.nextInt();
		        sc.nextLine();
		        
	        	switch(selection){
	        	case 1: register();
	        	break;
	        	case 2: play();
	        	break;
	        	case 3: System.out.println("That's all I've got! :) ");
	        	break;
	        	default: System.out.println("Enter a valid option please");
	        	break;
	        	}
	        }while(selection !=3);
			
			
		}
			//Register player
			
			public static void register()
			{
				String username, password;
				System.out.println("Register a player!");
				System.out.println();
				
				System.out.println("Enter a username: ");
				username = sc.nextLine();
				System.out.println("Enter a password: ");
				password = sc.nextLine();
				
				playerList[playerCount] = new Player(username,Cell.c_Color.BLACK);
				playerCount ++;
			}
			//Play game with existing players	
			public static void play()
			{
				System.out.println("Play the game as exisiting players");
				System.out.println();
				Player p1,p2;
				int playerFound = 0;
				int p2Found= 0;
				int p1Found = 0;
				int passCorrect;
				//int players;
				
				
				do{
					System.out.println("1. Player One ");
					System.out.println("2. Player Two ");
				    System.out.println();
				    System.out.println("Enter your selection: ");
				    int pSelection = sc.nextInt();
				    sc.nextLine();
				    switch(pSelection){
				    case 1:
				    	System.out.println("Player One:");
				    	System.out.println("Enter your username: ");
				    	String p1User = sc.nextLine();
				    	System.out.println("Enter your password");
				    	String p1Pass = sc.nextLine();
				    	for(int i=0; i<playerCount; i++){
							if(p1User.equals(playerList[i].getUser())){
								//making sure it actually goes into the loop
								System.out.println("Check!");
								
								/*if(p1Pass.equals(playerList[i].getPassword()))
								{*/
									//store that player as player one
									p1 = playerList[i];
									System.out.println("Player 1 is: " + p1.getUser());
									p1Found = 1;
								//}
								
							}
							
						}
				    	break;
				    case 2:
				    	System.out.println("Player Two:");
						System.out.println("Enter your username: ");
						String p2User = sc.nextLine();
						System.out.println("Enter your password");
						String p2Pass = sc.nextLine();
						for(int i=0; i<playerCount; i++){
							if(p2User.equals(playerList[i].getUser())){
								//making sure it actually goes into the loop
								System.out.println("Check!");
								
								/*if(p2Pass.equals(playerList[i].getPassword()))
								{*/
									//store that player as player one
									p2 = playerList[i];
									System.out.println("Player 1 is: " + p2.getUser());
									p2Found = 1;
								//}
								
							}
							
						}
						break;
				    }
					
				}while(p1Found !=1 && p2Found !=1);
				
				
				
				//hardcoding player 1 & 2
				//p2 = playerList[1];
				//System.out.println("Player 2 is: "+ p2.getUser());
				
				
				//need to validate based on user input \|/
				
				
				
				
				
					
				}
				
				
				
				
				
				
				
		}
		
	


