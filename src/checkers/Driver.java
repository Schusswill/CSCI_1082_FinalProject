package checkers;

public class Driver {
	
	
	static Piece[][] board = new Piece[][]{
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
				System.out.println("Red wins");
				game = false;
			}
			else if(redCount == 9) {
				System.out.println("Black wins");
				game = false;
			}
		}
		
	}
		
	
	//runs on black's turn and facilitates that
	private static void blackTurn() {
		int x,y;
		System.out.println("It is black's turn");
		boolean looping = true;
		while(looping) {
			try {
				System.out.print("Select a piece to move. \nX: ");
				x = Integer.parseInt(Display.getInput());
				System.out.print("Y: ");
				y = Integer.parseInt(Display.getInput());
			}catch (NumberFormatException e){
				System.out.println("Please enter a number.");
				continue;
			}
			if (0>x || x>7 || 0>y || y>7) {
				System.out.println("Please select a space on the board");
				continue;
			}
			if (board[y][x] == null) {
				System.out.println("there is no piece on that space");
				continue;
			}
			if (!(board[y][x].getColor())) {
				System.out.println("You can't move your oponents pieces");
				continue;
			}
			Coordinates origin = new Coordinates(x,y);
			looping = board[y][x].move(origin);
			Display.update();
		}
		System.out.println("");
	}
	
	
	//runs on red's turn and facilitates that
	private static void redTurn() {		
		int x,y;
		System.out.println("It is red's turn");
		boolean looping = true;
		while(looping) {
			try {
				System.out.print("Select a piece to move. \nX: ");
				x = Integer.parseInt(Display.getInput());
				System.out.print("Y: ");
				y = Integer.parseInt(Display.getInput());
			}catch (NumberFormatException e){
				System.out.println("Please enter a number.");
				continue;
			}		
			if (0>x || x>7 || 0>y || y>7) {
				System.out.println("Please select a space on the board");
				continue;
			}
			if (board[y][x] == null) {
				System.out.println("there is no piece on that space");
				continue;
			}
			if (board[y][x].getColor()) {
				System.out.println("You can't move your oponents pieces");
				continue;
			}
			Coordinates origin = new Coordinates(x,y);
			looping = board[y][x].move(origin);
			Display.update();
		}
		System.out.println("");
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
}