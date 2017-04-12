import junit.framework.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

public class Game_test extends TestCase
{	
	Game game;
	
	@Before
	protected void setUp()
	{
		game  = new Game();
		int[] pos={3,0};
		game.players[1].updatePiecePos(0, pos);
	}
	
	@Test
	public void testInvalidPiecePlayer1(){
		assertEquals(-1,game.players[0].isPlayersPiece(0,0));
	}
	@Test
	public void testValidPiecePlayer0_Rook(){
		assertEquals(0,game.players[0].isPlayersPiece(5,0));
	}
	@Test
	public void testInvalidPiecePlayer2(){
		assertEquals(-1,game.players[1].isPlayersPiece(5,0));
	}
	@Test
	public void testValidPiecePlayer1_Rook(){
		assertEquals(0,game.players[1].isPlayersPiece(3,0));//updated piece above
	}
	@Test
	public void testValidMoveRook(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 0;
		assertEquals(true,game.players[0].validMove(0, toSelection));
	}
	@Test
	public void testValidMoveBishop(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 3;
		assertEquals(true,game.players[0].validMove(1, toSelection));
	}
	@Test
	public void testValidMoveKnight(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 1;
		assertEquals(true,game.players[0].validMove(2, toSelection));
	}
	@Test
	public void testValidMoveRookFail(){
		int[] toSelection = new int[2];
		toSelection[0] = 2;
		toSelection[1] = 0;
		assertEquals(false,game.players[0].validMove(0, toSelection));
	}
	@Test
	public void testValidMoveBishopFail(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 2;
		assertEquals(false,game.players[0].validMove(1, toSelection));
	}
	@Test
	public void testValidMoveKnightFail(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 4;
		assertEquals(false,game.players[0].validMove(2, toSelection));
	}
	@Test
	public void testTakePieceValid(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 0;
		assertEquals(true,game.players[1].takePiece(toSelection));
	}
	@Test
	public void testTakePieceInvalid(){
		int[] toSelection = new int[2];
		toSelection[0] = 4;
		toSelection[1] = 0;
		assertEquals(false,game.players[1].takePiece(toSelection));
	}
	@Test
	public void testPieceTaken(){
		int[] toSelection = new int[2];
		toSelection[0] = 3;
		toSelection[1] = 0;
		game.players[1].takePiece(toSelection);
		assertEquals(-1,game.players[1].isPlayersPiece(3,0));
	}
	
}
