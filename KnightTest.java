import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {

	ChessPiece knight;
	List<String> blocked, otherColorPieces;

	@BeforeEach
	public void setup() {
		blocked = new ArrayList<>();
		otherColorPieces = new ArrayList<>();
	}

	@Test
	public void knight_middle_of_board() {

		blocked.add("e5");
		otherColorPieces.add("h8");

		knight = new Knight("e5", 'b', blocked, otherColorPieces);
		List<String> moves = knight.getPossibleMoves();

		assertSame(8, moves.size());

		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("d7"));
		assertEquals(true, moves.contains("f7"));
		assertEquals(true, moves.contains("g6"));
		assertEquals(true, moves.contains("g4"));
		assertEquals(true, moves.contains("f3"));
		assertEquals(true, moves.contains("d3"));
		assertEquals(true, moves.contains("c4"));

	}

	@Test
	public void knight_edge_of_board() {
		blocked.add("a1");
		otherColorPieces.add("h8");

		knight = new Knight("a1", 'w', blocked, otherColorPieces);
		List<String> moves = knight.getPossibleMoves();

		assertSame(2, moves.size());

		assertEquals(true, moves.contains("b3"));
		assertEquals(true, moves.contains("c2"));

	}

	@Test
	public void knight_capture() {

		otherColorPieces.add("f7");
		otherColorPieces.add("g6");
		otherColorPieces.add("g4");
		otherColorPieces.add("f3");
		otherColorPieces.add("d3");
		otherColorPieces.add("c4");
		otherColorPieces.add("c6");
		otherColorPieces.add("d7");

		blocked.add("e5");

		knight = new Knight("e5", 'b', blocked, otherColorPieces);
		List<String> moves = knight.getPossibleMoves();
		assertSame(8, moves.size());

		assertEquals(true, moves.contains("f7"));
		assertEquals(true, moves.contains("g6"));
		assertEquals(true, moves.contains("g4"));
		assertEquals(true, moves.contains("f3"));
		assertEquals(true, moves.contains("d3"));
		assertEquals(true, moves.contains("c4"));
		assertEquals(true, moves.contains("c6"));
		assertEquals(true, moves.contains("d7"));
	}

	@Test
	public void knight_blocked() {
		blocked.add("f7");
		blocked.add("g6");
		blocked.add("g4");
		blocked.add("f3");
		blocked.add("d3");
		blocked.add("c4");
		blocked.add("c6");
		blocked.add("d7");
		blocked.add("e5");

		knight = new Knight("e5", 'b', blocked, otherColorPieces);
		List<String> moves = knight.getPossibleMoves();
		assertSame(0, moves.size());
	}

}
