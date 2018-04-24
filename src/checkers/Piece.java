package checkers;

import checkers.Coordinates;

public class Piece{

	
	Coordinates origin;
	Coordinates movingTo;
	Boolean color, kinged;
	
	public Piece(Boolean color) {
		this.color = color;
		this.kinged = false;
	}
	
	public boolean move(Coordinates origin) {
		//TODO this is a place holder
		return false;
	}
	
	public boolean getColor() {
		return color;
	}
	public boolean getKinged() {
		return kinged;
	}
	public void setKinged(boolean kinged) {
		this.kinged = kinged;
	}
}


