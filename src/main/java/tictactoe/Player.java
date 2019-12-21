package tictactoe;

import java.io.Serializable;
import java.util.Random;

public class Player implements Serializable {
	private static final long serialVersionUID = -1795151425576919304L;
	private String playerName;
	private Stats stats;

	public Player(String playerName, Stats stats) {
		this.playerName = playerName;
		this.stats = stats;
	}

	public Player() {

	}
	
	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return playerName + " " + "Wins: " + getStats().getCountOfPlayerVictories() + " Loses: "
				+ getStats().getCountOfComputerVictories() + " Games: " + getStats().getCountOfGamesPlayed();
	}

}
