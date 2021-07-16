package tetrisAI.PlayerClasses;

import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;

import tetrisAI.Game.Gameloop;

public class PieceController implements KeyListener {

	private MapPlayer map;
	private PiecePlayer piece;
	private GamePlayer game;
	
	public PieceController(MapPlayer map,GamePlayer game2) {
		this.map = map;
		this.game = game2; 
	}

	public void updatePiece(PiecePlayer currPiece) {
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
			System.out.println(piece.canMoveLeft(map));
			if(piece.canMoveLeft(map)) {
				
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()-1);
			}
			}
			
			break;
			
		case KeyEvent.VK_RIGHT:
			System.out.println(piece.canMoveRight(map));
			if(piece.canMoveRight(map)) {
				
			for(int i=0; i<4; i++) {
				piece.getPiece()[i].setColumn(piece.getPiece()[i].getColumn()+1);
			}
			}
			
			break;	
			
		case KeyEvent.VK_DOWN:
			Gameloop.getInstance().setSleepTime(50);
			break;		
			
		case KeyEvent.VK_UP:
		if((!piece.canMoveLeft(map) && !piece.canMoveRight(map))||(piece.getPiece()[0].getRow()<1))
			break;
			piece.Rotate(map);
			
			break;			
		}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			Gameloop.getInstance().setSleepTime(200);
			break;	
		}
	}
}
