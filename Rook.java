
package Chess;

import java.util.List;

//Rooks can go up and down and right and left

public class Rook extends Queen{
    
    public Rook(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        super(pos, color, blocked, otherColorSpaces);
        
    }
    
    @Override
    protected List<String> getPossibleMoves()
    {
        up();
        down();
        left();
        right();
        return possibleMoves;
    }
}
