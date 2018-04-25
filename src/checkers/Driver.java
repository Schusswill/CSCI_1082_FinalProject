package checkers;

import java.awt.EventQueue;

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
	
		// -------------------------------------- main
	public static void main(String arg[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
					
					//add in the turn stuff here
					
					frame.update();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static Piece[][] getBoard(){
		return board;
	}

		
	}
	
