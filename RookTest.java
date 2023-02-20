import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RookTest {
	ChessPiece rook;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void rook_middle_of_board() {
		blocked.add("d5");

		rook = new Rook("d5", 'b', blocked, otherColorPieces);
		List<String> moves = rook.getPossibleMoves();

		assertSame(14, moves.size());

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

	}

	@Test
	public void rook_edge_of_board() {
		blocked.add("a8");

		rook = new Rook("a8", 'w', blocked, otherColorPieces);
		List<String> moves = rook.getPossibleMoves();

		assertSame(14, moves.size());

		assertEquals(true, moves.contains("b8"));
		assertEquals(true, moves.contains("c8"));
		assertEquals(true, moves.contains("d8"));
		assertEquals(true, moves.contains("e8"));
		assertEquals(true, moves.contains("f8"));
		assertEquals(true, moves.contains("g8"));
		assertEquals(true, moves.contains("h8"));

		assertEquals(true, moves.contains("a1"));
		assertEquals(true, moves.contains("a2"));
		assertEquals(true, moves.contains("a3"));
		assertEquals(true, moves.contains("a4"));
		assertEquals(true, moves.contains("a5"));
		assertEquals(true, moves.contains("a6"));
		assertEquals(true, moves.contains("a7"));
	}

	@Test
	public void rook_capture() {
		blocked.add("d5");
		otherColorPieces.add("d6");
		otherColorPieces.add("e5");
		otherColorPieces.add("c5");
		otherColorPieces.add("d4");

		rook = new Rook("d5", 'w', blocked, otherColorPieces);
		List<String> moves = rook.getPossibleMoves();

		assertSame(4, moves.size());

		assertEquals(true, moves.contains("d6"));
		assertEquals(true, moves.contains("e5"));
		assertEquals(true, moves.contains("c5"));
		assertEquals(true, moves.contains("d4"));

	}

	@Test
	public void rook_blocked() {
		blocked.add("d5");
		blocked.add("d6");
		blocked.add("e5");
		blocked.add("c5");
		blocked.add("d4");

		rook = new Rook("d5", 'w', blocked, otherColorPieces);
		List<String> moves = rook.getPossibleMoves();

		assertSame(0, moves.size());
	}

}
