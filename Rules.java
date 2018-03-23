package tictactoe;

import java.awt.Color;

import javax.swing.ButtonGroup;

import panels.PlayerPanel;

public class Rules {
	
	
	public Rules() {
	}
	
	public boolean isGameOver(Board board, Game game, 
			PlayerBase playerBase, GameStateManager gsm,
			PlayerPanel playerPanel) {
		
		if(checkIfOWins(board)){
			playerPanel.getWhoIsPlaying().getStats().computerWins();
			playerPanel.updatePlayerList(playerBase);
			gsm.saveStats(playerBase, game);
			return true;
		}
		
		if(checkIfXWins(board)){
			playerPanel.getWhoIsPlaying().getStats().playerWins();
			playerPanel.updatePlayerList(playerBase);
			gsm.saveStats(playerBase, game);
			return true;
		}
		
		if(checkIfDraw(board)) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfDraw(Board board) {
		for(int i = 0; i<9;i++) {
			if(board.getGameBoard()[i].isFieldEmpty()){
				return false;
			};
		}
		return true;
	}
	
	
	public boolean checkIfOWins(Board board) {
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[1].isO() && board.getGameBoard()[2].isO()) {
			board.getGameBoard()[0].setBackground(Color.RED);
			board.getGameBoard()[1].setBackground(Color.RED);
			board.getGameBoard()[2].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[3].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[5].isO()) {
			board.getGameBoard()[3].setBackground(Color.RED);
			board.getGameBoard()[4].setBackground(Color.RED);
			board.getGameBoard()[5].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[6].isO() && board.getGameBoard()[7].isO() && board.getGameBoard()[8].isO()) {
			board.getGameBoard()[6].setBackground(Color.RED);
			board.getGameBoard()[7].setBackground(Color.RED);
			board.getGameBoard()[8].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[3].isO() && board.getGameBoard()[6].isO()) {
			board.getGameBoard()[0].setBackground(Color.RED);
			board.getGameBoard()[3].setBackground(Color.RED);
			board.getGameBoard()[6].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[1].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[7].isO()) {
			board.getGameBoard()[1].setBackground(Color.RED);
			board.getGameBoard()[4].setBackground(Color.RED);
			board.getGameBoard()[7].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[2].isO() && board.getGameBoard()[5].isO() && board.getGameBoard()[8].isO()) {
			board.getGameBoard()[2].setBackground(Color.RED);
			board.getGameBoard()[5].setBackground(Color.RED);
			board.getGameBoard()[8].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[0].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[8].isO()) {
			board.getGameBoard()[0].setBackground(Color.RED);
			board.getGameBoard()[4].setBackground(Color.RED);
			board.getGameBoard()[8].setBackground(Color.RED);
			return true;
		}
		if(board.getGameBoard()[2].isO() && board.getGameBoard()[4].isO() && board.getGameBoard()[6].isO()) {
			board.getGameBoard()[2].setBackground(Color.RED);
			board.getGameBoard()[4].setBackground(Color.RED);
			board.getGameBoard()[6].setBackground(Color.RED);
			return true;
		}
		return false;
	}
	
	public boolean checkIfXWins(Board board) {
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[1].isX() && board.getGameBoard()[2].isX()) {
			board.getGameBoard()[0].setBackground(Color.GREEN);
			board.getGameBoard()[1].setBackground(Color.GREEN);
			board.getGameBoard()[2].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[3].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[5].isX()) {
			board.getGameBoard()[3].setBackground(Color.GREEN);
			board.getGameBoard()[4].setBackground(Color.GREEN);
			board.getGameBoard()[5].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[6].isX() && board.getGameBoard()[7].isX() && board.getGameBoard()[8].isX()) {
			board.getGameBoard()[6].setBackground(Color.GREEN);
			board.getGameBoard()[7].setBackground(Color.GREEN);
			board.getGameBoard()[8].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[3].isX() && board.getGameBoard()[6].isX()) {
			board.getGameBoard()[0].setBackground(Color.GREEN);
			board.getGameBoard()[3].setBackground(Color.GREEN);
			board.getGameBoard()[6].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[1].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[7].isX()) {
			board.getGameBoard()[1].setBackground(Color.GREEN);
			board.getGameBoard()[4].setBackground(Color.GREEN);
			board.getGameBoard()[7].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[2].isX() && board.getGameBoard()[5].isX() && board.getGameBoard()[8].isX()) {
			board.getGameBoard()[2].setBackground(Color.GREEN);
			board.getGameBoard()[5].setBackground(Color.GREEN);
			board.getGameBoard()[8].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[0].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[8].isX()) {
			board.getGameBoard()[0].setBackground(Color.GREEN);
			board.getGameBoard()[4].setBackground(Color.GREEN);
			board.getGameBoard()[8].setBackground(Color.GREEN);
			return true;
		}
		if(board.getGameBoard()[2].isX() && board.getGameBoard()[4].isX() && board.getGameBoard()[6].isX()) {
			board.getGameBoard()[2].setBackground(Color.GREEN);
			board.getGameBoard()[4].setBackground(Color.GREEN);
			board.getGameBoard()[6].setBackground(Color.GREEN);
			return true;
		}
		return false;
	}



}
