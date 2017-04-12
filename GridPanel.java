import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class GridPanel extends JPanel {
	
	private Game game;
	private JPanel[][] grid = new JPanel[6][6];
	private int playerSelect;
	private int x;
	private int y;
	private int player;
	MouseAdapterListener MAL;
	
	
  public GridPanel(int x,int y,int player, Game game, MouseAdapterListener MAL) {
	  this.x=x;
	  this.y=y;
	  this.player=player;
	  this.game = game;
	  this.MAL = MAL;
	  
	  setLayout(new GridLayout(6,6));
	  setPreferredSize(new Dimension(600, 600));
		
	  if(player==0)playerSelect=1;
	  else playerSelect=0;	  
	  setUpGridInMove(x,y,player);
  }
  

	private void setUpGridInMove(int x, int y, int player)
	{
	
		int tracker = -1;
		int isCurrentPiece;
		isCurrentPiece = game.players[player].isPlayersPiece(x,y);

	  	for (int i = 0; i < 6; i++)
	  	{
	  		for (int j = 0; j < 6; j++)
	  		{
	  			tracker++;
	  			JPanel piecePanel = setPiece(i,j);
	  			grid[i][j] = new JPanel();   						
					grid[i][j].add(piecePanel);
	  			grid[i][j].setName(""+tracker);
	  			grid[i][j].addMouseListener((MouseListener) MAL);
	  			if ((i%2) == 0)
	  			{
	  				if ((j%2) == 0)
	  					grid[i][j].setBackground(Color.GRAY);
	  				else
	  					grid[i][j].setBackground(Color.white);
	  			}
	  			else
	  			{
	  				if ((j%2) == 1)
	  					grid[i][j].setBackground(Color.GRAY);
	  				else
	  					grid[i][j].setBackground(Color.white);
	  			}
	  			
	  			if(isCurrentPiece>=0)grid[i][j]=validMoveDisplay(grid[i][j],x,y,player,i,j,isCurrentPiece);
	  			add(grid[i][j]);
	  		}  
	  	}
	  
	}
	public JPanel validMoveDisplay(JPanel gridElement, int x, int y, int player, int i, int j,int isCurrentPiece){
		
		int isPiece;
		int[] toSelection = new int[2];
		
		if(x==i&&y==j)gridElement.setBackground(Color.LIGHT_GRAY);
		else if(isCurrentPiece>=0){

			toSelection[0] = i;
			toSelection[1] = j;
			if(game.players[player].validMove(isCurrentPiece, toSelection)){
				if ((i%2) == 0)
	  			{
	  				if ((j%2) == 0)
	  					gridElement.setBackground(new Color(0, 145, 153));
	  				else
	  					gridElement.setBackground(new Color(0, 192, 201));
	  			}
	  			else
	  			{
	  				if ((j%2) == 1)
	  					gridElement.setBackground(new Color(0, 145, 153));
	  				else
	  					gridElement.setBackground(new Color(0, 192, 201));
	  			}
				
			}
			
		}
		
		isPiece = game.players[playerSelect].isPlayersPiece(i,j);
		if(isPiece>=0){
			toSelection[0] = x;
			toSelection[1] = y;
			if(game.players[playerSelect].validMove(isPiece, toSelection)){
				gridElement.setBackground(new Color(199, 0, 57));
			}
		}
		
		
		return gridElement;
	}
	
	private JPanel setPiece(int i, int j)
	{
		JLabel label = null;
		JPanel piecePanel = new JPanel();
		piecePanel.setOpaque(false);
		for(int x=0; x<2; x++){
			int isPiece = game.players[x].isPlayersPiece(i,j);
			grid[i][j] = new JPanel();
			if(isPiece>=0){
				String piece = "";
				String className = game.players[x].pieces.get(isPiece).getName();
				label = new JLabel();
				label.setFont(new Font("GNU Unifont", Font.PLAIN, 70));
				if(x==0){
					if(new String("Rook").equals(className))piece = "\u265c";
					else if(new String("Bishop").equals(className))piece = "\u265d";
					else if(new String("Knight").equals(className))piece = "\u265e";
					else 
					{ 
						label.setFont(new Font("GNU Unifont", Font.PLAIN, 35));
						piecePanel.setBorder(new EmptyBorder(18, 0, 0, 0));
						if(new String("BishopRook").equals(className))piece = "\u265c|\u265d";
						if(new String("BishopBishop").equals(className))piece = "\u265d|\u265d";	
						if(new String("BishopKnight").equals(className))piece = "\u265d|\u265e";
						if(new String("KnightRook").equals(className))piece = "\u265e|\u265c";
						if(new String("KnightKnight").equals(className))piece = "\u265e|\u265e";	
						if(new String("RookRook").equals(className))piece = "\u265c|\u265c";
					}

				}
				else if(x==1){
					if(new String("Rook").equals(className))piece = "\u2656";
					else if(new String("Bishop").equals(className))piece = "\u2657";
					else if(new String("Knight").equals(className))piece = "\u2658";
					else 
					{ 
						label.setFont(new Font("GNU Unifont", Font.PLAIN, 35));
						piecePanel.setBorder(new EmptyBorder(18, 0, 0, 0));
						if(new String("BishopRook").equals(className))piece = "\u2656|\u2657";
						if(new String("BishopBishop").equals(className))piece = "\u2657|\u2657";	
						if(new String("BishopKnight").equals(className))piece = "\u2657|\u2658";
						if(new String("KnightRook").equals(className))piece = "\u2658|\u2656";
						if(new String("KnightKnight").equals(className))piece = "\u2658|\u2658";	
						if(new String("RookRook").equals(className))piece = "\u2656|\u2656";
					}
				}
				label.setText(piece);
				label.setOpaque(false);
				piecePanel.add(label);
			}
		}
		return piecePanel;
    	
	}
}
