public class Rook extends Piece
{
	private static final int MOVE_DISTANCE = 2;
	
	/**
	 * Creates a Rook piece of team.
	 */
	public Rook(int position[])
	{	
		super(position);
	}

	/** Overload constructor to allow x,y ints to be parsed. **/
	public Rook(int x, int y)
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
			return false;
		}
		
		// Any cells up/down or left/right
		for (int i = 1; i <= MOVE_DISTANCE; i++) {
			if (newX == x + i && newY == y) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						if(MainDisplayTest.game.players[j].isPlayersPiece(y,x+1)>=0)return false;
					}
				}
				return true;
			}
			if (newY == y + i && newX == x) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						if(MainDisplayTest.game.players[j].isPlayersPiece(y+1,x)>=0)return false;
					}
				}
				return true;
			}
			if (newX == x - i && newY == y) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						if(MainDisplayTest.game.players[j].isPlayersPiece(y,x-1)>=0)return false;
					}
				}
				return true;
			}
			if (newY == y - i && newX == x) {
				if(i==MOVE_DISTANCE){
					for(int j=0;j<2;j++){
						if(MainDisplayTest.game.players[j].isPlayersPiece(y-1,x)>=0)return false;
					}
				}
				return true;
			}
		}
		
		return false;
	}
	public PieceType getType(){
		return PieceType.Rook;
	}
	public Piece[] splitPiece(){return null;}
	public String pieceComp(int i){return null;}
	/**
	 * TODO: Milestone 2
	 */
	public void mergePiece(Piece piece, Piece pieceToMerge) {}
	
}
