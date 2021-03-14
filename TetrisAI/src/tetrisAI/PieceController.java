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
			
			if(canMoveLeft(piece)) {
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()-1);
			}
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			
			if(canMoveRight(piece)) {
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
		
				piece.Rotate();
			
			break;			
			
		
		}
		map.update();
	}
	
	

	private boolean canMoveLeft(Piece piece) {
		int minColumn = 21;
		int Row = 0;
		for(int i=0; i<4; i++) {
			if(piece.getPiece()[i].getRow() < minColumn) {
				 minColumn = piece.getPiece()[i].getColumn();
				 Row = piece.getPiece()[i].getRow();
			}
		}
		
		if(minColumn == 0) {
			return false;
		}
		
		else if(map.getMatrix()[Row][minColumn-1].getValue() == 0) {
			return true;
		}
		
		return false;
	}


	private boolean canMoveRight(Piece piece) {
		int maxColumn = 0;
		int Row = 0;
		for(int i=0; i<4; i++) {
			if(piece.getPiece()[i].getRow() > maxColumn) {
				 maxColumn = piece.getPiece()[i].getColumn();
				 Row = piece.getPiece()[i].getRow();
			}
		}
		
		if(maxColumn == 9) {
			return false;
		}
		
		else if(map.getMatrix()[Row][maxColumn+1].getValue() == 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
