
package Chess;

import java.util.List;

public class Queen extends ChessPiece {
    
    
    public Queen(String pos, char color, List<String> blocked, List<String> otherColorSpaces)
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
        
        upRight();
        downRight();
        upLeft();
        downLeft();
        
        return possibleMoves;
    }
    
    
    protected void up()
    {
        for (int i = (position[1] + 1); i <= 56; i++) 
        {
            String currentSpace = position[0] + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void down()
    {
        for (int i = (position[1] - 1); i >= 49; i--) 
        {
            String currentSpace = position[0] + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void left()
    {
        for (int i = (position[0] - 1); i >= 97; i--) 
        {
            String currentSpace = (char)i + "" + position[1];
            
            if(blockedSpaces.contains(currentSpace))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void right()
    {
        for (int i = (position[0] + 1); i <= 104; i++) 
        {
            String currentSpace = (char)i + "" + position[1];
            
            if(blockedSpaces.contains(currentSpace))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void upRight()
    {
        int j = position[0];
        
        for (int i = (position[1] + 1); i <= 56; i++) 
        {
            j++;
            
            String currentSpace = (char)j + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace) || !checkRightLeftBounds((char)j))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            
            possibleMoves.add(currentSpace);
        }    
    }
    
    protected void downRight()
    {
        int j = position[0];
        for (int i = (position[1] - 1); i >= 49; i--) 
        {
            j++;
            
            String currentSpace = (char)j + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace) || !checkRightLeftBounds((char)j))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void upLeft()
    {
        int j = position[0];
        for (int i = (position[1] + 1); i <= 56; i++) 
        {
            j--;
            
            String currentSpace = (char)j + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace) || !checkRightLeftBounds((char)j))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
        }
    }
    
    protected void downLeft()
    {
        int j = position[0];
        for (int i = (position[1] - 1); i >= 49; i--) 
        {
            j--;
            
            String currentSpace = (char)j + "" + (char)i;
            
            if(blockedSpaces.contains(currentSpace) || !checkRightLeftBounds((char)j))
            {
                break;
            }
            else if(otherColorSpaces.contains(currentSpace))
            {
                possibleMoves.add(currentSpace);
                break;
            }
            possibleMoves.add(currentSpace);
            
        }
    }
}
