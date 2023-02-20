import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopTest {

	ChessPiece bishop;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void bishop_middle_of_board() {

		blocked.add("d5");

		bishop = new Bishop("d5", 'b', blocked, otherColorPieces);
		List<String> moves = bishop.getPossibleMoves();

		assertSame(13, moves.size());

		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("b7"));
		assertEquals(true, moves.contains("a8"));
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("f7"));

		assertEquals(true, moves.contains("g8"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("f3"));
		assertEquals(true, moves.contains("g2"));
		assertEquals(true, moves.contains("h1"));

		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("b3"));
		assertEquals(true, moves.contains("a2"));
	}

	@Test
	public void bishop_capture() {
		blocked.add("d5");
		otherColorPieces.add("e6");
		otherColorPieces.add("e4");
		otherColorPieces.add("c4");
		otherColorPieces.add("c6");

		bishop = new Bishop("d5", 'b', blocked, otherColorPieces);
		List<String> moves = bishop.getPossibleMoves();

		assertSame(4, moves.size());
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c6"));
	}

	@Test
	public void bishop_blocked() {
		blocked.add("d5");
		blocked.add("b7");
		blocked.add("f7");
		blocked.add("f3");
		blocked.add("b3");

		bishop = new Bishop("d5", 'b', blocked, otherColorPieces);
		List<String> moves = bishop.getPossibleMoves();

		assertSame(4, moves.size());
		assertEquals(true, moves.contains("e6"));
		assertEquals(true, moves.contains("e4"));
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c6"));
	}

	@Test
	public void bishop_edge_of_board() {
		blocked.add("h8");
		bishop = new Bishop("h8", 'w', blocked, otherColorPieces);
		List<String> moves = bishop.getPossibleMoves();

		assertSame(7, moves.size());
		assertEquals(true, moves.contains("g7"));
		assertEquals(true, moves.contains("f6"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("d4"));
		assertEquals(true, moves.contains("c3"));
		assertEquals(true, moves.contains("b2"));
		assertEquals(true, moves.contains("a1"));
	}
}
