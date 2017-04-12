public class Cell{
    public enum c_Color
    {
        WHITE, BLACK
    }; 

    public enum c_Status
    {
        EMPTY, OCCUPIED
    };

    private int xpos, ypos;
    private Cell.c_Color cell_color;     
    private c_Status cell_status;
    private char cell_image;

    public Cell(int xpos, int ypos, c_Color cell_color)
    {
        this.xpos = xpos;   
        this.ypos = ypos;
        this.cell_color = cell_color;
        cell_status = Cell.c_Status.EMPTY;       
        setCellImage();
    }

    public boolean checkCoOrd(int x, int y)
    {
    	if(xpos == x && ypos == y)
    		return true;
    	return false;
    }

    public int getX()
    {
    	return xpos;    	
    }
    
    public int getY()
    {
    	return ypos;
    }
    
    public Cell.c_Color getCellColor()
    {
    	return cell_color;
    }
    
    public Cell.c_Status getStatus()
    {
        return cell_status;
    }

    public void setStatus(Cell.c_Status status)
    {
       cell_status = status;
    }

    public char getCellImage()
    {
        return cell_image;
    }

    void setCellImage()
    {
        if (cell_color == Cell.c_Color.BLACK)
        {
            cell_image = '/';
        }
        else
        {
            cell_image = '0';
        }
    }
    
    void consoleCell(char c)
    {
    	cell_image = c;
    }
}
