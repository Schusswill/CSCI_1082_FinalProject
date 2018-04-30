package checkers;

public class Kinged extends Piece {

	public Kinged(Boolean color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	private Coordinates origin;
	private int direction;
		/*right up = 0
		 * left up = 1
		 * left down = 2
		 * right down =3
		 */
	
	@Override
	public Boolean move(Coordinates origin){
		this.origin = origin;
		
		Piece[][] myBoard = Driver.getBoard();
		
		String buffer = Display.getInput();
		while(true) {
			System.out.println("moveing left or right");
			if(buffer == "left" || buffer == "Left") {
				System.out.println("Up or down");
				buffer = Display.getInput();
				if (buffer == "up" || buffer == "Up") {
					direction = 1;
					break;
				}
				else if (buffer == "down" || buffer == "Down") {
					direction = 2;
					break;
				}
				else if (buffer == "exit" || buffer == "Exit") {
					return true;
				}
				else{
					System.out.println("Invalid direction");
				}
			}
			else if(buffer == "Right" || buffer == "right") {
				System.out.println("Up or down");
				buffer = Display.getInput();
				if (buffer == "up" || buffer == "Up") {
					direction = 0;
					break;
				}
				else if (buffer == "down" || buffer == "Down") {
					direction = 3;
					break;
				}
				else if (buffer == "exit" || buffer == "Exit") {
					return true;
				}
				else{
					System.out.println("Invalid direction");
				}
			}
			else if (buffer == "exit" || buffer == "Exit") {
				return true;
			}
		}	
			
			Coordinates destination = whereTo(origin);
			
			if (destination.locX > 7 || destination.locY > 7 || destination.locX < 0 || destination.locY < 0) {
				System.out.println("invalid move");
				return true;
			}
			
			if (!(myBoard[destination.locX][destination.locY] == null)) {
				if(myBoard[destination.locX][destination.locY].getColor() == this.getColor()) {
					System.out.println("you cant Jump your own piece");
					return true;
				}
				else if (myBoard[destination.locX][destination.locY].getColor() != this.getColor()) {
					return jumpPiece(destination);
				}
				else {
					System.out.println("error");
					return true;
				}
			}
			else {
				myBoard[destination.locX][destination.locY] = this;
				myBoard[origin.locX][origin.locY] = null;
				return false;
			}
				
	}
	
	private Boolean jumpPiece(Coordinates jumped) {
			// TODO Auto-generated method stub
		Piece[][] myBoard = Driver.getBoard();
			Coordinates destination = whereTo(jumped);
			if (destination.locX > 7 || destination.locY > 7 || destination.locX < 0 || destination.locY < 0) {
				System.out.println("invalid move");
				return true;
			}
			
			if (myBoard[destination.locX][destination.locY] == null) {
				if (this.color) {
					Driver.redCaptureCnt();
				}else {
					Driver.blackCaptureCnt();
				}
				myBoard[jumped.locX][jumped.locY] = null;
				myBoard[destination.locX][destination.locY] = this;
				myBoard[origin.locX][origin.locY] = null;
				return false;
				
			}else {
				System.out.println("can't jump out of the board");
				return true;
			}
			
			
	}

	private Coordinates whereTo(Coordinates start) {
		int x = start.getLocX();
		int y = start.getLocY();
		
		switch (direction) {
		case 0: 
			x += 1;
			y += 1;
			break;
		case 1: 
			x -= 1; 
			y += 1;
			break;
		case 2: 
			x -= 1; 
			y -= 1;
			break;
		case 3:
			x += 1;
			y -= 1;
			break;
		}
		
			
		return new Coordinates(x,y);
	}
}
