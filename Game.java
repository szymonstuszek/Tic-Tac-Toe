package game;

import java.util.Random;

public class Game {
	private Random random;
	private Board board;
	private Control control;
	private Rules rules;
	private Computer computer;
	
	public Game() {
		board = new Board();
		control = new Control();
		rules = new Rules();
		computer = new Computer();
		random = new Random();
		System.out.println("Game board");
		board.displayBoard();
		
		gameLoop();
	}
	
	
	public void gameLoop() {
		int turn = random.nextInt(2);
		
		while(Rules.gameRunning) {
			if(turn%2 == 0){
				while(!control.canIPlaceX(board));
				if(rules.isGameOver(board)) {
				}
			}
			
			if(turn%2 != 0){
				while(!computer.canComputerPlaceO(board));
				if(rules.isGameOver(board)) {
				}
			}
			board.displayBoard();
			turn++;
		}
	}
}
