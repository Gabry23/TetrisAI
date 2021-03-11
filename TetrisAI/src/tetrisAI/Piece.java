package tetrisAI;

import java.awt.Image;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("piece")
public class Piece {


	@Param(0)
	protected static Cell[] blocks;
	
	protected static Image image;
	
	public Piece() {
		blocks = new Cell[4];
		for(int i=0; i<4; i++) {
			blocks[i] = new Cell();
		}
	}
	

	public static Image getImage() {
		return image;
	}
	
	public static void Rotate() {
		
	}
	
	public static void Accellerate() {
		
	}
	
	
}
