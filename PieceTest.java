import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {

	Piece[] piece = new Piece[3];
	
	@Before
	public void setUpPieces()
	{
		piece[0] = new Knight(4,5);
		piece[1] = new Bishop(2,3);
		piece[2] = new Rook(7,6);
		System.out.println("mdae pieces");
	}
	
	@Test
	public void validMoveKnight()
	{
		assertEquals(piece[0].validMove(5,3), true);
	}
	
	@Test
	public void invalidMoveKnight()
	{
		assertEquals(piece[0].validMove(4,5), false);
	}
	
	@Test
	public void validMoveBishop()
	{
		assertEquals(piece[1].validMove(3,4), true);
	}
	
	@Test
	public void validMoveRook()
	{
		assertEquals(piece[2].validMove(6,6), true);
	}
	
	@Test
	public void samePos()
	{
		assertEquals(piece[0].validMove(4,5), false);
	}
	
	@Test
	public void updatePos()
	{
		int[] newPos = {1,1};
		piece[0].updatePosition(newPos);
		assertEquals(piece[0].getPosition(), newPos);
	}
	
	@Test
	public void getNameTest()
	{
		assertEquals(piece[0].getName(), "Knight");
	}

}
