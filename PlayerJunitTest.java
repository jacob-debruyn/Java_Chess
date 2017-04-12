import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlayerJunitTest {
	Player p1;
	Player p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Player("Cynthia",Cell.c_Color.BLACK);
		p2 = new Player("Amarachi",Cell.c_Color.WHITE);
	}

	
	@Test
	public void getUserTest() {
		p1.getUser();
		assertEquals("Cynthia",p1.getUser());
	}
	
	/*@Test
	public void getPassTest() {
		p1.getUser();
		assertEquals("password",p1.getPassword());
	}*/
	
	@Test
	public void changeScore(){
		p1.addScore();
		p1.addScore();
		p1.addScore();
		
		p2.addScore();
		p2.addScore();
		
		assertEquals(3,p1.getScore());
		assertEquals(2,p2.getScore());
	}
	
	

}
