import java.util.ArrayList;

public class Player {
	public String username;
	public int score;
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	private Cell.c_Color color;
	
	private final int BishopRook = 6;
	private final int BishopBishop = 10;
	private final int BishopKnight = 15;
	private final int RookRook = 2;
	private final int KnightRook = 11;
	private final int KnightKnight = 20;
	public Player(String userName, Cell.c_Color color)
	{
		this.username = userName;
		this.score = 0;
		this.color = color;
		initalisePieces();	
	}

	private void initalisePieces()
	{
		int row = 5;
		if(color == Cell.c_Color.BLACK)
			row = 0;
		pieces.add(new Rook(row,0));
		pieces.add(new Bishop(row,1));
		pieces.add(new Knight (row,2));
		pieces.add(new Knight (row,3));
		pieces.add(new Bishop (row,4));
		pieces.add(new Rook(row,5));
		
	}
	
	//just for junit testing purposes
	public int getSize()
	{
		return pieces.size();
	}
	public String getUser()
	{
		return this.username;
	}
	
	//adds one point when it is called -- preferably when the user removes 
	//a piece from another player
	public void addScore()
	{
		this.score = score +5;
	}
	
	//returns the score of each player when called and then proceed
	//to compare it with both players scores 
	public int getScore(){
		return this.score;
	}
	
	public Cell.c_Color getColor()
	{
		return color;
	}
	
	public int isPlayersPiece(int x, int y)
	{
		for(int i = 0; i < pieces.size(); i++)
		{
			if (pieces.get(i).getX() == x && pieces.get(i).getY() == y)
			{
				return i;
			}
		}
		return (-1);
	}
	
	public boolean validMove(int index, int[] pos)
	{
		
		boolean pieceValid = pieces.get(index).validMove(pos);
		if(getRef(index)==20){
			if(isPlayersPiece(pos[0],pos[1])>=0){
				pieceValid = false;
			}
		}
		return pieceValid;
	}
	
	public void updatePiecePos(int index, int[] pos)
	{
		pieces.get(index).updatePosition(pos);
	}
	public void getPiecePos(int index)
	{
		int y = pieces.get(index).getX();
		int x = pieces.get(index).getY();
		
		System.out.println("("+x+","+y+")");
	}

	public void takePiece(int index)
	{
		//int index = isPlayersPiece(pos[0],pos[1]);
		pieces.remove(index);
	}
	public int getRef(int index){
		PieceType type = pieces.get(index).getType();
		return type.getRef();
	}
	public boolean fuse(int index1, int index2)
	{
		int sum = getRef(index1)+getRef(index2);
		if(sum==BishopRook)pieces.add(new BishopRook(pieces.get(index2).getPosition()));
		if(sum==BishopBishop)pieces.add(new BishopBishop(pieces.get(index2).getPosition()));
		if(sum==BishopKnight)pieces.add(new BishopKnight(pieces.get(index2).getPosition()));
		if(sum==RookRook)pieces.add(new RookRook(pieces.get(index2).getPosition()));
		if(sum==KnightRook)pieces.add(new KnightRook(pieces.get(index2).getPosition()));
		if(sum==KnightKnight)pieces.add(new KnightKnight(pieces.get(index2).getPosition()));
		if(index1<index2)
		{
			pieces.remove(index2);
			pieces.remove(index1);
		}
		else 
		{
			pieces.remove(index1);
			pieces.remove(index2);
		}
		
		return true;

	}
	public int split(int index, int order){
		Piece[] fusedPiece = new Piece[2];
		fusedPiece = pieces.get(index).splitPiece();
		pieces.remove(index);
		int size=-1;
		if(order==1){
			pieces.add(fusedPiece[0]);
			pieces.add(fusedPiece[1]);
		}
		else if(order==2){
			pieces.add(fusedPiece[1]);
			pieces.add(fusedPiece[0]);
		}
		
		size = size+getSize();
		return size;
	}
}

