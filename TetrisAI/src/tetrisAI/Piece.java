package tetrisAI;

import java.awt.Image;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("piece")
public class Piece {


	@Param(0)
	protected static Cell[] blocks;
	
	protected static Image image;
	
	protected static int id;
	
	public static int getId() {
		return id;
	}


	public static void setId(int id) {
		Piece.id = id;
	}


	protected boolean isMoving;
	
	public Piece() {
		blocks = new Cell[4];
		for(int i=0; i<4; i++) {
			blocks[i] = new Cell();
		}
	}
	
	
	public Cell[] getPiece() {
		return null;
		
	}

	public Image getImage() {
		return image;
	}
	
	public static void Rotate() {
		
	}
	
	public static void Accellerate() {
		
	}
	


	public boolean isMoving() {
		return isMoving;
	}


	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	
	
}
