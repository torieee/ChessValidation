import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingTest {
	ChessPiece king;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void king_edge_of_board() {

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

		king = new King("d8", 'b', blocked, otherColorPieces);
		List<String> moves = king.getPossibleMoves();
		assertSame(5, moves.size());
		assertEquals(true, moves.contains("c8"));
		assertEquals(true, moves.contains("c7"));
		assertEquals(true, moves.contains("d7"));
		assertEquals(true, moves.contains("e7"));
		assertEquals(true, moves.contains("e8"));
	}

	@Test
	public void king_middle_of_board() {
		blocked.add("d5");
		otherColorPieces.add("h8");

		king = new King("d5", 'w', blocked, otherColorPieces);
		List<String> moves = king.getPossibleMoves();

		assertSame(8, moves.size());

		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c5"));
		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("d6"));
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("d4"));
	}

	@Test
	public void king_capture() {
		blocked.add("d5");
		otherColorPieces.add("e5");
		otherColorPieces.add("e4");
		otherColorPieces.add("d4");
		otherColorPieces.add("c4");
		otherColorPieces.add("c5");
		otherColorPieces.add("c6");
		otherColorPieces.add("d6");
		otherColorPieces.add("e6");

		king = new King("d5", 'w', blocked, otherColorPieces);
		List<String> moves = king.getPossibleMoves();

		assertSame(8, moves.size());

		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c5"));
		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("d6"));
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("d4"));
	}

	@Test
	public void king_blocked() {
		blocked.add("h1");
		blocked.add("h2");
		blocked.add("g1");
		blocked.add("g2");

		king = new King("h1", 'w', blocked, otherColorPieces);
		List<String> moves = king.getPossibleMoves();

		assertSame(0, moves.size());

	}
}
