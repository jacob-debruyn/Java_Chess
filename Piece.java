
/**
 * @author Callan Delbridge
 * 29.4.2016
 */
public abstract class Piece
{
	// Protected types so subclasses can access them. (check if correct)
	protected String name; // Required? Might be for merging pieces - otherwise maybe not.
	protected int position[] = new int[2];
	
	/**
	 * Create a board piece.
	 * NOTE: Issues with parsing int array: instead parse x,y individually? Then merge them into position[]?
	 * We can't just do '... = new Bishop({2,2});' can we? IDE shows an error.
	 */
	public Piece(int x, int y)
	{
		this.position[0] = x;
		this.position[1] = y;
		
		if (this instanceof Bishop) {
			this.name = "Bishop";
			// more?
		}
		else if (this instanceof Knight) {
			this.name = "Knight";
		}
		else if (this instanceof Rook) {
			this.name = "Rook";
		}
		else if (this instanceof BishopRook) {
			this.name = "BishopRook";
		}
		else if (this instanceof BishopBishop) {
			this.name = "BishopBishop";
		}
		else if (this instanceof BishopKnight) {
			this.name = "BishopKnight";
		}
		else if (this instanceof KnightRook) {
			this.name = "KnightRook";
		}
		else if (this instanceof KnightKnight) {
			this.name = "KnightKnight";
		}
		else if (this instanceof RookRook) {
			this.name = "RookRook";
		}
		
		
	}
	
	/** Overload the constructor to allow an array to be parsed. **/
	public Piece(int[] pos)
	{
		this(pos[0], pos[1]);
	}
	
	/** Validate piece's proposed new position. **/
	public abstract boolean validMove(int newPosition[]);
	public abstract boolean validMove(int x, int y);
	
	/** TODO Milestone 2 **/
	public abstract void mergePiece(Piece piece, Piece pieceToMerge);
	
	/** Get x,y int array of piece. **/
	public int[] getPosition() { return this.position; }
	public int getX() { return this.position[0]; }
	public int getY() { return this.position[1]; }

	/** Get piece name as String. Is this needed? **/
	public String getName() { return this.name; }
	public abstract PieceType getType();
	public abstract String pieceComp(int i);
	/**
	 * Sets the new coordinates of the respective piece.
	 */
	public abstract Piece[] splitPiece();
	public void updatePosition(int position[])
	{
		this.position = position;
	}
}