package edu.century.checkers;

import java.awt.EventQueue;
import java.lang.NullPointerException;
import java.util.Scanner;
public class driver {
	
	
	public static void whereTo() {
	
		System.out.println("Enter the X coordinate of the piece you want to move:");
		Scanner keyX = new Scanner(System.in);		
		int locX = keyX.nextInt();
		
		System.out.println("Enter the Y coordinate of the piece you want to move:");
		Scanner keyY = new Scanner(System.in);		
		int locY = keyY.nextInt();
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
			else if(color == true ) {				
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
			}
		
		//---------------------------------------------------------
		// red chip
			else if(color == false) {				
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
	
		// -------------------------------------- main
	public static void main(String arg[]) {
		
		
		whereTo();
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	

		
	}
	