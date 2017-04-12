import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class View {
	private JFrame mainFrame;
	//private JPanel[][] grid = new JPanel[6][6];
	//private JPanel[] hud = new JPanel[6];
	private JPanel rightPanel = new JPanel();
	private int player;
	private Game game;
	//private int firstRun = 0;
	private MouseAdapterListener MAL;
	
	private RadioListener RL = new RadioListener();

	public View()
	{
		MAL = new MouseAdapterListener();
		
		mainFrame = new JFrame("Fusion Chess");
		//'preferred' size is 600 and 630 but this makes everything show
		mainFrame.setSize(1100,700);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rightPanel.setLayout(new GridBagLayout());
	}
		
	
	
	public void openWindow(Game gameMain)
	{

		game = gameMain;
		player = MainDisplayTest.player;
		mainFrame.getContentPane().removeAll();
		openInMoveWindow(0,0,0);
		mainFrame.setVisible(true);
		
	}
	public void openInMoveWindow(int x, int y, int playerID){
		rightPanel.removeAll();
		mainFrame.getContentPane().removeAll();
		
		mainFrame.add(LeftGrid(),ConstraintSetUp(0,0,0,0,0));
		mainFrame.add(new GridPanel(x,y,playerID,game,MAL),ConstraintSetUp(1,0,0,0,0));
		rightPanel.add(TurnCountDisplay(),	ConstraintSetUp(0,0,0,10,0));
		rightPanel.add(CurrentPlayer(),		ConstraintSetUp(0,1,0,10,0));
		rightPanel.add(PlayerNames(),		ConstraintSetUp(0,2,0,0,0));
		rightPanel.add(PlayersPieces(),		ConstraintSetUp(0,3,0,0,5));
		rightPanel.add(MergedPieces(x,y),	ConstraintSetUp(0,4,0,0,0));
		mainFrame.add(rightPanel, ConstraintSetUp(2,0,0,0,10));
		mainFrame.add(BottomGrid(),ConstraintSetUp(1,1,0,0,0));
		mainFrame.setVisible(true);
	}
	public JPanel LeftGrid()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JPanel panel2;
		JLabel label;
		String[]arrayLetter = {"A","B","C","D","E","F"};
		for(int i = 0; i<6; i++){
			panel2 = new JPanel();
			panel2.setLayout(new GridBagLayout());
			label = new JLabel(arrayLetter[i]);		
			label.setFont(new Font("GNU Unifont", Font.PLAIN, 15));
			panel2.add(label);
			panel2.setPreferredSize(new Dimension(20, 100));
			panel.add(panel2,ConstraintSetUp(0,i,10,70,0));
		}	
		panel.setPreferredSize(new Dimension(21, 600));
		return panel;
	}
	public JPanel BottomGrid()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JPanel panel2;
		JLabel label;
		for(int i = 0; i<6; i++){
			panel2 = new JPanel();
			panel2.setLayout(new GridBagLayout());
			label = new JLabel(""+(i+1));		
			label.setFont(new Font("GNU Unifont", Font.PLAIN, 15));
			panel2.add(label);
			panel2.setPreferredSize(new Dimension(100, 20));
			panel.add(panel2,ConstraintSetUp(i,0,0,0,0));
		}	
		panel.setPreferredSize(new Dimension(600, 21));
		return panel;
	}
	public JPanel TurnCountDisplay()
	{
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Turns remaining: "+game.getTurnCount());
		label.setFont(new Font("GNU Unifont", Font.PLAIN, 20));
		panel.add(label);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(310, 30));
		return panel;
		
	}
	public JPanel CurrentPlayer()
	{
		JPanel panel = new JPanel();
		String playerName = game.players[player].getUser();
		JLabel label = new JLabel(playerName);
		label.setFont(new Font("GNU Unifont", Font.PLAIN, 20));
		panel.add(label);
		//panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(310, 30));
		return panel;
		
	}
	public JPanel PlayerNames()
	{
		JPanel panel = new JPanel();
		JPanel panelPlayer1 = new JPanel();
		JPanel panelPlayer2 = new JPanel();
		JLabel label;

		label = new JLabel(game.players[0].getUser()+": "+game.players[0].getScore());		
		label.setFont(new Font("GNU Unifont", Font.PLAIN, 15));
		panelPlayer1.add(label);
		panelPlayer1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		panelPlayer1.setPreferredSize(new Dimension(160, 30));
		
		label = new JLabel(game.players[1].getUser()+": "+game.players[1].getScore());
		label.setFont(new Font("GNU Unifont", Font.PLAIN, 15));
		panelPlayer2.add(label);
		panelPlayer2.setPreferredSize(new Dimension(160, 30));

		
		panel.add(panelPlayer1,ConstraintSetUp(0,0,0,0,0));
		panel.add(panelPlayer2,ConstraintSetUp(1,0,0,0,0));
		return panel;
		
	}
	public JPanel PlayersPieces()
	{
		JPanel panel = new JPanel();
		JPanel panelPlayer1 = new JPanel();
		JPanel panelPlayer2 = new JPanel();
		JLabel label;
		
		for(int i = 0; i < game.players[0].getSize(); i++){
			String piece = "";
			String className = game.players[0].pieces.get(i).getName();
			label = new JLabel();
			if(new String("Rook").equals(className))piece = "\u265c";
			else if(new String("Bishop").equals(className))piece = "\u265d";
			else if(new String("Knight").equals(className))piece = "\u265e";
			else 
			{ 
				if(new String("BishopRook").equals(className))piece = "\u265c-\u265d";
				if(new String("BishopBishop").equals(className))piece = "(\u265d-\u265d)";	
				if(new String("BishopKnight").equals(className))piece = "(\u265d-\u265e)";
				if(new String("KnightRook").equals(className))piece = "\u265e-\u265c";
				if(new String("KnightKnight").equals(className))piece = "\u265e-\u265e";	
				if(new String("RookRook").equals(className))piece = "\u265c-\u265c";
			}
			if((i+1) == game.players[0].getSize())label.setText(piece);
			else label.setText(piece+",");
			label.setFont(new Font("GNU Unifont", Font.PLAIN, 16));
			panelPlayer1.add(label);
		}
		
		for(int i = 0; i < game.players[1].getSize(); i++){
			String piece = "";
			String className = game.players[1].pieces.get(i).getName();
			label = new JLabel();
			if(new String("Rook").equals(className))piece = "\u2656";
			else if(new String("Bishop").equals(className))piece = "\u2657";
			else if(new String("Knight").equals(className))piece = "\u2658";
			else 
			{ 
				if(new String("BishopRook").equals(className))piece = "\u2656-\u2657";
				if(new String("BishopBishop").equals(className))piece = "(\u2657-\u2657)";	
				if(new String("BishopKnight").equals(className))piece = "(\u2657-\u2658)";
				if(new String("KnightRook").equals(className))piece = "\u2658-\u2656";
				if(new String("KnightKnight").equals(className))piece = "\u2658-\u2658";	
				if(new String("RookRook").equals(className))piece = "\u2656-\u2656";
			}
			if((i+1) == game.players[1].getSize())label.setText(piece);
			else label.setText(piece+",");
			label.setFont(new Font("GNU Unifont", Font.PLAIN, 16));
			panelPlayer2.add(label);
		}

		panel.setLayout(new GridBagLayout());
		panelPlayer1.setPreferredSize(new Dimension(160, 30));
		panelPlayer2.setPreferredSize(new Dimension(160, 30));
		panelPlayer1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		panel.add(panelPlayer1,ConstraintSetUp(0,0,0,0,0));
		panel.add(panelPlayer2,ConstraintSetUp(1,0,0,0,0));
		return panel;
	}
	public JPanel MergedPieces(int x, int y)
	{
		JPanel panel = new JPanel();
		int isPiece = game.players[player].isPlayersPiece(x, y);
		if(isPiece>=0&&game.players[player].getRef(isPiece)==20){
			JRadioButton dontSplit = new JRadioButton("Dont Split");
			
			JRadioButton piece1 = new JRadioButton(game.players[player].pieces.get(isPiece).pieceComp(0));
			piece1.setActionCommand("1,"+isPiece);
			piece1.addActionListener(RL);
			
		    JRadioButton piece2 = new JRadioButton(game.players[player].pieces.get(isPiece).pieceComp(1));
		    piece2.setActionCommand("2,"+isPiece);
		    piece2.addActionListener(RL);
		    
		    ButtonGroup selectRadio = new ButtonGroup();
		    selectRadio.add(dontSplit);
		    selectRadio.add(piece1);
		    selectRadio.add(piece2);
		    
		    
		    panel.add(dontSplit);
			panel.add(piece1);
			panel.add(piece2);
			
			dontSplit.setSelected(true);
			panel.setPreferredSize(new Dimension(310, 30));
		}
		else {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(310, 30));
		}
		return panel;
		
	}
	public GridBagConstraints ConstraintSetUp(int x, int y, int bottomPadding, int inPad, int leftPadding)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = 1;
		c.insets.bottom = bottomPadding;
		c.insets.left = leftPadding;
		c.ipady = inPad;
		c.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
		c.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.fill = GridBagConstraints.VERTICAL;
		return c;
		
	}
	

}
