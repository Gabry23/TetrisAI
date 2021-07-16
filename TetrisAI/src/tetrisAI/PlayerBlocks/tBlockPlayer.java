package tetrisAI.PlayerBlocks;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import tetrisAI.PlayerClasses.CellPlayer;
import tetrisAI.PlayerClasses.MapPlayer;
import tetrisAI.PlayerClasses.PiecePlayer;
		

public class tBlockPlayer extends PiecePlayer {

	private int id = 6;
	
	private int value = 6;
	
	public tBlockPlayer() {
		
		super();
		blocks[0].setRow(0);
		blocks[0].setColumn(4);
		blocks[0].setValue(6);
		blocks[1].setRow(1);
		blocks[1].setColumn(3);
		blocks[1].setValue(6);
		blocks[2].setRow(1);
		blocks[2].setColumn(4);
		blocks[2].setValue(6);
		blocks[3].setRow(1);
		blocks[3].setColumn(5);
		blocks[3].setValue(6);
		this.setState(true, 0);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/purple.png"));
			Image icon = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			image = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public CellPlayer[] getPiece() {
		return blocks;
		
	}
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void Rotate(MapPlayer map) {
		
		
	if(state[0] == true) {
			
			blocks[0].setRow(blocks[0].getRow()+1);
			blocks[0].setColumn(blocks[0].getColumn()-1);
			
			blocks[1].setRow(blocks[1].getRow()+1);
			blocks[1].setColumn(blocks[1].getColumn()+1);
			
			blocks[3].setRow(blocks[3].getRow()-1);
			blocks[3].setColumn(blocks[3].getColumn()-1);
			
			state[0] = false;
			state[1] = true;
			
			}
			
			
			else if(state[1] == true) {
				blocks[0].setRow(blocks[0].getRow()+1);
				blocks[0].setColumn(blocks[0].getColumn()+1);
				
				blocks[1].setRow(blocks[1].getRow()-1);
				blocks[1].setColumn(blocks[1].getColumn()+1);
				
				blocks[3].setRow(blocks[3].getRow()+1);
				blocks[3].setColumn(blocks[3].getColumn()-1);
				
				state[2] = true;
				state[1] = false;
				
				}
		
			else if(state[2] == true) {
				blocks[0].setRow(blocks[0].getRow()-1);
				blocks[0].setColumn(blocks[0].getColumn()+1);
				
				blocks[1].setRow(blocks[1].getRow()-1);
				blocks[1].setColumn(blocks[1].getColumn()-1);
				
				blocks[3].setRow(blocks[3].getRow()+1);
				blocks[3].setColumn(blocks[3].getColumn()+1);
				
				state[3] = true;
				state[2] = false;
				
				}
		
			else if(state[3] == true) {
				
				blocks[0].setRow(blocks[0].getRow()-1);
				blocks[0].setColumn(blocks[0].getColumn()-1);
				
				blocks[1].setRow(blocks[1].getRow()+1);
				blocks[1].setColumn(blocks[1].getColumn()-1);
				
				blocks[3].setRow(blocks[3].getRow()-1);
				blocks[3].setColumn(blocks[3].getColumn()+1);
				
				state[0] = true;
				state[3] = false;
				
				}
	
	}
}
