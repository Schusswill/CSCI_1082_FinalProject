package checkers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField inputText = new JTextField();
	JTextArea textOut;
	
	public Display() {
		super("Checkers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,800);
		boardPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		JPanel spacer = new JPanel();
		contentPane.add(spacer);
		boardPane.setBackground(Color.gray);
		boardPane.setOpaque(true);
		boardPane.setBounds(0, 0, 600, 600);
		spacer.add(boardPane);
		boardPane.setLayout(new GridLayout(8,8));
		
		JPanel controllPanel = new JPanel();
		contentPane.add(controllPanel, BorderLayout.SOUTH);
		controllPanel.setLayout(new BorderLayout());
		textOut = new JTextArea();
		textOut.setEditable(false);
		textOut.setSize(600,400);
		textOut.setBackground(Color.BLACK);
		textOut.setForeground(Color.white);
		JScrollPane scrollableTextOut = new JScrollPane(textOut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		controllPanel.add(scrollableTextOut, BorderLayout.CENTER);
		JPanel inputPanel = new JPanel();
		controllPanel.add(inputPanel, BorderLayout.SOUTH);
		inputPanel.add(inputText);
		inputText.setColumns(30);
		inputText.addActionListener(new EnterListener());
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new EnterListener());
		inputPanel.add(enterButton);
		
		
		
		for(int i = 0; i < 64; i++) {
			spaces[i] = new JLabel();
			spaces[i].setBorder(new BevelBorder(1));
			boardPane.add(spaces[i]);
		}
		update();
	}
	
	private class EnterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			textOut.append("Test\n");
			// TODO Auto-generated method stub
			
		}
		
	}

	
	public void update() {
		Piece[][] myBoard = Driver.getBoard();
		ImageIcon imageBlack = new ImageIcon("SRC\\Images\\BlackPiece.png");
		ImageIcon imageRed = new ImageIcon("SRC\\Images\\RedPiece.png");
		ImageIcon imageKingedRed = new ImageIcon("SRC\\Images\\kingedRed.png");
		ImageIcon imageKingedBlack = new ImageIcon("SRC\\Images\\KingedBlack.png");
		int index = 0;
		for(int x = 0; x < 8;x++) {
			for(int y = 0; y < 8; y++) {
				if(myBoard[x][y] == null) {
					spaces[index].setBackground(Color.WHITE);
					spaces[index].setIcon(null);
					
					index++;
				} 
				else if(myBoard[x][y].getKinged()) {
					
					if (myBoard[x][y].getColor()) {
						spaces[index].setIcon(imageKingedBlack);
						
						index++;
					}
					else if (!(myBoard[x][y].getColor())) {
						spaces[index].setIcon(imageKingedRed);
						
						index++;
						}
					
				}else {
					
					if (myBoard[x][y].getColor()) {
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
}


