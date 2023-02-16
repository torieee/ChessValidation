
package Chess;

import java.util.List;

public class Bishop extends Queen{
    
    public Bishop(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        super(pos, color, blocked, otherColorSpaces);
    }
    
    @Override
    protected List<String> getPossibleMoves()
    {
        upRight();
        downRight();
        upLeft();
        downLeft();
        return possibleMoves;
    }
    
}
