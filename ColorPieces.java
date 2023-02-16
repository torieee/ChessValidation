
package Chess;

public class ColorPieces {
    
    private String[] pieces;
    private String[] positions;
    
    public ColorPieces(String[] listOfPieces)
    {
        this.pieces = listOfPieces;
        this.positions = new String[listOfPieces.length];
    }
    
    public String[] getPiecePosition()
    {
        for (int i = 0; i < pieces.length; i++) 
        {
            this.positions[i] = pieces[i].substring(1);
        }
        
        
        //System.out.println(Arrays.toString(positions));
        
        return positions;
    }
    
    
    
}
