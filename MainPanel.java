package panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictactoe.Board;

public class MainPanel extends JPanel {
	private Board board;
	private MenuPanel menuPanel;
	
	public MainPanel(Board board, MenuPanel menuPanel) {
		setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(10, 10, 10 ,10));
		this.add(board, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.EAST);
		
	}
	

}
