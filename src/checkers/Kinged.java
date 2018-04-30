package checkers;

public class Kinged extends Piece {

	public Kinged(Boolean color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	
	public Boolean Move(Coordinates origin){
		
		final Object sync = new Object();
		Boolean looping = true;
		
		//Getting input from Display
		Display.getInput(sync, "Enter Direction:");
		try {
			sync.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return looping;
		
	}
}
