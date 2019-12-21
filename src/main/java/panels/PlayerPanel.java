package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tictactoe.Game;
import tictactoe.GameStateManager;
import tictactoe.Player;
import tictactoe.PlayerBase;
import tictactoe.Stats;

public class PlayerPanel extends JFrame implements ListSelectionListener {
	private static final long serialVersionUID = 1154190134429472864L;
	private JList<Player> list;
	
	private int playerIndex;
	private int selectedIndex = 0;
	private JButton createPlayerButton, selectButton, resumeButton;
	private JFrame playerCreationFrame;

	public PlayerPanel(Game game, PlayerBase playerBase, GameStateManager gsm) {
		createPlayerPanel();
		
		GridBagConstraints c = new GridBagConstraints();
		
		list = new JList<Player>(game.getPlayerBase().getPlayerList());
		list.addListSelectionListener(this);
		
		createPlayerButton = new JButton("Create");
		selectButton = new JButton("Select");
		resumeButton = new JButton("Resume");

		updatePlayerList(playerBase);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(700, 350));

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);
		c.gridx = 0;
		c.gridy = 1;
		add(createPlayerButton, c);
		c.gridy++;
		add(selectButton, c);
		c.gridy++;
		add(resumeButton, c);
	}
	
	private void createPlayerPanel() {
		setTitle("Player Panel");
		setLayout(new GridBagLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(GameFrame.frameWidth, GameFrame.frameHeight);
	}

	public void loadList(Game game) {
		list.setModel(game.getPlayerBase().getPlayerList());
	}

	public void updatePlayerList(PlayerBase playerBase) {
		playerBase.showPlayers();
		
	}

	// how to read this more clean
	public void loadPlayerPanelComponents(GameStateManager gsm, Game game) {
		loadList(game);
		
		setButtonSize(createPlayerButton);
		createPlayerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(playerCreationFrame, "Input player name",
						"Player creation", JOptionPane.INFORMATION_MESSAGE);
				game.getPlayerBase().addPlayer(new Player(s, new Stats(0, 0, 0)));
				updatePlayerList(game.getPlayerBase());
				gsm.saveStats(game.getPlayerBase(), game);
			}
		});
		
		setButtonSize(selectButton);
		selectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.setPlayer(getWhoIsPlaying());
			}
		});
		
		setButtonSize(resumeButton);
		resumeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public void setButtonSize(JButton button) {
		button.setPreferredSize(new Dimension(150, 40));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(list.getSelectedIndex());
		
		selectedIndex = list.getSelectedIndex();
		if(selectedIndex == -1) selectedIndex = 0;
	}
	
	public int getPlayerIndex()	{
		playerIndex = list.getSelectedIndex();
		if(playerIndex == -1) playerIndex = 0;
		return playerIndex;
	}
	
	public Player getWhoIsPlaying() {
		System.out.println(list.getModel().getElementAt(getPlayerIndex()));
		return list.getModel().getElementAt(getPlayerIndex());
	}
	
	public String getNameWhoIsPlaying(PlayerBase playerBase) {
		int index = list.getSelectedIndex();
		if(index == -1) index = 0;
		
		return list.getModel().getElementAt(index).getPlayerName();
	}

}
