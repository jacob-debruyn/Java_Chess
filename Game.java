
public class Game
{
	//private class variables for board, players, pieces, etc

	private int turnCount;
	Player players[] = new Player[2];
	public int move;
	public Game()
	{
		//login and
		//get strings from Login, using temp values for now

		
		//make players
		
		//set turn count- this also needs to come from login
		

	}

	public boolean gameOver(){
		if(turnCount==0)return true;
		return false;
	}
	public void gameTurn(){
		
		if(turnCount>0)turnCount--;
		
	}
	
	public int getTurnCount()
	{
		return turnCount;
	}
	
	public void setTurnCount(int turns)
	{
		this.turnCount = turns;
	}
	
	public int avgTurnCount(int p1moves, int p2moves)
	{
		int moves = (p1moves + p2moves)/2;
		return moves;
		
	}
}
