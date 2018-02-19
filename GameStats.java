package game;

public class GameStats {
	public static int countOfPlayerVictories;
	public static int countOfComputerVictories;
	public static int countOfGamesPlayed;
	
	public static int getCountOfPlayerVictories() {
		return countOfPlayerVictories;
	}
	
	public static void setCountOfPlayerVictories(int countOfPlayerVictories) {
		GameStats.countOfPlayerVictories = countOfPlayerVictories;
	}
	
	public static int getCountOfComputerVictories() {
		return countOfComputerVictories;
	}
	
	public static void setCountOfComputerVictories(int countOfComputerVictories) {
		GameStats.countOfComputerVictories = countOfComputerVictories;
	}

	public static void showStats() {
		System.out.println("Number of player's victories: " + countOfPlayerVictories);
		System.out.println("Number of computer's victories: " + countOfComputerVictories);
		System.out.println("Number of games played: " + countOfGamesPlayed);
	}

	public static int getGamesPlayed() {
		return countOfGamesPlayed;
	}

	public static void setGamesPlayed(int gamesPlayed) {
		GameStats.countOfGamesPlayed = gamesPlayed;
	}
	
	
}
