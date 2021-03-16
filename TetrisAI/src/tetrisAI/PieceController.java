package tetrisAI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PieceController implements KeyListener {

	private Map map;
	private Piece piece;
	private Game game;
	
	public PieceController(Map map,Game game) {
		this.map = map;
		this.game = game;
	}
	
	public void updatePiece(Piece currPiece) {
		piece = currPiece;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(piece.isMoving()) {
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
			game.getLoop().setSleepTime(100);
			break;		
			
		case KeyEvent.VK_UP:
		
				piece.Rotate(map);
			
			break;			
			
		
		}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			game.getLoop().setSleepTime(600);
			break;	
		}
	}
}
