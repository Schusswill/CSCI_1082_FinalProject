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
	

	//=========================================================================================
		
		private static int blackChipCounter = 0;
		private static int redChipCounter = 0;
		
		public void whereTo() {
		
		int locX = origin.getLocX();
		int locY = origin.getLocY();
		Boolean color = true;
		Boolean king = false;

			Piece[][] myBoard = Driver.getBoard();
		/*	System.out.println("Enter the X coordinate of the piece you want to move:");
			Scanner keyX = new Scanner(System.in);		
			int locX = keyX.nextInt();
			
			System.out.println("Enter the Y coordinate of the piece you want to move:");
			Scanner keyY = new Scanner(System.in);		
			int locY = keyY.nextInt();
			
			Boolean color = true;
			Boolean king = false;
		*/
			
			//black King
			if (color == true && king == true) {	
				System.out.println("Black King: moving left, right, back left, or back right?");
				Scanner kingBlackWhereTo = new Scanner(System.in);		
				String kingBlackMove = kingBlackWhereTo.nextLine();		// prompt user for left, right, back left, back right - STRING or CHAR??
				
				if(kingBlackMove.equals("right")) {			// moves right			
					int tempX = locX - 1;
					int tempY = locY + 1;
					myBoard[locX][locY] = null;
					System.out.println("King, Black, moved forward right");
				}
				else if(kingBlackMove.equals("left")) {		// moves left
					int tempX = locX + 1;
					int tempY = locY + 1;
					myBoard[locX][locY] = null;
					System.out.println("King, Black, moved forward left");
				}
				else if(kingBlackMove.equals("back right")) {	// moves back right
					int tempX = locX + 1;
					int tempY = locY - 1;
					myBoard[locX][locY] = null;
					System.out.println("King, Black, moved backwards right");
				}
				else if(kingBlackMove.equals("back left")) {	// moves back left
					int tempX = locX - 1;
					int tempY = locY - 1;
					myBoard[locX][locY] = null;
					System.out.println("King, Black, moved backwards left");
				}
			}
		//---------------------------------------------------------------------
			//red King	
				else if(color == false && king == true) {	
					System.out.println("Red King: moving left, right, back left, or back right?");
					Scanner kingRedWhereTo = new Scanner(System.in);		
					String kingRedMove = kingRedWhereTo.nextLine();		// prompt user for left, right, back left, back right - STRING or CHAR??
					
					if(kingRedMove.equals("right")) {			// moves right			
					
						System.out.println("King, Red, moved forward right.");
					}
					else if(kingRedMove.equals("left")) {		// moves left
						int tempX = locX + 1;
						int tempY = locY + 1;
						myBoard[locX][locY] = null;
						System.out.println("King, Red, moved forward left.");
					}

					else if(kingRedMove.equals("back right")) {	// moves back right
						int tempX = locX + 1;
						int tempY = locY - 1;
						myBoard[locX][locY] = null;
						System.out.println("King, Red, moved backwards right.");
					}
					else if(kingRedMove.equals("back left")) {	// moves back left
						int tempX = locX - 1;
						int tempY = locY - 1;
						myBoard[locX][locY] = null;
						System.out.println("King, Red, moved backwards right.");
					}
					
					else {
						int tempX = locX - 1;		// red moves left
						int tempY = locY + 1;
						System.out.println("I am Red, moved forward left.");
						
					}
				}
			
		//---------------------------------------------------------------------
			// black chip	
				else if(color == true && king == false ) {				
					System.out.println("Black: Moving left or right?");
					Scanner blackWhereTo = new Scanner(System.in);		
					String blackMove = blackWhereTo.nextLine();
				
						if(blackMove.equals("right")) {	// black moves right
							if (myBoard [locX +1][locY +1].getColor() == false) {
								blackChipCounter = blackChipCounter + 1; // check if chip is red - remove icon from myboard GUI??
								int tempX = locX + 2;
								int tempY = locY + 2;
								myBoard[locX][locY] = null;
								if (tempX == 7) {
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: Captured red chip and moved forward right.");
							}
							
							else {
								int tempX = locX + 1;
								int tempY = locY + 1;
								myBoard[locX][locY] = null;
								if (tempX == 7) {
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: moved forward right.");
								}
							}
						
						else {	// black moves left
							if (myBoard [locX -1][locY +1].getColor() == false) {
								blackChipCounter = blackChipCounter + 1; // check if chip is red - remove icon from myboard GUI??
								int tempX = locX - 2;
								int tempY = locY + 2;
								myBoard[locX][locY] = null;
								if (tempX == 7) {
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: Captured red chip and moved forward left.");
							}
							
							else {
								int tempX = locX - 1;	
								int tempY = locY + 1;
								myBoard[locX][locY] = null;
								if (tempX == 7) {
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: moved forward left.");
								}
							}
				}
			
		//---------------------------------------------------------
			// red chip
				else if(color == false && king == false) {				
					System.out.println("Red: Moving left or right?");
					Scanner redWhereTo = new Scanner(System.in);		
					String redMove = redWhereTo.nextLine();
					
			
					if(redMove.equals("right")) {	
							if (myBoard [locX +1][locY +1].getColor() == true) {
								redChipCounter = redChipCounter + 1; // check if chip is black - remove icon from myboard GUI??
								int tempX = locX + 2;
								int tempY = locY + 2;
								myBoard[locX][locY] = null;
								if (tempX == 0) {
									System.out.println("Red chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Red: Captured black chip and moved forward right.");
							}
							
						else {
								int tempX = locX + 1;
								int tempY = locY + 1;
								myBoard[locX][locY] = null;
								if (tempX == 0) {
									System.out.println("Red chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Red: moved forward right.");
								
							}
						}
						else {	// red chip moves left
							if (myBoard [locX -1][locY +1].getColor() == true) {
								redChipCounter = redChipCounter + 1; // check if chip is black - remove icon from myboard GUI??
								int tempX = locX - 2;
								int tempY = locY + 2;
								myBoard[locX][locY] = null;
								if (tempX == 0) {
									System.out.println("Red chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Red: Captured black chip and moved forward left.");
							}
							
								else {
									int tempX = locX - 1;		// red moves left
									int tempY = locY + 1;
									myBoard[locX][locY] = null;
									System.out.println("Red: moved forward left.");
									}
								}
							}
			
			// detects for potential winner every round	
						Driver.redCaptureCnt();
						Driver.blackCaptureCnt();
		
			}
}
// King moves right
/*int tempX = locX - 1;
int tempY = locY + 1;
myBoard[locX][locY] = null;*/

