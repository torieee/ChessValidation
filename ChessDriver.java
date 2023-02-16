
package Chess;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
CURRENTLY:
    Move functionality:
     - All functional pieces seem to work correctly
    Capture functionality:
     - All functional pieces seem to work correctly

    TODO: 
     - Fix driver class so it's not such a mess
     - Start looking at testing and static analysis

*/


public class ChessDriver {

    public static void main(String[] args)
    {
        startChessValidation();
    }
    
    
    public static void startChessValidation()
    {
        Board board = new Board();
        board.createBoard();
        
        //Getting user input for board positions
        String[] white = getBoardInput("WHITE");
        String[] black = getBoardInput("BLACK");
        
        //ColorPieces objects
        ColorPieces whitePieces = new ColorPieces(white);
        ColorPieces blackPieces = new ColorPieces(black);

        //Getting user input for PTM
        String pieceToMove = getPieceToMove();
        //Determine if PTM is white or black
        char color = getPTMColor(pieceToMove, white, black);
        
        List blocked;
        List otherColorSpaces;
        if(color == 'w')
        {
            blocked = Arrays.asList(whitePieces.getPiecePosition());
            otherColorSpaces = Arrays.asList(blackPieces.getPiecePosition());
        }
        else
        {
            blocked = Arrays.asList(blackPieces.getPiecePosition());
            otherColorSpaces = Arrays.asList(whitePieces.getPiecePosition());
        }
        
        //Create object of PTM based on its piece type
        ChessPiece piece = selectPieceType(pieceToMove, color, blocked, otherColorSpaces);
        //Show allowable moves of PTM
        piece.printPossibleMoves(pieceToMove, piece.getPossibleMoves());
    }
    
    //Gets input for white or black pieces and turns input into white or black array
    public static String[] getBoardInput(String color)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print(color + ": ");
        String input = scan.nextLine();
        
        //Putting current pieces into arrays
        String[] pieceArray = input.split(", ");

        //System.out.println(Arrays.toString(pieceArray));
        
        return pieceArray;
    }
    
    //Puts white and black arrays together and makes it an ArrayList
    //Returns the array list
    public static List<String> mergeArrays(String[] white, String[] black)
    {
        int length = white.length + black.length;
        int j = 0;
        String[] occupiedSpaces = new String[length];
        
        
        for (int i = 0; i < length; i++) 
        {
            if(i < white.length)
            {
                occupiedSpaces[i] = white[i];
            }
            else
            {
                occupiedSpaces[i] = black[j];
                j++;
            }
        }
        //System.out.println(Arrays.toString(occupiedSpaces));
        
        
        List blocked = Arrays.asList(occupiedSpaces);
        
        return blocked;
    }
    
    //Gets input for the piece that the user wants to move
    public static String getPieceToMove()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("PIECE TO MOVE: ");
        return scan.nextLine();
    }
    
    public static char getPTMColor(String ptm, String[] white, String[] black)
    {
        List whiteList = Arrays.asList(white);
        
        if(whiteList.contains(ptm))
        {
            return 'w';
        }
        else
        {
            return 'b';
        }
        
    }
    
    public static ChessPiece selectPieceType(String ptm, char color, List<String> blocked, List<String> otherColorSpaces)
    {
        char pieceID = ptm.charAt(0);
        String position = ptm.substring(1);
        
        switch(pieceID)
        {
            case 'K':
                return new King(position, color, blocked, otherColorSpaces);
            case 'Q':
                return new Queen(position, color, blocked, otherColorSpaces);
            case 'R':
                return new Rook(position, color, blocked, otherColorSpaces);
            case 'B':
                return new Bishop(position, color, blocked, otherColorSpaces);
            case 'N':
                return new Knight(position, color, blocked, otherColorSpaces);
            case 'P':
                return new Pawn(position, color, blocked, otherColorSpaces);
            default:
                throw new IllegalArgumentException();
        }
    }
}
