package tictactoe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameStateManager {
	private String fileName = "src/tictactoe/gamestate.log";
	
	public GameStateManager(PlayerBase playerBase, Game game) {
		readStats(playerBase, game);
	}
	
	public void saveStats(PlayerBase playerBase, Game game) {
		if(playerBase == null) {
			playerBase = new PlayerBase();
			
		} 
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) 
		{
			oos.writeObject(playerBase);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readStats(PlayerBase playerBase, Game game) {
		
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) 
		{
			game.setPlayerBase((PlayerBase) ois.readObject());
		} catch (FileNotFoundException e) {
			System.out.println("No stats log file found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
