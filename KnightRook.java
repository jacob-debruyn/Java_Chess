
public class KnightRook extends MergedPiece
{
	private static final int MOVE_DISTANCE = 2;
	private String[] pieces = new String[2];
	public KnightRook(int position[])
	{
		super(position);		
		pieces[0] = "Rook";
		pieces[1] = "Knight";
	}
	
	public KnightRook(int x, int y)
	{
		super(x, y);
		pieces[0] = "Rook";
		pieces[1] = "Knight";
	}
	
	public boolean validMove(int newX, int newY) 
	{ 
		int[] pos = {newX, newY};
		return this.validMove(pos);
	}
	
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

		// Any cells up/down or left/right
		for (int i = 1; i <= MOVE_DISTANCE; i++) {
			if (newX == x + i && newY == y) {
				return true;
			}
			if (newY == y + i && newX == x) {
				return true;
			}
			if (newX == x - i && newY == y) {
				return true;
			}
			if (newY == y - i && newX == x) {
				return true;
			}
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

	// Needed?
	public void mergePiece(Piece piece1, Piece piece2) {}
	
	/** Return an array of both piece classes. */
	public Piece[] splitPiece()
	{
		Piece[] pieces = new Piece[2];
		pieces[0] = new Rook(this.position);
		pieces[1] = new Knight(this.position);
		return pieces;
	}
	public String pieceComp(int i){return pieces[i];}
	
}
