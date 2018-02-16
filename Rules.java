package game;

public class Rules {
	public static boolean gameRunning = true;
	
	public boolean isGameOver(Board board) {
		if(checkIfOWins(board)){
			System.out.println("Player with O wins!");
			gameRunning = false;
			return true;
		}
		
		if(checkIfXWins(board)){
			System.out.println("Player with X wins!");
			gameRunning = false;
			return true;
		}
		
		if(checkIfDraw(board)) {
			System.out.println("Draw!");
			gameRunning = false;
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfDraw(Board board) {
		int occupiedFields = 0;
		for(int i = 0; i<9;i++) {
			if(!board.getGameBoard()[i].isFieldEmpty()){
				occupiedFields++;
			};
		}
		if(occupiedFields == 9) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfOWins(Board board) {
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[1].isO() && board.getGameBoard()[2].isO()) {
			return true;
		}
		if(board.getGameBoard()[3].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[5].isO()) {
			return true;
		}
		if(board.getGameBoard()[6].isO() && board.getGameBoard()[7].isO() && board.getGameBoard()[8].isO()) {
			return true;
		}
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[3].isO() && board.getGameBoard()[6].isO()) {
			return true;
		}
		if(board.getGameBoard()[1].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[7].isO()) {
			return true;
		}
		if(board.getGameBoard()[2].isO() && board.getGameBoard()[5].isO() && board.getGameBoard()[8].isO()) {
			return true;
		}
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[8].isO()) {
			return true;
		}
		if(board.getGameBoard()[2].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[6].isO()) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfXWins(Board board) {
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[1].isX() && board.getGameBoard()[2].isX()) {
			return true;
		}
		if(board.getGameBoard()[3].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[5].isX()) {
			return true;
		}
		if(board.getGameBoard()[6].isX() && board.getGameBoard()[7].isX() && board.getGameBoard()[8].isX()) {
			return true;
		}
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[3].isX() && board.getGameBoard()[6].isX()) {
			return true;
		}
		if(board.getGameBoard()[1].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[7].isX()) {
			return true;
		}
		if(board.getGameBoard()[2].isX() && board.getGameBoard()[5].isX() && board.getGameBoard()[8].isX()) {
			return true;
		}
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[8].isX()) {
			return true;
		}
		if(board.getGameBoard()[2].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[6].isX()) {
			return true;
		}
		return false;
	}
	
	

}
