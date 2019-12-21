package tictactoe;

import java.io.Serializable;

import javax.swing.DefaultListModel;

public class PlayerBase implements Serializable {
	private static final long serialVersionUID = -5385521619095129364L;
	private DefaultListModel<Player> playerList;
	private int whoLastPlayed = 2;
	
	public PlayerBase() {
		playerList = new DefaultListModel<>();
		addPlayer(new Player("Anonymous", new Stats(0, 0, 0)));
	}
	
	public void addPlayer(Player player) {
		playerList.addElement(player);
	}
	
	public String showPlayers() {
		StringBuilder sb = new StringBuilder();
		String text = null;
		for(int i = 0; i < playerList.size(); i++) {
			text = playerList.get(i).toString();
			sb.append(text);
			sb.append("\n");
		}
		return sb.toString();
	}

	public DefaultListModel<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(DefaultListModel<Player> playerList) {
		this.playerList = playerList;
	}

	public int getWhoLastPlayed() {
		return whoLastPlayed;
	}

	public void setWhoLastPlayed(int whoLastPlayed) {
		this.whoLastPlayed = whoLastPlayed;
	}

}
