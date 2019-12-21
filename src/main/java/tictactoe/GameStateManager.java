package tictactoe;

import java.io.*;
import java.net.URL;

public class GameStateManager {
	private File fileName = new File(GameStateManager.class.getResource("/gamestate.log").getFile());

	public GameStateManager(PlayerBase playerBase, Game game) {
		readStats(playerBase, game);
	}
	
	public void saveStats(PlayerBase playerBase, Game game) {


		if(playerBase == null) {
			playerBase = new PlayerBase();
			
		} 
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(playerBase);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readStats(PlayerBase playerBase, Game game) {
		
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
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
