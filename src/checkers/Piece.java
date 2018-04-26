package checkers;

import java.util.Scanner;

import checkers.Coordinates;

public class Piece{

	
	Coordinates origin;
	Coordinates movingTo;
	Boolean color, kinged;
	
	public Piece(Boolean color) {
		this.color = color;
		this.kinged = false;
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
	
	public void move(Coordinates origin) {
		
		int locX = origin.getLocX();
		int locY = origin.getLocY();
		Boolean color = true;
		Boolean king = false;

		
		//black King
		if (color == true && king == true) {	
			System.out.println("Black King: moving left, right, back left, or back right?");
			Scanner kingBlackLR = new Scanner(System.in);		
			String kingBlackMove = kingBlackLR.nextLine();		// prompt user for left, right, back left, back right - STRING or CHAR??
			
			if(kingBlackMove.equals("right")) {			// moves right			
				int tempX = locX - 1;
				int tempY = locY + 1;
				System.out.println("I am : King, Black, moved forward right");
			}
			else if(kingBlackMove.equals("left")) {		// moves left
				int tempX = locX + 1;
				int tempY = locY + 1;
				System.out.println("I am : King, Black, moved forward left");
			}
			else if(kingBlackMove.equals("back right")) {	// moves back right
				int tempX = locX + 1;
				int tempY = locY - 1;
				System.out.println("I am : King, Black, moved backwards right");
			}
			else if(kingBlackMove.equals("back left")) {	// moves back left
				int tempX = locX - 1;
				int tempY = locY - 1;
				System.out.println("I am : King, Black, moved backwards left");
			}
		}
		//---------------------------------------------------------------------
		//red King	
			else if(color == false && king == true) {	
				System.out.println("Red King: moving left, right, back left, or back right?");
				Scanner kingRedLR = new Scanner(System.in);		
				String kingRedMove = kingRedLR.nextLine();		// prompt user for left, right, back left, back right - STRING or CHAR??
				
				if(kingRedMove.equals("right")) {			// moves right			
					int tempX = locX - 1;
					int tempY = locY + 1;
					System.out.println("I am : King, Red, moved forward right.");
				}
				else if(kingRedMove.equals("left")) {		// moves left
					int tempX = locX + 1;
					int tempY = locY + 1;
					System.out.println("I am : King, Red, moved forward left.");
				}
				else if(kingRedMove.equals("back right")) {	// moves back right
					int tempX = locX + 1;
					int tempY = locY - 1;
					System.out.println("I am : King, Red, moved backwards right.");
				}
				else if(kingRedMove.equals("back left")) {	// moves back left
					int tempX = locX - 1;
					int tempY = locY - 1;
					System.out.println("I am : King, Red, moved backwards right.");
				}
			}
		//---------------------------------------------------------------------
		// black chip	
			else if(color == true && king == false ) {				
				System.out.println("Black: Moving left or right?");
				Scanner blackLR = new Scanner(System.in);		
				String blackMove = blackLR.nextLine();
			
					if(blackMove.equals("right")) {	// black moves right
						int tempX = locX + 1;
						int tempY = locY + 1;
						System.out.println("I am Black, moved forward right.");
					}
					
					else {
						int tempX = locX - 1;		// black moves left
						int tempY = locY + 1;
						System.out.println("I am Black, moved forward left.");
					}
					blackLR.close();
			}
		
		//---------------------------------------------------------
		// red chip
			else if(color == false && king == true) {				
				System.out.println("Red: Moving left or right?");
				Scanner redLR = new Scanner(System.in);		
				String redMove = redLR.nextLine();
				
					if(redMove.equals("right")) {	// red moves right
						int tempX = locX + 1;
						int tempY = locY + 1;
						System.out.println("I am Red, moved forward right.");
					}
					
					else {
						int tempX = locX - 1;		// red moves left
						int tempY = locY + 1;
						System.out.println("I am Red, moved forward left.");
						
					}
			}
	}
}


