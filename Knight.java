
public class Knight extends Piece
{
	/**
	 * Creates a Knight piece.
	 */
	public Knight(int position[])
	{	
		super(position);
	}

	/** Overload constructor to allow x,y ints to be parsed. **/
	public Knight(int x, int y)
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
		int x, y, newX, newY, j;
		y = this.position[0];
		x = this.position[1];
		newY = newPosition[0];
		newX = newPosition[1];
		
		// Same position
		if (newPosition == position) {
			System.out.println("Same position");
			return false;
		}
	
		// If x is +- 1, y must be +- 2
		if (newX == x + 1 || newX == x - 1) {
			if (newY == y + 2 || newY == y - 2) {
				return true;
			}
		}
		
		// If y is +- 1, x must be +- 2
		if (newY == y + 1 || newY == y - 1) {
			if (newX == x + 2 || newX == x - 2) {
				return true;
			}
		}
		
		return false;
	}
	public PieceType getType(){
		return PieceType.Knight;
	}
	public Piece[] splitPiece(){return null;}
	public String pieceComp(int i){return null;}
	/**
	 * TODO: Milestone 2
	 */
	public void mergePiece(Piece piece, Piece pieceToMerge) {}
	
}
