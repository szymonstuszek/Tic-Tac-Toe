package game;

import java.util.Scanner;

public class GameControl {
	public static final int EXIT = 0;
	public static final int PLAY = 1;
	public static final int STATS = 2;
	
	private Game game;
	
	private int option;
	private boolean menuRunning = true;
	
	public GameControl() {
		while(menuRunning) {
			gameMenu();
		}
	}
	
	public static void printMenu() {
		System.out.println("Choose option:");
		System.out.println("1 - Play");
		System.out.println("2 - Show statistics");
		System.out.println("0 - Exit");
	}
	
	
	public void gameMenu() {
		Scanner sc = new Scanner(System.in);
		printMenu();
		
		option = sc.nextInt();
		
		switch(option) {
		case EXIT:
			quitGame();
			break;
		case PLAY:
			game = new Game();
			break;
		case STATS:
			GameStats.showStats();
			break;
		}
		
	}
	
	public void quitGame() {
		menuRunning = false;
	}
	
	public void showStats() {
		System.out.println("Showing stats");
	}

}
