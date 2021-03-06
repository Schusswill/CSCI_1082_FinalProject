package checkers;

public class Driver {
	
	
	private static Piece[][] board = new Piece[][]{
	{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
	{null,new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true)},
	{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Kinged(true),null},
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
//		DisplayThread t1 = new DisplayThread();
//		t1.start();
		Display ui = new Display();
		ui.setVisible(true);
		Display.update();
			
		boolean turn = true;
		while(game){
						
			if (turn) {
				blackTurn();
			}
			else {
				redTurn();
			}
			if(turn) {
				turn = false;
			}
			else {
				turn = true;
			}
			
			if (redCount == 9 || blackCount ==9) {
				System.out.println("Game over");
				//TODO 
				game = false;
			}
		}
		
	}
		
	
	private static void blackTurn() {
		//TODO
		System.out.print("It is black's turn \nSelect a piece to move:");
		int x = Integer.parseInt(Display.getInput());
		int y = Integer.parseInt(Display.getInput());
		System.out.println("");
		Coordinates origin = new Coordinates(x,y);
		boolean looped = true;
		while(looped) {
			looped = board[x][y].move(origin);
		}
		
		
		
	}

	private static void redTurn() {
			// TODO Auto-generated method stub
			
		int x,y;
		System.out.print("It is red's turn \nSelect a piece to move:");
		x = Integer.parseInt(Display.getInput());
		y = Integer.parseInt(Display.getInput());
		System.out.println("");
		Coordinates origin = new Coordinates(x,y);
		board[x][y].move(origin);
	}
	
	public static Piece[][] getBoard(){
		return board;
	}
	
	public static void redCaptureCnt() {
		redCount++;
		System.out.println("Red chips catured: " + redCount + ".");
	}
	
	public static void blackCaptureCnt() {
		blackCount++;
		System.out.println("Black chips catured: " + blackCount + ".");
	}

	

//	static class DisplayThread implements Runnable{
//
//		private Thread t;
//		DisplayThread(){
//			
//		}
//		@Override
//		public void run() {
//			try {
//				Display frame = new Display();
//				frame.setVisible(true);
//				Display.update();
//				while(game) {
//					Thread.sleep(1);
//					Display.update();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();			
//			}
//		
//	}
//
//		public void start() {
//			if (t == null) {
//				t = new Thread (this);
//				t.start();
//			}
//			
//		}
//	}
}