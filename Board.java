
package Chess;

public class Board {
    
    //2D array represents the boards
    String board[][] = new String[8][8];
    
    //THIS METHOD WORKS to create the board
    //To get a position of the board (STRING), its board[i][j]
    public void createBoard()
    {
        System.out.println("    ~~~~~~~~~~~~~~~~BLACK START~~~~~~~~~~~~~~~~\n");
        
        for (int i = 7; i >= 0; i--) 
        {
            char letter = 'a';
            for (int j = 0; j < 8; j++) 
            {
                board[i][j] = letter + "" + (i + 1);
                System.out.print(board[i][j] + "\t");
                letter++;
            }
            
            System.out.println("\n\n");
        }
        System.out.println("    ~~~~~~~~~~~~~~~~WHITE START~~~~~~~~~~~~~~~~\n");
    }
    

}
