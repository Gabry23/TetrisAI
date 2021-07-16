package tetrisAI.AIBlocks;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import tetrisAI.AIClasses.Cell;
import tetrisAI.AIClasses.Map;
import tetrisAI.AIClasses.Piece;
		

public class iBlock extends Piece {

	
	private int id = 1;
	

	private int X1;

	private int Y1;

	private int X2;

	private int Y2;

	private int X3;

	private int Y3;

	private int X4;

	private int Y4;

	private int value = 1;
	
	
	
	
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
		
		X1 = blocks[0].getRow();
		Y1 = blocks[0].getColumn();
		
		X2 = blocks[1].getRow();
		Y2 = blocks[1].getColumn();
		
		X3 = blocks[2].getRow();
		Y3 = blocks[2].getColumn();
		
		X4 = blocks[3].getRow();
		Y4 = blocks[3].getColumn();
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/cyan.png"));
			Image icon = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			image = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public iBlock(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int v) {
		super();
		X1 = x1;
		X2 = x2;
		X3 = x3;
		X4 = x4;
		Y1 = y1;
		Y2 = y2;
		Y3 = y3;
		Y4 = y4;
		value = v;
	}

	public int getX1() {
		return X1;
	}

	public void setX1(int x1) {
		X1 = x1;
	}

	public int getY1() {
		return Y1;
	}

	public void setY1(int y1) {
		Y1 = y1;
	}

	public int getX2() {
		return X2;
	}

	public void setX2(int x2) {
		X2 = x2;
	}

	public int getY2() {
		return Y2;
	}

	public void setY2(int y2) {
		Y2 = y2;
	}

	public int getX3() {
		return X3;
	}

	public void setX3(int x3) {
		X3 = x3;
	}

	public int getY3() {
		return Y3;
	}

	public void setY3(int y3) {
		Y3 = y3;
	}

	public int getX4() {
		return X4;
	}

	public void setX4(int x4) {
		X4 = x4;
	}

	public int getY4() {
		return Y4;
	}

	public void setY4(int y4) {
		Y4 = y4;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
