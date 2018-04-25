package checkers;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class Display extends JFrame	{

	/**
	 * 
	 */
//	private Piece[][] myBoard = new Piece[][]{
//		{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
//		{null,new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true)},
//		{new Piece(true),null,new Piece(true),null,new Piece(true),null,new Piece(true),null},
//		{null,null,null,null,null,null,null,null},
//		{null,null,null,null,null,null,null,null},
//		{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)},
//		{new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false),null},
//		{null,new Piece(false),null,new Piece(false),null,new Piece(false),null,new Piece(false)}
//	};
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel boardPane;
	private JLabel[] spaces = new JLabel[64];
	JTextArea textOut;
	
	public Display() {
		super("Chekers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,1200);
		boardPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2,1,0,0));
		setContentPane(contentPane);
		JPanel spacer = new JPanel();
		contentPane.add(spacer);
		boardPane.setBackground(Color.gray);
		boardPane.setOpaque(true);
		boardPane.setBounds(0, 0, 600, 600);
		spacer.add(boardPane);
		boardPane.setLayout(new GridLayout(8,8));
		
		textOut = new JTextArea();
		textOut.setBackground(Color.BLACK);
		contentPane.add(new JScrollPane(textOut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		
		
		for(int i = 0; i < 64; i++) {
			spaces[i] = new JLabel();
			spaces[i].setBorder(new BevelBorder(1));
			boardPane.add(spaces[i]);
		}
		update();
	}
	
//	public void paint(Graphics g) {
//		g.fillRect(100, 100, 400, 400);
//		for(int i = 100; i<= 400; i +=100) {
//			for (int j = 100; j <= 400; j+=100) {
//				g.clearRect(i, j, 50, 50);
//			}
//			
//		}
//		for(int i = 150; i <= 450; i +=100) {
//			for(int j = 150; j<= 450; j +=100) {
//				g.clearRect(i, j, 50, 50);
//			}
//		}
//	}
	public void update() {
		Piece[][] myBoard = Driver.getBoard();
		ImageIcon imageBlack = new ImageIcon("Images\\BlackPiece.png");
		ImageIcon imageRed = new ImageIcon("Images\\RedPiece.png");
		int index = 0;
		for(int x = 0; x < 8;x++) {
			for(int y = 0; y < 8; y++) {
				if(myBoard[x][y] == null) {
					spaces[index].setBackground(Color.WHITE);
					spaces[index].setIcon(null);
					
					index++;
				}
				else if (myBoard[x][y].getColor()) {
					spaces[index].setIcon(imageBlack);
					
					index++;
				}
				else if (!(myBoard[x][y].getColor())) {
					spaces[index].setIcon(imageRed);
					
					index++;
					
				}
			}
		}
	}
}


