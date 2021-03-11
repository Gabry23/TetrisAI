package tetrisAI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
		
@Id("iBlock")
public class iBlock extends Piece {

	@Param(1)
	private int id = 1;
	
	public iBlock() {
		
		super();
		blocks[0].setRow(0);
		blocks[0].setColumn(4);
		blocks[0].setValue(1);
		blocks[1].setRow(0);
		blocks[1].setColumn(5);
		blocks[1].setValue(1);
		blocks[2].setRow(0);
		blocks[2].setColumn(6);
		blocks[2].setValue(1);
		blocks[3].setRow(0);
		blocks[3].setColumn(7);
		blocks[3].setValue(1);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/cyan.png"));
			Image icon = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			image = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public iBlock getType() {
		return this;
	}
	
	@Override
	public Cell[] getPiece() {
		return blocks;
		
	}
	
	public static void Rotate() {
		
	}
}
