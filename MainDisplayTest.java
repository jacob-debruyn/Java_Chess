
public class MainDisplayTest {

	static Game game;
	static int player = 0;
	static View view;
	public static void main(String[] args)
	{
	
	
		game  = new Game();
		view = new View();
		view.openWindow(game);

	}
	public static void updateMove(int xCurrent, int yCurrent, int xNew, int yNew){
		 
		if(!game.gameOver()){
			int pieceNo; 
			int position[] = new int[2];
			position[0] = yNew;
			position[1] = xNew;
			pieceNo = game.players[player].isPlayersPiece(yCurrent,xCurrent);
			if(pieceNo>=0){	
	
				if(game.players[player].validMove(pieceNo, position)){
					
					if(!checkNewPos(xNew,yNew,pieceNo))game.players[player].updatePiecePos(pieceNo, position);	
					player++;
					if(player==2){
						player=0;
						game.gameTurn();
					}
					
				}
			}
			
			view.openWindow(game);
		}
		if(game.gameOver())System.out.println("game over!");
	}
	public static boolean checkNewPos(int xNew,int yNew,int pieceNo){
		int playerSelect;
		if(player==0)playerSelect=1;
		else playerSelect=0;
		
		int pieceNo2 = game.players[playerSelect].isPlayersPiece(yNew,xNew);
		if(pieceNo2>=0){	
			game.players[player].addScore();
			game.players[playerSelect].takePiece(pieceNo2);
		}
		pieceNo2 = game.players[player].isPlayersPiece(yNew,xNew);
		if(pieceNo2>=0){	
			
			game.players[player].fuse(pieceNo,pieceNo2);

			return true;
		}
		//fuse piece goes here, need make fuse p
		return false;
	}
	public static void splitPiece(int i, int order){
			i = game.players[player].split(i,order);
			int size = game.players[player].getSize();
			
			for(int j = 0;j<size;j++){
				int x = game.players[player].pieces.get(j).getY();
				System.out.println(""+x);
			}
			int x = game.players[player].pieces.get(i).getX();
			int y = game.players[player].pieces.get(i).getY();
			view.openInMoveWindow(x,y,MainDisplayTest.player);
		
	}
}
