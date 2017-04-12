import Golden.Cell;

public class LoginTest {
 
 	static Game game;
 	static View view;
 		public static void main(String args[]){
 		
 			LoginGuiTest login = new LoginGuiTest();
 			//JLabel label = new JLabel();
 			login.setVisible(true);
 			do{
 				
 			}while(login.playersLoggedIn() !=true);
 			
 		
 			
 				
 				login.setVisible(false);
 				game  = new Game();
 				game.players[0] = new Player(login.getPlayerOne(), Cell.c_Color.WHITE);
 				game.players[1] = new Player(login.getPlayerTwo(), Cell.c_Color.BLACK);
 				
 				game.setTurnCount(game.avgTurnCount(login.p1_moves, login.p2_moves));
 				view = new View();
 				view.openWindow(game);
 			
 			
 			
 	}
 }