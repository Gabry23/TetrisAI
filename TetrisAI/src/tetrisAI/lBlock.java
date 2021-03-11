package tetrisAI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
		
@Id("lBlock")
public class lBlock extends Piece {

	@Param(1)
	private int id = 3;
	
	public lBlock() {
		
		super();
		blocks[0].setRow(0);
		blocks[0].setColumn(5);
		blocks[0].setValue(3);
		blocks[1].setRow(1);
		blocks[1].setColumn(5);
		blocks[1].setValue(3);
		blocks[2].setRow(1);
		blocks[2].setColumn(4);
		blocks[2].setValue(3);
		blocks[3].setRow(1);
		blocks[3].setColumn(3);
		blocks[3].setValue(3);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/orange.png"));
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
	
	public static void Rotate() {
		
	}
}
