package checkers;
import java.awt.EventQueue;


public class Driver {

	static Piece[][] board = new Piece[][]{
		{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
		{null,new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true)},
		{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
		{null,null,null,null,null,null,null,null},
		{null,null,null,null,null,null,null,null},
		{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)},
		{new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false),null},
		{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)}
	};
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
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

