import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueenTest {

	ChessPiece queen;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void queen_middle_of_board() {
		blocked.add("d5");

		queen = new Queen("d5", 'b', blocked, otherColorPieces);
		List<String> moves = queen.getPossibleMoves();

		assertSame(27, moves.size());

		// Up and down
		assertEquals(true, moves.contains("d8"));
		assertEquals(true, moves.contains("d7"));
		assertEquals(true, moves.contains("d6"));
		assertEquals(true, moves.contains("d4"));
		assertEquals(true, moves.contains("d3"));
		assertEquals(true, moves.contains("d2"));
		assertEquals(true, moves.contains("d1"));

		assertEquals(true, moves.contains("a5"));
		assertEquals(true, moves.contains("b5"));
		assertEquals(true, moves.contains("c5"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("f5"));
		assertEquals(true, moves.contains("g5"));
		assertEquals(true, moves.contains("h5"));

		// Diagonals
		assertEquals(true, moves.contains("a8"));
		assertEquals(true, moves.contains("b7"));
		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("f3"));
		assertEquals(true, moves.contains("g2"));
		assertEquals(true, moves.contains("h1"));

		assertEquals(true, moves.contains("g8"));
		assertEquals(true, moves.contains("f7"));
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("b3"));
		assertEquals(true, moves.contains("a2"));
	}

	@Test
	public void queen_edge_of_board() {

		blocked.add("h1");
		queen = new Queen("h1", 'b', blocked, otherColorPieces);
		List<String> moves = queen.getPossibleMoves();

		assertSame(21, moves.size());

		assertEquals(true, moves.contains("h8"));
		assertEquals(true, moves.contains("h7"));
		assertEquals(true, moves.contains("h6"));
		assertEquals(true, moves.contains("h5"));
		assertEquals(true, moves.contains("h4"));
		assertEquals(true, moves.contains("h3"));
		assertEquals(true, moves.contains("h2"));

		assertEquals(true, moves.contains("a1"));
		assertEquals(true, moves.contains("b1"));
		assertEquals(true, moves.contains("c1"));
		assertEquals(true, moves.contains("d1"));
		assertEquals(true, moves.contains("e1"));
		assertEquals(true, moves.contains("f1"));
		assertEquals(true, moves.contains("g1"));

		assertEquals(true, moves.contains("a8"));
		assertEquals(true, moves.contains("b7"));
		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("d5"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("f3"));
		assertEquals(true, moves.contains("g2"));

	}

	@Test
	public void queen_capture() {
		blocked.add("d5");
		otherColorPieces.add("d6");
		otherColorPieces.add("e6");
		otherColorPieces.add("e5");
		otherColorPieces.add("e4");
		otherColorPieces.add("d4");
		otherColorPieces.add("c4");
		otherColorPieces.add("c5");
		otherColorPieces.add("c6");

		queen = new Queen("d5", 'w', blocked, otherColorPieces);
		List<String> moves = queen.getPossibleMoves();

		assertSame(8, moves.size());

		assertEquals(true, moves.contains("d6"));
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("d4"));
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c5"));
		assertEquals(true, moves.contains("c6"));

	}

	@Test
	public void queen_blocked() {
		blocked.add("d5");
		blocked.add("d6");
		blocked.add("e6");
		blocked.add("e5");
		blocked.add("e4");
		blocked.add("d4");
		blocked.add("c4");
		blocked.add("c5");
		blocked.add("c6");

		queen = new Queen("d5", 'w', blocked, otherColorPieces);
		List<String> moves = queen.getPossibleMoves();

		assertSame(0, moves.size());
	}
}
