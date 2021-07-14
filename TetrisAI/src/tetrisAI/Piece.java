package tetrisAI;

import java.awt.Image;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("piece")
public class Piece {


	@Param(0)
	protected static Cell[] blocks;

	@Param(1)
	protected static boolean state[];
	
	protected static Image image;
	
	protected static int id;
	
	protected boolean isMoving;
	
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

	public static Image getImage() {
		return image;
	}
	
	public void Rotate(Map map) {
	
	}
	
	public static void Accellerate() {
		
	}
	
	public static int getId() {
		return id;
	}


	public static void setId(int id) {
		Piece.id = id;
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
