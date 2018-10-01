package tictactoe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Field extends JButton implements ActionListener {
	private boolean X = false;
	private boolean O = false;
	
	public Field() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setMark();
		updateField();
	}
	
	public void updateField() {
		if(this.X == true) {
			Game.setPlayerActionPerformed(true);
		}
		
		if(this.O == true) {
			Game.setPlayerActionPerformed(false);
		}
		
	}
	
	public void setMark() {
		if(Game.isPlayerActionPerformed()) setO();
		if(!Game.isPlayerActionPerformed()) setX();
	}
	
	public void emptyField() {
		this.X = false;
		this.O = false;
		this.setText("");
	}
	
	public void setO() {
		if(isFieldEmpty()) {
			this.O = true;
			this.setFont(new Font("Arial", Font.BOLD, 90));
			this.setText("O");
		}
	}

	public void setX() {
		if(isFieldEmpty()) {
			this.X = true;
			this.setFont(new Font("Arial", Font.BOLD, 90));
			this.setText("X");
		}
	}

	public boolean isO() {
		return this.O;
	}
	
	public boolean isX() {
		return this.X;
	}

	
	public boolean isFieldEmpty() {
		if(this.X == false && this.O == false) {
			return true;
		}
		return false;
	}

}
