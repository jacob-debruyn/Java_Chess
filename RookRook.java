
public class RookRook extends MergedPiece
{
	private static final int MOVE_DISTANCE = 4;
	private String[] pieces = new String[2];
	public RookRook(int position[])
	{
		super(position);		
		pieces[0] = "Rook";
		pieces[1] = "Rook";
	}
	
	public RookRook(int x, int y)
	{
		super(x, y);
		pieces[0] = "Rook";
		pieces[1] = "Rook";
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
		
		return false;
	}
	
	// Needed?
	public void mergePiece(Piece piece1, Piece piece2) {}
	
	/** Return an array of both piece classes. */
	public Piece[] splitPiece()
	{
		Piece[] pieces = new Piece[2];
		pieces[0] = pieces[1] = new Rook(this.position);
		return pieces;
	}
	public String pieceComp(int i){return pieces[i];}
	
}
