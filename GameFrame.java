package panels;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public static final int frameWidth = 800;
	public static final int frameHeight = 600;
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Tic tac toe");
		setSize(frameWidth, frameHeight);
		setResizable(false);
	}

}
