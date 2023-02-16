
package Chess;

import java.util.List;

//THIS SEEMS TO WORK 


public class King extends ChessPiece{
    
    public King(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        super(pos, color, blocked, otherColorSpaces);
        
    }
    
    @Override
    protected List<String> getPossibleMoves()
    {
        getRightAndLeft();
        getUpAndDown();
        getDiagonalsUp();
        getDiagonalsDown();

        return possibleMoves;
    }
    
    
    private void getRightAndLeft()
    {
        resetTrackers("RL");
        right++;
        left--;
        
        if(checkRightLeftBounds(left) && !blockedSpaces.contains(left + "" + position[1]))
        {
            possibleMoves.add(left + "" + position[1]);
        }
        if(checkRightLeftBounds(right) && !blockedSpaces.contains(right + "" + position[1]))
        {
            possibleMoves.add(right + "" + position[1]);
        }
        
    }
    
    private void getUpAndDown()
    {
        resetTrackers("UD");
        up++;
        down--;
        
        if(checkUpperLowerBounds(down) && !blockedSpaces.contains(position[0] + "" + down))
        {
            possibleMoves.add(position[0] + "" + down);
        }
        if(checkUpperLowerBounds(up) && !blockedSpaces.contains(position[0] + "" + up))
        {
            possibleMoves.add(position[0] + "" + up);
        }
    }
    
    private void getDiagonalsUp()
    {
        resetTrackers("UD RL");
        up++;
        left--;
        right++;
        
        if(checkUpperLowerBounds(up))
        {
            if(checkRightLeftBounds(left) && !blockedSpaces.contains(left + "" + up))
            {
                possibleMoves.add(left + "" + up);
            }
            if(checkRightLeftBounds(right) && !blockedSpaces.contains(right + "" + up))
            {
                possibleMoves.add(right + "" + up);
            }
        }

    }
    
    private void getDiagonalsDown()
    {
        resetTrackers("UD RL");
        down--;
        left--;
        right++;
        
        if(checkUpperLowerBounds(down))
        {
            if(checkRightLeftBounds(left) && !blockedSpaces.contains(left + "" + down))
            {
                possibleMoves.add(left + "" + down);
            }
            if(checkRightLeftBounds(right) && !blockedSpaces.contains(right + "" + down))
            {
                possibleMoves.add(right + "" + down);
            }
        }
        
    }
    
    
}
