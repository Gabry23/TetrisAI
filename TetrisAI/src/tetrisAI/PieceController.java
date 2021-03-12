package tetrisAI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PieceController implements KeyListener {

	
	private Piece piece;
	
	
	public PieceController(Piece currPiece) {
		piece = currPiece;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()-1);
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()+1);
			}
			break;	
			
		case KeyEvent.VK_DOWN:
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setRow(piece.getPiece()[i].getRow()+1);
			}
			break;		
		
		
		
		}
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
