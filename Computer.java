package game;

import java.util.Random;

//thread sleep so it does not go so fast?

public class Computer {
	Random random = new Random();
	
	public boolean canComputerPlaceO(Board board) {
		int fieldChoice = random.nextInt(9);
		if(board.getGameBoard()[fieldChoice].isFieldEmpty()){
			board.getGameBoard()[fieldChoice].setO();
			return true;
		}
		return false;
	}

}
