package tictactoe;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel{
	private final int panelWidth = 600;
	private final int panelHeight = 480;
	private final int numberOfFields = 9;
	private Field[] gameBoard = new Field[numberOfFields];
	
	
	public Board() {
		setLayout(new GridLayout(3,3));
		setBorder(new EmptyBorder(5,5,5,5));
		setPreferredSize(new Dimension(panelWidth, panelHeight));
		createFields();
	}

	
	public void createFields() {
		for(int i = 0; i < numberOfFields; i++) {
			gameBoard[i] = new Field();
			add(gameBoard[i]);
			gameBoard[i].setEnabled(false);
		}
	}
	
	public void enableBoard() {
		for(int i = 0; i < numberOfFields; i++) {
			gameBoard[i].setEnabled(true);
		}
	}
	
	public void disableBoard() {
		for(int i = 0; i < numberOfFields; i++) {
			gameBoard[i].setEnabled(false);
		}
	}

	public Field[] getGameBoard() {
		return gameBoard;
	}


	public void setGameBoard(Field[] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public void emptyAllFields() {
		for(int i = 0; i<numberOfFields;i++) {
			getGameBoard()[i].emptyField();
			getGameBoard()[i].setBackground(null);
		}
	}

}
