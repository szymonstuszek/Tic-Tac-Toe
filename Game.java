package game;

import java.util.Random;

public class Game {
	private Random random;
	private Board board;
	private Player player;
	private Rules rules;
	private Computer computer;
	
	public static boolean gameRunning = true;
	
	public Game() {
		GameStats.countOfGamesPlayed++;
		board = new Board();
		player = new Player();
		computer = new Computer();
		random = new Random();
		System.out.println("Game board");
		board.displayBoard();
		
		gameLoop();
	}
	
	
	public void gameLoop() {
		int turn = random.nextInt(2);
		
		while(gameRunning) {
			if(turn%2 == 0){
				while(!player.canIPlaceX(board));
				if(Rules.isGameOver(board)) {
				}
			}
			
			if(turn%2 != 0){
				while(!computer.canComputerPlaceO(board));
				if(Rules.isGameOver(board)) {
				}
			}
			board.displayBoard();
			turn++;
		}
	}
	
	public static void endGame() {
		
	}
}
