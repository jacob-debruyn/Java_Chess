import org.junit.Test;
import org.junit.Before;
import junit.framework.*;

public class board_test extends TestCase{
	Board theBoard;

	@Before
	protected void setUp()
	{
		theBoard  = new Board();
		//theBoard.printBoard();
	}

	@Test
	public void testInitalisation()
	{
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 0));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 1));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 2));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 3));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 4));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(0, 5));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 0));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 1));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 2));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 3));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 4));
		assertEquals(Cell.c_Status.OCCUPIED, theBoard.cellCheck(5, 5));
		assertEquals(Cell.c_Status.EMPTY, theBoard.cellCheck(1, 5));
	}
	
	@Test
	public void testBounds()
	{
		assertEquals(true,theBoard.checkBounds(0,0));
		assertEquals(true,theBoard.checkBounds(4,5));
		assertFalse(theBoard.checkBounds(6,5));
		assertFalse(theBoard.checkBounds(-16,5));
	}

	@Test
	public void testBoardMove()
	{
		theBoard.moveToCell(1,1);
		assertEquals(Cell.c_Status.OCCUPIED,theBoard.cellCheck(1,1)); 
		theBoard.moveFromCell(1,1);
		assertEquals(Cell.c_Status.EMPTY,theBoard.cellCheck(1,1)); 

	}
}
