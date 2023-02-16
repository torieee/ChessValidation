
package Chess;

import java.util.ArrayList;
import java.util.List;


//Parent class for Pawn, Bishop, Knight, Rook, Queen, and King
public abstract class ChessPiece {
    
    protected ArrayList<String> possibleMoves;
    protected char[] position;
    protected char color, right, left, up, down;
    protected int start;
    protected List<String> blockedSpaces; //same color
    protected List<String> otherColorSpaces;
    
    
    
    public ChessPiece(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        this.possibleMoves = new ArrayList<>();
        this.position = pos.toCharArray();
        this.color = color;
        this.blockedSpaces = blocked;
        this.otherColorSpaces = otherColorSpaces;
        this.right = position[0];
        this.left = position[0];
        this.up = position[1];
        this.down = position[1];
        
        if(color == 'w')
        {
            start = 1;
        }
        else
        {
            start = 8;
        }
    }
    
    protected List<String> getPossibleMoves()
    {
        return possibleMoves;
    }
    
    protected void resetTrackers(String delim)
    {
        if(delim.contains("RL"))
        {
            this.right = position[0];
            this.left = position[0];
        }
        if(delim.contains("UD"))
        {
            this.up = position[1];
            this.down = position[1];
        }
    }
    
    protected void printPossibleMoves(String ptm, List<String> moves)
    {
        String c;
        if(color == 'w')
        {
            c = "WHITE";
        }
        else
        {
            c = "BLACK";
        }
        
        System.out.println("LEGAL MOVES FOR " + c + " " + ptm + ": " + moves.toString());
    }
    
    //Numbers
    protected boolean checkUpperLowerBounds(char ud)
    {
        return ud > 48 && ud < 57;
    }
    
    //Letters
    protected boolean checkRightLeftBounds(char rl)
    {
        return rl > 96 && rl < 105;
    }
}
