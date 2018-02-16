package game;

public class Field {
	private boolean X;
	private boolean O;
	
	public Field() {
		this.X = false;
		this.O = false;
	}
	
	public boolean isX() {
		return X;
	}
	
	public void setX() {
		if(isFieldEmpty()) {
			this.X = true;
		} else {
			System.out.println("This field is already marked!");
		}
	}
	
	public boolean isO() {
		return O;
	}
	
	public void setO() {
		if(isFieldEmpty()) {
			this.O = true;
		} else {
			System.out.println("This field is already marked!");
		}
	}
	
	public boolean isFieldEmpty() {
		if(this.X == false && this.O == false) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if(isO()) {
			return "[O]";
		}
		if(isX()) {
			return "[X]";
		}
		return "[ ]";
	}
}
