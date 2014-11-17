package Slide;

/**
 * Square
 */
public class Piece 
{
    public char name;
    public int position;
    
    //Accessors
    public char getName() { return name; }
    public int getPosition() { return position; }
    
    //Mutators
    public void setName(char name) { this.name = name; }
    public void setPosition(int position) { this.position = position; }    
    
    
    public String toString()
    {
        String r = "";
        r += "Position: " + position + ". Name: " + name + ".";
        return r;
    }
}
