package game;

public class Board {
	private Field[] gameBoard;
	
	public Board() {
		gameBoard = new Field[9];
		createGameBoard();
	}
	
	public Field[] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Field[] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public void createGameBoard() {
		for(int i = 0;i <9;i++) {
			gameBoard[i] = new Field();
		}		
	}
	
	public void displayBoard() {
		System.out.println();
		for(int i = 6;i <9;i++) {
			System.out.print(gameBoard[i]);
		}	
		System.out.println();
		for(int i = 3;i <6;i++) {
			System.out.print(gameBoard[i]);
		}	
		System.out.println();
		for(int i = 0;i <3;i++) {
			System.out.print(gameBoard[i]);
		}	
		System.out.println();
	}
}
