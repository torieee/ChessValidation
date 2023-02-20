import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest {
	ChessPiece pawn;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void pawn_first_move_white() {

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

		pawn = new Pawn("b2", 'w', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(2, moves.size());
		assertEquals(true, moves.contains("b3"));
		assertEquals(true, moves.contains("b4"));
	}

	@Test
	public void pawn_first_move_black() {
		blocked.add("b7");
		otherColorPieces.add("g5");

		pawn = new Pawn("b7", 'b', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(2, moves.size());
		assertEquals(true, moves.contains("b6"));
		assertEquals(true, moves.contains("b6"));
	}

	@Test
	public void pawn_edge_of_board_white() {
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

		pawn = new Pawn("f7", 'w', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(1, moves.size());
		assertEquals(true, moves.contains("f8"));
	}

	@Test
	public void pawn_edge_of_board_black() {
		blocked.add("g2");
		otherColorPieces.add("f6");

		pawn = new Pawn("g2", 'b', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(1, moves.size());
		assertEquals(true, moves.contains("g1"));
	}

	@Test
	public void pawn_capture_white() {
		blocked.add("b3");
		otherColorPieces.add("c4");

		pawn = new Pawn("b3", 'w', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(2, moves.size());
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("b4"));
	}

	@Test
	public void pawn_capture_black() {
		otherColorPieces.add("f7");
		otherColorPieces.add("b6");
		otherColorPieces.add("d4");
		otherColorPieces.add("f4");
		otherColorPieces.add("b2");

		blocked.add("d8");
		blocked.add("c4");
		blocked.add("e5");
		blocked.add("g5");
		blocked.add("g2");

		pawn = new Pawn("g5", 'b', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(2, moves.size());
		assertEquals(true, moves.contains("g4"));
		assertEquals(true, moves.contains("f4"));
	}

	@Test
	public void pawn_move_without_impediments_white() {
		blocked.add("d5");
		pawn = new Pawn("d5", 'w', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(1, moves.size());
		assertEquals(true, moves.contains("d6"));
	}

	@Test
	public void pawn_move_without_impediments_black() {
		blocked.add("d5");
		pawn = new Pawn("d5", 'b', blocked, otherColorPieces);
		List<String> moves = pawn.getPossibleMoves();

		assertSame(1, moves.size());
		assertEquals(true, moves.contains("d4"));
	}
}
