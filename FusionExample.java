
public abstract class FusionExample extends Piece
{
	private static final int MOVE_DISTANCE = 2;
	
	public FusionExample(int position[])
	{	
		super(position);
	}
	
	public FusionExample(int x, int y)
	{
		super(x, y);
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
		
		// Out of bounds
		if (newX > TestHarness.BOARD_HEIGHT || newY > TestHarness.BOARD_WIDTH || 
				newX < 0 || newY < 0) {
			//System.out.println("Out of bounds");
			return false;
		}
		
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
		// if newPosition isn't diagonal to current position
		// return false
		
		// if newPosition is outside of bounds
		// return false
		
		// if new position is >2 cells diagonal from current position
		// return false
		
		return false;
	}

	/**
	 * TODO: Milestone 2
	 */
		public void mergePiece(Piece piece, Piece pieceToMerge) {}
}
