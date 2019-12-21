package tictactoe;

import java.io.Serializable;

public class Stats implements Serializable {
	private static final long serialVersionUID = -986223748475117735L;
		private int countOfPlayerVictories;
		private int countOfComputerVictories;
		private int countOfGamesPlayed;
		
		public Stats(int countOfPlayerVictories, int countOfComputerVictories, int countOfGamesPlayed) {
			this.countOfPlayerVictories = countOfPlayerVictories;
			this.countOfComputerVictories = countOfComputerVictories;
			this.countOfGamesPlayed = countOfGamesPlayed;
		}
		
		public Stats() {
			
		}
		
		public void playerWins() {
			countOfPlayerVictories++;
		}
		
		public void computerWins() {
			countOfComputerVictories++;
		}
		
		public void gamePlayed() {
			countOfGamesPlayed++;
		}
		
		public int getCountOfPlayerVictories() {
			return countOfPlayerVictories;
		}
		public void setCountOfPlayerVictories(int countOfPlayerVictories) {
			this.countOfPlayerVictories = countOfPlayerVictories;
		}
		public int getCountOfComputerVictories() {
			return countOfComputerVictories;
		}
		public void setCountOfComputerVictories(int countOfComputerVictories) {
			this.countOfComputerVictories = countOfComputerVictories;
		}
		public int getCountOfGamesPlayed() {
			return countOfGamesPlayed;
		}
		public void setCountOfGamesPlayed(int countOfGamesPlayed) {
			this.countOfGamesPlayed = countOfGamesPlayed;
		}
		
		@Override
		public String toString() {
			return "Game Stats [countOfPlayerVictories=" + countOfPlayerVictories + ", countOfComputerVictories="
					+ countOfComputerVictories + ", countOfGamesPlayed=" + countOfGamesPlayed + "]";
		}
}
