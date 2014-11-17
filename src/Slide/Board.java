package Slide;


/**
 * The board
 */
public class Board 
{
    int blank; //Marks location of blank tile.
    final int rowsCols = 3;    
    final String LETTERS = "ABCDEFGH ";
    private Piece[][] grid;   

    //Constructor
    public Board()
    {             
        grid = new Piece[rowsCols][rowsCols];

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++){            
                grid[i][j] = new Piece();                
        }
    }       

    //Creates the board in standard(solved) position.
    public void populateBoard()
    {           
        int count = 0;
        blank = 8;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j].setPosition(count);
                grid[i][j].setName(LETTERS.charAt(count));
                count++;
        }      
    }

    //Shuffles position of puzzle.
    public void shuffle()
    {        
        for (int i = 0; i < 1000; i++){            
            int randomPosition1 = (int)(Math.random() * 8.99); //Random num between 0 and 8.
            int randomPosition2 = (int)(Math.random() * 8.99);               

            //Swaps name of two random Pieces.
            swap(randomPosition1, randomPosition2);
        }
    }

    //Swaps the name of the blank Piece with the name of an adjacent Piece.
    public void move(char c)
    {        
        if (adjToBlank(c)){
            swap(pieceCalled(c).position, blank);
        }
        else
            System.out.println("Whoah! You can't do that!");
    }    

    //Determines whether all tiles are in starting positions.
    public boolean solved()
    {
        int count = 0;
        for (int i = 0; i < rowsCols; i++){
            for (int j = 0; j < rowsCols; j++){
                if (grid[i][j].name != LETTERS.charAt(count)){
                    return false;            
                }
                count++;
            }
        }
        return true;           
    }   

    //toString method for displaying board.
    public String toString()
    {       
        for (int i = 0; i < rowsCols; i++){            
            for (int j = 0; j < rowsCols; j++){
                System.out.print("|");
                System.out.print(grid[i][j].getName() + "  ");
            }
            System.out.println("|"); 
        }
        return "";
    }

    //Returns the Piece with the specified name.
    private Piece pieceCalled(char name)
    {
        for (int i = 0; i < rowsCols; i++){
            for (int j = 0; j < rowsCols; j++){
                if (grid[i][j].name == name)                
                    return grid[i][j];
            }
        }
        return null;
    }

    //Return the Piece with the specified position.
    private Piece pieceAt(int position)
    {
        for (int i = 0; i < rowsCols; i++){
            for (int j = 0; j < rowsCols; j++){
                if (grid[i][j].position == position)
                    return grid[i][j];
            }
        }
        return null;
    }

    //Swaps the names of two Piece objects.
    private void swap(int position1, int position2)
    {        
        //Keep track of what position the blank Piece is in.
        if (pieceAt(position1).name == ' ')
            blank = pieceAt(position2).position;
        else if (pieceAt(position2).name == ' ')
            blank = pieceAt(position1).position; 

        char temp = pieceAt(position1).name;
        pieceAt(position1).name = pieceAt(position2).name;
        pieceAt(position2).name = temp;        
    }   

    private boolean adjToBlank(char c)
    {
        int p = pieceCalled(c).position;
        if ((blank == 2 && p == 3) || (blank == 5 && p == 6))
            return false;
        else if ((blank == 0 && p == 6) || (blank == 1 && p == 7) || (blank == 2 && p == 8))
            return false;
        else if ((blank == 3 && p == 2) || (blank == 6 && p == 5))
            return false;
        else if ((blank == 6 && p == 0) || (blank == 7 && p == 1) || (blank == 8 && p == 2))
            return false;
        else if ((blank - 3 != p) && (blank + 3 != p) && (blank - 1 != p) && (blank + 1 != p))
            return false;
        else
            return true;
    }
}