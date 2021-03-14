package tetrisAI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PieceController implements KeyListener {

	private Map map;
	private Piece piece;

	
	public PieceController(Map map) {
		this.map = map;
	}
	
	public void updatePiece(Piece currPiece) {
		piece = currPiece;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			
			if(piece.canMoveLeft(map)) {
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()-1);
			}
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			
			if(piece.canMoveRight(map)) {
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()+1);
			}
			}
			break;	
			
		case KeyEvent.VK_DOWN:
			
			 
			for(int i=0; i<4; i++)
			{
				piece.getPiece()[i].setRow(piece.getPiece()[i].getRow()+1);
			}
			
			
			break;		
			
		case KeyEvent.VK_UP:
		
				piece.Rotate(map);
			
			break;			
			
		
		}
		map.update();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
