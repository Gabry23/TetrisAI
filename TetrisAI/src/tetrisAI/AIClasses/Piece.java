package tetrisAI.AIClasses;

import java.awt.Image;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import tetrisAI.PlayerClasses.PiecePlayer;

@Id("piece")
public class Piece extends PiecePlayer{


	@Param(0)
	protected Cell[] blocks;

	@Param(1)
	protected boolean state[];
	
	protected Image image;
	
	protected int id;
	
	public boolean isMoving;
	
	public Piece() {
		blocks = new Cell[4];
		state = new boolean[4];
		for(int i=0; i<4; i++) { 
			blocks[i] = new Cell();
			state[i] = false;
		}
		

	}
	
	
	public Cell[] getPiece() {
		return null;
		
	}

	public Image getImage() {
		return image;
	}
	
	public void Rotate(Map map) {
	
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
	
	public boolean canMoveLeft(Map map) {
		
		Cell adj;
		for(int i=0; i<4; i++) {
			if(blocks[i].getColumn()==0)
				return false;
			adj=map.getMatrix()[blocks[i].getRow()][blocks[i].getColumn()-1];
			if(adj.getValue()!=0 && adj.getId()!=this.id) 
				 return false;
		}
	
		return true;
	}


	public boolean canMoveRight(Map map) {
		
		Cell adj;
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
