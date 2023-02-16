
package Chess;

import java.util.List;

public class Pawn extends ChessPiece{
    

    public Pawn(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        super(pos, color, blocked, otherColorSpaces);
        
    }

    @Override
    protected List<String> getPossibleMoves()
    {
        forward();
        capture();
        
        return possibleMoves;
    }
    
    
    private void forward()
    {
        resetTrackers("UD");
        if(color == 'w')
        {
            up++;
            String currentPos = right + "" + up;
            
            if(!blockedSpaces.contains(currentPos) && !otherColorSpaces.contains(currentPos) && checkUpperLowerBounds(up))
            {
                possibleMoves.add(currentPos);
                
                up++;
                currentPos = right + "" + up;
                if(position[1] == '2' && !blockedSpaces.contains(currentPos) && !otherColorSpaces.contains(currentPos))
                {
                    possibleMoves.add(currentPos);
                }
            }
        }
        else //black
        {
            down--;
            String currentPos = right + "" + down;
            
            if(!blockedSpaces.contains(currentPos) && !otherColorSpaces.contains(currentPos) && checkUpperLowerBounds(down))
            {
                possibleMoves.add(currentPos);
                
                down--;
                currentPos = right + "" + down;
                if(position[1] == '7' && !blockedSpaces.contains(currentPos) && !otherColorSpaces.contains(currentPos))
                {
                    possibleMoves.add(currentPos);
                }
            }       
        }
    }
    
    private void capture()
    {
        resetTrackers("UD RL");
        
        if(color == 'w')
        {
            up++;
            right++;
            String upRight = right + "" + up;
            if(otherColorSpaces.contains(upRight))
            {
                possibleMoves.add(upRight);
            }
            
            resetTrackers("UD RL");
            up++;
            left--;
            String upLeft = left + "" + up;
            if(otherColorSpaces.contains(upLeft))
            {
                possibleMoves.add(upLeft);
            }
        }
        else
        {
            down--;
            right++;
            String downRight = right + "" + down;
            if(otherColorSpaces.contains(downRight))
            {
                possibleMoves.add(downRight);
            }
            
            resetTrackers("UD RL");
            down--;
            left--;
            String downLeft = left + "" + down;
            if(otherColorSpaces.contains(downLeft))
            {
                possibleMoves.add(downLeft);
            }
        }
    }
    
    
}
