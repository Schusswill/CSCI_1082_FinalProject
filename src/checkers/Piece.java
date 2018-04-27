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

		public void move(Coordinates origin) {
		
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
		
		{
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
					String kingRedMove = kingRedWhereTo.nextLine();		
					
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
				
	/*RIGHT*/		if(blackMove.equals("right")) {						// black moves right
						if (!(myBoard[locX + 1][locY + 1] == null)) {	// checks if spot is not null
							if (myBoard [locX + 1][locY +1].getColor() == false) {	// not null; get the color & capture red chip
								blackChipCounter = blackChipCounter + 1; // capture red chip - Add 1 to Black Counter
								int tempX = locX + 2;					// change locations to new locations
								int tempY = locY + 2;
								myBoard[locX][locY] = null;				// set old location to null
								if (tempX == 7) {						// checks if righ move can be made King reference Loc X
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: Captured red chip and moved forward right.");
								}
							}
						}
				}
				
							else {												
								if (myBoard[locX + 1][locY + 1] == null) {	// checks if spot is null
								int tempX = locX + 1;						// change locations to new locations
								int tempY = locY + 1;
								myBoard[locX][locY] = null;					// set old location to null
								if (tempX == 7) {							// checks if right move can be made King reference Loc X
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: moved forward right.");
								}
							}
							
		/*LEFT*/
								if (myBoard [locX -1][locY +1].getColor() == false) {	// check if chip is red 
								blackChipCounter = blackChipCounter + 1; 			// add to the Black chip counter 
								int tempX = locX - 2;								// change location to new location
								int tempY = locY + 2;
								myBoard[locX][locY] = null;							// set old location to null
								if (tempX == 7) {						// check if left move is a possible king
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: Captured red chip and moved forward left.");
								}
						
							else {
								if (myBoard[locX - 1][locY +1] == null) {	// checks if spot is null
								int tempX = locX - 1;						// change location to new locations
								int tempY = locY + 1;
								myBoard[locX][locY] = null;					// set old location to null
								if (tempX == 7) {							// checks if left move is King  reference Loc X
									System.out.println("Black chip has been Kinged.");
									setKinged(true);
								}
								System.out.println("Black: moved forward left.");
							}
							}
	
			
		//---------------------------------------------------------
			// red chip
				
			if(color == false && king == false ) {				
				System.out.println("Red: Moving left or right?");
				Scanner redWhereTo = new Scanner(System.in);		
				String redMove = redWhereTo.nextLine();
			
/*RIGHT*/		if(redMove.equals("right")) {						// red moves right
					if (!(myBoard[locX - 1][locY +1] == null)) {	// checks if spot is not null
						if (myBoard [locX -1][locY +1].getColor() == true) {	// not null; get the color & capture red chip
							redChipCounter = redChipCounter + 1; // capture red chip - Add 1 to Red Counter
							int tempX = locX - 2;					// change locations to new locations
							int tempY = locY + 2;
							myBoard[locX][locY] = null;				// set old location to null
							if (tempX == 7) {						// checks if righ move can be made King reference Loc X
								System.out.println("Red chip has been Kinged.");
								setKinged(true);
							}
							System.out.println("Red: Captured red chip and moved forward right.");
						}
					}
				}
			
						else {												
							if (myBoard[locX - 1][locY +1] == null) {	// checks if spot is null
							int tempX = locX  -1;						// change locations to new locations
							int tempY = locY + 1;
							myBoard[locX][locY] = null;					// set old location to null
							if (tempX == 7) {							// checks if right move can be made King reference Loc X
								System.out.println("Red chip has been Kinged.");
								setKinged(true);
							}
							System.out.println("Black: moved forward right.");
						}
						}
							
	/*LEFT*/			
						if (myBoard [locX -1][locY -1].getColor() == true) {	// check if chip is black
							redChipCounter = redChipCounter + 1; 			// add to the red chip counter 
							int tempX = locX - 2;								// change location to new location
							int tempY = locY - 2;
							myBoard[locX][locY] = null;							// set old location to null
							if (tempX == 7) {						// check if left move is a possible king
								System.out.println("Red chip has been Kinged.");
								setKinged(true);
							}
							System.out.println("Red: Captured red chip and moved forward left.");
						}
					
						else {
							if (myBoard[locX - 1][locY -1] == null) {	// checks if spot is null
							int tempX = locX - 1;						// change location to new locations
							int tempY = locY - 1;
							myBoard[locX][locY] = null;					// set old location to null
							if (tempX == 7) {							// checks if left move is King  reference Loc X
								System.out.println("Red chip has been Kinged.");
								setKinged(true);
							}
							System.out.println("Red: moved forward left.");
						}
					}
			}
		}
		}
}

		
		
		
						
		

							
							
		
							
							
		
			
		
							
						
						

			
