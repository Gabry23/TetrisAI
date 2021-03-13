package tetrisAI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PieceController implements KeyListener {

	private Map map;
	private Piece piece;
	
	
	public PieceController(Piece currPiece,Map map) {
		piece = currPiece;
		this.map = map;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
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
			
		case KeyEvent.VK_UP:
		
				piece.Rotate();
			
			break;			
			
		
		}
		map.update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
