/**
 * @author Callan Delbridge
 * 13.5.2016
 */
public abstract class MergedPiece extends Piece
{	
	/** Create a merged board piece. **/
	public MergedPiece(int x, int y)
	{
		super(x, y);
	}
	
	/** Overload the constructor to allow an array to be parsed. **/
	public MergedPiece(int[] position)
	{
		super(position);
	}
	public PieceType getType(){
		return PieceType.Merged;
	}
	/** Split piece into two. **/
	public abstract Piece[] splitPiece();
	public abstract String pieceComp(int i);

}