
package Chess;

import java.util.List;

public class Knight extends ChessPiece{
    
    public Knight(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        super(pos, color, blocked, otherColorSpaces);
        
    }
    
    @Override
    protected List<String> getPossibleMoves()
    {
        up1Right2();
        up2Right1();
        up1Left2();
        up2Left1();
        
        down1Right2();
        down2Right1();
        down1Left2();
        down2Left1();
        
        
        return possibleMoves;
    }
   
    private void add(String move)
    {
        if(!blockedSpaces.contains(move))
        {
            possibleMoves.add(move);
        }
    }
    
    private void up1Right2()
    {
        resetTrackers("UD RL");
        
        up++;
        right += 2;
        
        if(checkUpperLowerBounds(up) && checkRightLeftBounds(right))
        {
            String move = right + "" + up;
            add(move);
        }
    }
    
    private void up2Right1()
    {
        resetTrackers("UD RL");
        
        up += 2;
        right++;
        
        if(checkUpperLowerBounds(up) && checkRightLeftBounds(right))
        {
            String move = right + "" + up;
            add(move);
        }
    }
    
    private void up1Left2()
    {
        resetTrackers("UD RL");
        
        up++;
        left -= 2;
        
        if(checkUpperLowerBounds(up) && checkRightLeftBounds(left))
        {
            String move = left + "" + up;
            add(move);
        }
    }
    
    private void up2Left1()
    {
        resetTrackers("UD RL");
        
        up += 2;
        left--;
        
        if(checkUpperLowerBounds(up) && checkRightLeftBounds(left))
        {
            String move = left + "" + up;
            add(move);
        }
    }
    
    private void down1Right2()
    {
        resetTrackers("UD RL");
        
        down--;
        right += 2;
        
        if(checkUpperLowerBounds(down) && checkRightLeftBounds(right))
        {
            String move = right + "" + down;
            add(move);
        }
    }
    
    private void down2Right1()
    {
        resetTrackers("UD RL");
        
        down -= 2;
        right++;
        
        if(checkUpperLowerBounds(down) && checkRightLeftBounds(right))
        {
            String move = right + "" + down;
            add(move);
        }
    }
    
    private void down1Left2()
    {
        resetTrackers("UD RL");
        
        down--;
        left -= 2;
        
        if(checkUpperLowerBounds(down) && checkRightLeftBounds(left))
        {
            String move = left + "" + down;
            add(move);
        }
    }
    
    private void down2Left1()
    {
        resetTrackers("UD RL");
        
        down -= 2;
        left--;
        
        if(checkUpperLowerBounds(down) && checkRightLeftBounds(left))
        {
            String move = left + "" + down;
            add(move);
        }
    }

}

