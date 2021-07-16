package tetrisAI.PlayerClasses;

import java.awt.Image;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;


public class PiecePlayer {


	protected CellPlayer[] blocks;

	protected boolean state[];
	
	protected Image image;
	
	protected int id;
	
	protected boolean isMoving;
	
	public PiecePlayer() {
		blocks = new CellPlayer[4];
		state = new boolean[4];
		for(int i=0; i<4; i++) { 
			blocks[i] = new CellPlayer();
			state[i] = false;
		}
		

	}
	
	
	public CellPlayer[] getPiece() {
		return null;
		
	}

	public Image getImage() {
		return image;
	}
	
	public void Rotate(MapPlayer map) {
	
	}
	
	public static void Accellerate() {
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public boolean[] getState() {
		return state;
	}


	public void setState(boolean state, int i) {
		this.state[i] = state;
	}


	public boolean isMoving() {
		return isMoving;
	}


	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	
	public boolean canMoveLeft(MapPlayer map) {
		
		CellPlayer adj;
		for(int i=0; i<4; i++) {
			if(blocks[i].getColumn()==0)
				return false;
			adj=map.getMatrix()[blocks[i].getRow()][blocks[i].getColumn()-1];
			if(adj.getValue()!=0 && adj.getId()!=this.id) 
				 return false;
		}
	
		return true;
	}


	public boolean canMoveRight(MapPlayer map) {
		
		CellPlayer adj;
		for(int i=0; i<4; i++) {
			if(blocks[i].getColumn()==9)
				return false;
			adj=map.getMatrix()[blocks[i].getRow()][blocks[i].getColumn()+1];
			if(adj.getValue()!=0 && adj.getId()!=this.id) 
				 return false;
		}
		return true;
	}
	
	
}
