package panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameStateManager;
import tictactoe.PlayerBase;
import tictactoe.Rules;

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 7664208043667662591L;
	Random random = new Random();
	private JButton buttonOption1, buttonOption2, buttonOption3;
	private JLabel gameStatusLabel, playerLabel;
	private JProgressBar progressBar;

	public MenuPanel(Board board, Rules rules, Game game, PlayerPanel playerPanel, PlayerBase playerBase,
			GameStateManager gsm) {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		playerLabel = new JLabel("");
		gameStatusLabel = new JLabel("Press New game to start", 10);
		progressBar = new JProgressBar(0, 100);

		buttonOption1 = new JButton("New game");
		buttonOption1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerPanel.getWhoIsPlaying().getStats().gamePlayed();
				playerPanel.updatePlayerList(playerBase);
				playerLabel.setText("Playing as: " + playerPanel.getNameWhoIsPlaying(playerBase));

				board.emptyAllFields();
				board.enableBoard();
				gameStatusLabel.setText("Playing");
				gsm.saveStats(playerBase, game);

				int whoStarts = random.nextInt(2);
				if (whoStarts == 0) {
					Game.setPlayerActionPerformed(true);
				}
			}
		});

		buttonOption2 = new JButton("Players");
		buttonOption2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerPanel.updatePlayerList(playerBase); 
				game.getPlayerPanel().setVisible(true);
			}
		});

		buttonOption3 = new JButton("Quit");

		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;

		add(playerLabel, c);
		c.gridy++;
		add(gameStatusLabel, c);
		c.gridy++;
		add(progressBar, c);
		c.gridy++;
		add(buttonOption1, c);
		c.gridy++;
		add(buttonOption2, c);
		c.gridy++;
		add(buttonOption3, c);
		
		loadMenuPanelComponents();

	}
	
	public void loadMenuPanelComponents() {
		progressBar.setSize(150, 20);
		progressBar.setStringPainted(false);
		
		buttonOption1.setPreferredSize(new Dimension(150, 40));
		buttonOption2.setPreferredSize(new Dimension(150, 40));
		buttonOption3.setPreferredSize(new Dimension(150, 40));
		
		buttonOption3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	public JLabel getGameStatusLabel() {
		return gameStatusLabel;
	}

	public void setGameStatusLabel(JLabel gameStatusLabel) {
		this.gameStatusLabel = gameStatusLabel;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
}