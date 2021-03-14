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
		this.setState(true, 0);
		
		
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
	
	public Cell[] getPiece() {
		return blocks;
		
	}
	
	public void Rotate(Map map) {
		boolean restoreLeft = false;
		boolean restoreRight = false;
		
		if(!this.canMoveLeft(map)) {
			blocks[0].setColumn(blocks[0].getColumn()+2);
			blocks[1].setColumn(blocks[1].getColumn()+2);
			blocks[2].setColumn(blocks[2].getColumn()+2);
			blocks[3].setColumn(blocks[3].getColumn()+2);
			restoreLeft = true;
		}
		
		else if(!this.canMoveRight(map)) {
			blocks[0].setColumn(blocks[0].getColumn()-1);
			blocks[1].setColumn(blocks[1].getColumn()-1);
			blocks[2].setColumn(blocks[2].getColumn()-1);
			blocks[3].setColumn(blocks[3].getColumn()-1);
			restoreRight = true;
		}
		
		if(state[0] == true) {
		
		blocks[0].setRow(blocks[0].getRow()+2);
		blocks[0].setColumn(blocks[0].getColumn()+2);
		
		blocks[1].setRow(blocks[1].getRow()+1);
		blocks[1].setColumn(blocks[1].getColumn()+1);
		
		blocks[3].setRow(blocks[3].getRow()-1);
		blocks[3].setColumn(blocks[3].getColumn()-1);
		
		state[0] = false;
		state[1] = true;
		
		}
		
		else if(state[1] == true) {
			blocks[0].setRow(blocks[0].getRow()-2);
			blocks[0].setColumn(blocks[0].getColumn()-2);
			
			blocks[1].setRow(blocks[1].getRow()-1);
			blocks[1].setColumn(blocks[1].getColumn()-1);
			
			blocks[3].setRow(blocks[3].getRow()+1);
			blocks[3].setColumn(blocks[3].getColumn()+1);
			
			state[0] = true;
			state[1] = false;
			
			}
		
		if(this.canMoveLeft(map) && restoreLeft) {
			blocks[0].setColumn(blocks[0].getColumn()-2);
			blocks[1].setColumn(blocks[1].getColumn()-2);
			blocks[2].setColumn(blocks[2].getColumn()-2);
			blocks[3].setColumn(blocks[3].getColumn()-2);
			restoreLeft = false;
		}
		
		if(this.canMoveRight(map) && restoreRight) {
			blocks[0].setColumn(blocks[0].getColumn()+1);
			blocks[1].setColumn(blocks[1].getColumn()+1);
			blocks[2].setColumn(blocks[2].getColumn()+1);
			blocks[3].setColumn(blocks[3].getColumn()+1);
			restoreRight = false;
		}
	}
}
