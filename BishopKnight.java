
public class BishopKnight extends MergedPiece
{
	private static final int MOVE_DISTANCE = 2;
	private String[] pieces = new String[2];
	public BishopKnight(int position[])
	{
		super(position);
		
		pieces[0] = "Bishop";
		pieces[1] = "Knight";
	}
	
	public BishopKnight(int x, int y)
	{
		super(x, y);
		pieces[0] = "Bishop";
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

		// Going in any diagonal
		for (int i = 1; i <= MOVE_DISTANCE; i++) {
			if (newX == x + i && newY == y + i) {
				return true;
			}
			if (newX == x + i && newY == y - i) {
				return true;
			}
			if (newX == x - i && newY == y + i) {
				return true;
			}
			if (newX == x - i && newY == y - i) {
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
		pieces[0] = new Bishop(this.position);
		pieces[1] = new Knight(this.position);
		return pieces;
	}
	public String pieceComp(int i){return pieces[i];}
	
}
