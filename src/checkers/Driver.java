package checkers;

import java.awt.EventQueue;
import java.util.Scanner;

public class Driver {
	
	
	private static Piece[][] board = new Piece[][]{
	{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
	{null,new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true)},
	{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
	{null,null,null,null,null,null,null,null},
	{null,null,null,null,null,null,null,null},
	{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)},
	{new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false),null},
	{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)}};
	
	
	private static int redCount = 0;
	private static int blackCount = 0;
	private static boolean game = true;
	
		// -------------------------------------- main
	public static void main(String arg[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
					
					while(game){
						boolean turn = true;
						
						if (turn) {
							redTurn();
						}
						else {
							blackTurn();
						}
						if(turn) {
							turn = false;
						}
						else {
							turn = true;
						}
						
						if (redCount == 9 || blackCount == 9) {
							System.out.println("Game over.");
							//TODO 
							game = false;
						}
					}
							
					
					frame.update();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	private static void blackTurn() {
		//TODO
		System.out.print("It is black's turn \nSelect a piece to move:");
		Coordinates origin = new Coordinates(0,3);
		board[0][3].move(origin);
	}


	private static void redTurn() {
			// TODO Auto-generated method stub
			
		Scanner tempInput = new Scanner(System.in);
		System.out.print("It is red's turn \nSelect a piece to move:");
//		tempInput.nextLine();
		Coordinates origin = new Coordinates(7,5);
		board[7][5].move(origin);
		
		
		tempInput.close();
		}

	public static Piece[][] getBoard(){
		return board;
	}
	
	public static void redCaptureCnt() {
		redCount++;
	}
	
	public static void blackCaptureCnt() {
		blackCount++;
	}
}
	
