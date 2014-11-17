package Slide;


/**
 * Game client
 */
import Slide.Board;
import java.util.Scanner;
public class SlidePuzzle
{ 
    public static void main(String[] args)
    {         
        Scanner input = new Scanner(System.in);
        boolean notWinning = true;

        //Groovy introduction.
        System.out.println("Welcome to...");
        pause(1000);
        System.out.println("|----------|");
        System.out.println("|S.L.I.D.E.|");
        System.out.println("|----------|");
        System.out.println("________________\n");

        //Create new board and display it.
        Board grid = new Board();  
        grid.populateBoard();
        System.out.println("Solved board:");
        pause(1000);
        System.out.println(grid);

        //Now, shuffle the board.
        System.out.println("Shuffling...");
        pause(2000);
        System.out.println("Done!\n");
        pause(40);
        grid.shuffle();
        System.out.println(grid); 
        System.out.println("You can type '?' to quit if you are as confused as a wittle baby.");
        
        //The game continues until the user wins or quits.
        while (!grid.solved())
        {            
            System.out.print("Pick a letter to move: ");
            //If a letter is entered, the game analyzes it as a possible move.
            //If anything else is entered, the game exits.
            boolean looping = true;
            while(looping)
            {
                try{
                    char move = input.next().toUpperCase().charAt(0);
                    if (move == '?') { 
                        System.out.println("He that fights and runs away... is ashamed the game has won this day.");
                        return; 
                    }
                    grid.move(move);    
                    looping = false;
                } catch (Exception e) {
                    System.out.print("That's not a legal move! Try again: ");
                }
            }

            System.out.println(grid);            
        }
        
        System.out.println("Booyah! You win 50,000 acorns!");           

    }
    public static void pause(int delay)
    {
        try{
            Thread.sleep(delay);
        }catch(InterruptedException e){}
    }
}
