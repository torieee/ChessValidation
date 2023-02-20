import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessDriverTest {

	ChessDriver driver;
	ScannerWrapper scannerWrapper;

	@BeforeEach
	public void setup() {
		driver = new ChessDriver();
		scannerWrapper = ScannerWrapper.getInstance();
	}

	@Test
	public void driver_board1() {
		String whiteInput = "Pf7, Nb6, Bd4, Rf4, Pb2";
		String blackInput = "Kd8, Bc4, Ne5, Pg5, Qg2";
		String ptm = "Pf7";

		driver.startChessValidation(scannerWrapper);
		InputStream inputStreamWhite = new ByteArrayInputStream(whiteInput.getBytes());
		System.setIn(inputStreamWhite);

		InputStream inputStreamBlack = new ByteArrayInputStream(blackInput.getBytes());
		System.setIn(inputStreamBlack);

		InputStream inputPTM = new ByteArrayInputStream(ptm.getBytes());
		System.setIn(inputPTM);

	}
}
