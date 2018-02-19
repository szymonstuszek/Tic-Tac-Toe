package game;

import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner(System.in);
	
	public boolean canIPlaceX(Board board) {
		System.out.println("Place the X:");
		int fieldChoice = sc.nextInt()-1;
		if(board.getGameBoard()[fieldChoice].isFieldEmpty()){
			board.getGameBoard()[fieldChoice].setX();
			return true;
		}
		System.out.println("Try again");
		return false;
	}
}
