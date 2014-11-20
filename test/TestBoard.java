import static org.junit.Assert.*;

import org.junit.Test;


public class TestBoard {
	
	Board board = new Board();
	
	@Test
	public void testAnlegen() {
		assertFalse(board.hasWinner());
	}
	
	@Test
	public void setValidMarkWithoutWinner() throws InvalidPositionException{
		board.setMark("X", 1, 0);

		assertFalse(board.hasWinner());
	}
	
	@Test
	public void setValidMarkWithWinner() throws InvalidPositionException {
		board.setMark("X", 0, 0);
		board.setMark("X", 1, 1);
		board.setMark("X", 2, 2);
		
		assertTrue(board.hasWinner());
	}
	
	@Test (expected = InvalidPositionException.class)
	public void setInvalidMarkSign() throws InvalidPositionException {
		board.setMark("P", 0, 0);
	}
	
	@Test (expected = InvalidPositionException.class)
	public void setInvalidMarkPosition() throws InvalidPositionException {
		board.setMark("X", 4, 0);
	}
}
