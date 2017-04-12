public class Board{
    private int board_dim = 6;
    private Cell[][] g_board = new Cell [board_dim][board_dim];

    public Board()
    {
    	for (int i = 0; i < board_dim; i++)
    	{
    		for (int j = 0; j < board_dim; j++)
    		{
    			if ((i%2) == 0)
    			{
    				if ((j%2) == 0)
    					g_board[i][j] = new Cell(i, j, Cell.c_Color.BLACK);
    				else
    					g_board[i][j] = new Cell(i, j, Cell.c_Color.WHITE);
    			}
    			else
    			{
    				if ((j%2) == 1)
    					g_board[i][j] = new Cell(i, j, Cell.c_Color.BLACK);
    				else
    					g_board[i][j] = new Cell(i, j, Cell.c_Color.WHITE);

    			}
    		}       
    	}
    	initalisePiecePositions();
    }
    
    public void moveToCell(int x, int y)
    {
        g_board[x][y].setStatus(Cell.c_Status.OCCUPIED);
        g_board[x][y].consoleCell('V');
    }
    
    private void initalisePiecePositions()
    {
    	for(int i = 0; i <= 1; i++)
    	{
    		moveToCell((i*5),0);
    		moveToCell((i*5),1);
    		moveToCell((i*5),2);
    		moveToCell((i*5),3);
    		moveToCell((i*5),4);
    		moveToCell((i*5),5);
    	}
    }
    
    /*used to check if a cell is empty or not*/
    public Cell.c_Status cellCheck(int x, int y)
    {
        return g_board[x][y].getStatus();
    }

    public void moveFromCell(int x, int y)
    {
        g_board[x][y].setStatus(Cell.c_Status.EMPTY);
        g_board[x][y].setCellImage();
    }
    
    public void printBoard()
    {
        //prints three characters per square |o|
        for (int i = 0; i < (board_dim*3); i++)
        {
            System.out.printf("-");
        }
        System.out.printf("\n");
        for(int i = 0; i < board_dim; i++)
        {
            for(int j = 0; j < board_dim; j++)
            {
                System.out.printf("|%c|", g_board[i][j].getCellImage());
            
            }
            System.out.printf("\n");
            for (int n = 0; n < (board_dim*3); n++)
            {
                System.out.printf("-");
            }
            System.out.printf("\n");
        }
    }

    boolean checkBounds(int x, int y)
    {
        if (x > (board_dim -1) || x < 0 || y > (board_dim -1) || y < 0)
        {
            return false;
        }
        return true;
    }
}
