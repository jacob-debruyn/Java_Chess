import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlayerTestJunit {

	Player p1;
	Player p2;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		p1 = new Player("Cynthia", Cell.c_Color.WHITE);
		p2 = new Player("Vanessa", Cell.c_Color.BLACK);
		int[] pos1 = {2,5};
		int[] pos2 = {4,5};
		p1.updatePiecePos(1, pos1);
		p2.updatePiecePos(2, pos2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void userTest(){
		assertEquals("Cynthia",p1.getUser());
		assertEquals("Vanessa",p2.getUser());
	}
	
	@Test
	public void scoreTest(){
		p1.addScore();
		p1.addScore();
		p2.addScore();
		p2.addScore();
		p2.addScore();
		
		assertEquals(10,p1.getScore());
		assertEquals(15,p2.getScore());
	}
	
	@Test
	public void checkP1Piece(){
		assertEquals(-1,p1.isPlayersPiece(3,5));
	}
	
	@Test
	public void checkP2Piece(){
		assertEquals(2,p2.isPlayersPiece(4, 5));
	}
	
	@Test
	public void takePiecep1Test(){
		
		int[] position = new int[2];
		position[0]=2;
		position[1]=5;
		assertEquals(true,p1.takePiece(position));
		assertEquals(5,p1.getSize());
		
	}
	
	@Test
	public void takePiecep2Test(){
		
		int[] position = new int[2];
		position[0]=4;
		position[1]=5;
		assertEquals(true,p2.takePiece(position));
		assertEquals(5,p2.getSize());
		
	}
	
	

}
