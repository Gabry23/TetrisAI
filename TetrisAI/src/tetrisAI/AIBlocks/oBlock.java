package tetrisAI.AIBlocks;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import tetrisAI.AIClasses.Cell;
import tetrisAI.AIClasses.Piece;
		

public class oBlock extends Piece {


	private int id = 4;
	
	private int value = 4;
	
	public oBlock() {
		
		super();
		blocks[0].setRow(0);
		blocks[0].setColumn(4);
		blocks[0].setValue(4);
		blocks[1].setRow(0);
		blocks[1].setColumn(5);
		blocks[1].setValue(4);
		blocks[2].setRow(1);
		blocks[2].setColumn(4);
		blocks[2].setValue(4);
		blocks[3].setRow(1);
		blocks[3].setColumn(5);
		blocks[3].setValue(4);
		this.setState(true, 0);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/yellow.png"));
			Image icon = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			image = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Cell[] getPiece() {
		return blocks;
		
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void Rotate() {
		
	}
}
