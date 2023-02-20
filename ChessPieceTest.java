import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessPieceTest {

	ChessPiece chessPiece;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();

		blocked.add("f7");
		blocked.add("b6");
		blocked.add("d4");
		blocked.add("f4");
		blocked.add("b2");

		otherColorPieces.add("d8");
		otherColorPieces.add("c4");
		otherColorPieces.add("e5");
		otherColorPieces.add("g5");
		otherColorPieces.add("g2");

		chessPiece = new ChessPiece("f7", 'w', blocked, otherColorPieces);

	}

	@Test
	public void chessPiece_getPossibleMoves() {

		List<String> moves = chessPiece.getPossibleMoves();
		assertSame(0, moves.size());
	}

	@Test
	public void chessPiece_resetTrackers_RL() {

		chessPiece.right++;
		chessPiece.down--;

		chessPiece.resetTrackers("RL");
		assertSame(chessPiece.position[0], chessPiece.right);
		assertSame(chessPiece.position[0], chessPiece.left);

	}

	@Test
	public void chessPiece_resetTrackers_UD() {

		chessPiece.up++;
		chessPiece.down--;

		chessPiece.resetTrackers("UD");
		assertSame(chessPiece.position[1], chessPiece.up);
		assertSame(chessPiece.position[1], chessPiece.down);
	}

	@Test
	public void chessPiece_printPossibleMoves() {
		String posMoves = chessPiece.printPossibleMoves("Kd4", chessPiece.getPossibleMoves());
		assertEquals("LEGAL MOVES FOR WHITE Kd4: []", posMoves);
	}

	@Test
	public void chessPiece_checkUpperLowerBounds() {
		Boolean ud1 = chessPiece.checkUpperLowerBounds('9');
		Boolean ud2 = chessPiece.checkUpperLowerBounds('0');
		Boolean ud3 = chessPiece.checkUpperLowerBounds('8');
		Boolean ud4 = chessPiece.checkUpperLowerBounds('1');

		assertSame(false, ud1);
		assertSame(false, ud2);
		assertSame(true, ud3);
		assertSame(true, ud4);
	}

	@Test
	public void chessPiece_checkRightLeftBounds() {
		Boolean rl1 = chessPiece.checkRightLeftBounds('`');
		Boolean rl2 = chessPiece.checkRightLeftBounds('i');
		Boolean rl3 = chessPiece.checkRightLeftBounds('a');
		Boolean rl4 = chessPiece.checkRightLeftBounds('h');

		assertSame(false, rl1);
		assertSame(false, rl2);
		assertSame(true, rl3);
		assertSame(true, rl4);
	}

}
