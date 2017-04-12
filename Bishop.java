
public class Bishop extends Piece
{
	private static final int MOVE_DISTANCE = 2;
	/**
	 * Creates a Bishop piece of team.
	 */
	public Bishop(int position[])
	{
		super(position);
	}
	
	/** Overload constructor to allow x,y ints to be parsed. **/
	public Bishop(int x, int y)
	{
		super(x, y);
	}
	
	/** Overloaded method to allow x,y ints to be parsed. **/
	public boolean validMove(int x, int y)
	{
		int[] pos = {x,y};
		return this.validMove(pos);
	}
	
	/** Test if piece is making a valid move. **/
	public boolean validMove(int newPosition[])
	{
		int x, y, newX, newY;
		y = this.position[0];
		x = this.position[1];
		newY = newPosition[0];
		newX = newPosition[1];
		
		// Same position
		if (newPosition == position) {
			System.out.println("Same position");
			return false;
		}

		// Going in any diagonal
		for (int i = 1; i <= MOVE_DISTANCE; i++) {
			if (newX == x + i && newY == y + i) {				
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){						
						if(MainDisplayTest.game.players[j].isPlayersPiece(y+1,x+1)>=0)return false;
					}
				}				
				return true;
			}
			if (newX == x + i && newY == y - i) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						
						if(MainDisplayTest.game.players[j].isPlayersPiece(y-1,x+1)>=0)return false;
					}
				}
				return true;
			}
			if (newX == x - i && newY == y + i) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						
						if(MainDisplayTest.game.players[j].isPlayersPiece(y+1,x-1)>=0)return false;
					}
				}
				return true;
			}
			if (newX == x - i && newY == y - i) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						
						if(MainDisplayTest.game.players[j].isPlayersPiece(y-1,x-1)>=0)return false;
					}
				}
				return true;
			}
		}
		
		return false;
	}
	public PieceType getType(){
		return PieceType.Bishop;
	}
	public Piece[] splitPiece(){return null;}
	public String pieceComp(int i){return null;}
	/**
	 * TODO: Milestone 2
	 */
	public void mergePiece(Piece piece, Piece pieceToMerge) {}
	
}
