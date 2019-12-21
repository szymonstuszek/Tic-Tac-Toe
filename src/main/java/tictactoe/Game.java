package tictactoe;

import java.util.Random;

import panels.GameFrame;
import panels.MainPanel;
import panels.MenuPanel;
import panels.PlayerPanel;



public class Game  {
	Random random = new Random();
	private GameFrame frame;
	private Board board;
	
	private MenuPanel menuPanel;
	private MainPanel mainPanel;
	
	private GameStateManager gsm;
	
	private Player player = new Player(null, null);
	private PlayerBase playerBase;
	
	private PlayerPanel playerPanel;
	
	private Rules rules;
	
	private static boolean playerActionPerformed = false;
	private boolean gameRunning = true;
	
	

	
	public Game() {
		frame = new GameFrame();
		board = new Board();
		
		playerBase = new PlayerBase();
		playerPanel = new PlayerPanel(this, playerBase, gsm);
		gsm = new GameStateManager(playerBase, this);
		
		playerPanel.loadPlayerPanelComponents(gsm, this);
		
		menuPanel = new MenuPanel(board, rules, this, playerPanel, playerBase, gsm);
		mainPanel = new MainPanel(board, menuPanel);
		
		rules = new Rules();
		frame.add(mainPanel);
		frame.pack();
		
		while(gameRunning) {
			gameLoop();
		}
	}
	
	
	public void gameLoop() {
		if(!rules.isGameOver(board, this, playerBase, gsm, playerPanel)) {
			if(playerActionPerformed) {
				int fieldChoice = random.nextInt(9);
				
				if(board.getGameBoard()[fieldChoice].isFieldEmpty()) {
					board.getGameBoard()[fieldChoice].doClick();
					playerActionPerformed = false;
				}
			}
		}
		else {
			waitForNextRound();
		}
	}

	
	public void waitForNextRound() {
		int time = 0;
		while(time < 3) {
			menuPanel.getGameStatusLabel().setText("Loading next round");
			try {
				Thread.sleep(300);
				menuPanel.getProgressBar().setValue(33+time*33);
				if(time == 3) menuPanel.getProgressBar().setValue(100);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		time++;
		}
		menuPanel.getGameStatusLabel().setText("Playing");
		menuPanel.getProgressBar().setValue(0);
		board.emptyAllFields();
	}

	public static boolean isPlayerActionPerformed() {
		return playerActionPerformed;
	}

	public static void setPlayerActionPerformed(boolean playerActionPerformed) {
		Game.playerActionPerformed = playerActionPerformed;
	}

	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}


	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}


	public PlayerBase getPlayerBase() {
		return playerBase;
	}


	public void setPlayerBase(PlayerBase playerBase) {
		this.playerBase = playerBase;
	}

}
