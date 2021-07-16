package tetrisAI.PlayerClasses;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import tetrisAI.Game.Gameloop;
import tetrisAI.PlayerBlocks.iBlockPlayer;
import tetrisAI.PlayerBlocks.jBlockPlayer;
import tetrisAI.PlayerBlocks.lBlockPlayer;
import tetrisAI.PlayerBlocks.oBlockPlayer;
import tetrisAI.PlayerBlocks.sBlockPlayer;
import tetrisAI.PlayerBlocks.tBlockPlayer;
import tetrisAI.PlayerBlocks.zBlockPlayer;
import tetrisAI.View.ScorePanel;

public class GamePlayer implements Runnable{

	private MapPlayer map;
	private static int id = 0;
	private static EmptyBlockPlayer eb;
	private PiecePlayer piece;
	private Random random;
	
	public GamePlayer() {
	
		eb = new EmptyBlockPlayer(0,0,0);
		map = new MapPlayer(this);


	}	
	
	public void checkDeleteCondition() {
		
		
		if(!Gameloop.getInstance().getCurrPiecePlayer().isMoving()) {
		boolean full;
		
		for(int i=map.getMatrix().length-1; i>=0; i--) {
			 full = true;
			for(int j=0; j<map.getMatrix()[i].length; j++) {
			
				if(map.getSuppMatrix()[i][j].getValue() == 0) {	
					full = false;
				}
			}
			if(full) {
				for(int k=0; k<map.getMatrix()[i].length; k++) {
					eb.setRow(i);
					eb.setColumn(k);
					map.getSuppMatrix()[i][k]=eb;		
				}
				lowMatrix(i-1); 
				ScorePanel.getInstance().setScorePlayer(ScorePanel.getInstance().getScorePlayer()+10);
			}
		}
		}
		
	}


	private void lowMatrix(int index) {
		if(index!=0) {
		for(int i=index;i>=0;i--){
			for(int j=0; j<map.getMatrix()[i].length; j++) {	
					CellPlayer temp;
					temp = map.getSuppMatrix()[i][j];
					temp.setRow(map.getSuppMatrix()[i][j].getRow()+1);
					eb.setRow(i);
					eb.setColumn(j);
					map.getSuppMatrix()[i][j]=eb; 
					map.getSuppMatrix()[i+1][j]=temp;
			}
		}
		checkDeleteCondition();
		}
	}


	public void clearSuppMatrix() {

		for(int i=0; i<map.getMatrix().length; i++) {
			for(int j=0; j<map.getMatrix()[i].length; j++) {
			
				if(map.getSuppMatrix()[i][j].getValue()>0) {	
					eb.setRow(i);
					eb.setColumn(j);
					map.getSuppMatrix()[i][j] =  eb;
				}
			}		
		}
	}


	public void Copy(CellPlayer[][] matrix, CellPlayer[][] suppMatrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = suppMatrix[i][j];
			}
		}
	}


	public boolean checkScrollCondition(MapPlayer map2, PiecePlayer currPiecePlayer) {

		for(int i=0; i<4; i++) {
			
			if(currPiecePlayer.getPiece()[i].getRow()<=18) {
				
			if(map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow()+1][currPiecePlayer.getPiece()[i].getColumn()].getId()!=currPiecePlayer.getId() && map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow()+1][currPiecePlayer.getPiece()[i].getColumn()].getValue()!=0) {
				return false;
			}
			}
			else {
				return false;
			}
		
			
		}
		return true;
		
	}
	
	public void gameConditions(List<PiecePlayer> pieces,boolean updatable) {
		
		if(Gameloop.getInstance().getCurrPiecePlayer() == null || !Gameloop.getInstance().getCurrPiecePlayer().isMoving()) {
			
			checkDeleteCondition();
			pieces.add(createPiecePlayer());

			Gameloop.getInstance().setCurrPiecePlayer(pieces.get(pieces.size()-1));
			
			map.getController().updatePiece(Gameloop.getInstance().getCurrPiecePlayer());	
			
		}
			
		updatable=true;
			
		
			for(int i=0; i<map.getMatrix().length; i++) {
		
				
				for(int j=0; j<map.getMatrix()[i].length; j++) {
					
					if(map.getMatrix()[i][j].getValue()>0) {
					
						if( checkScrollCondition(map, Gameloop.getInstance().getCurrPiecePlayer())) {
							
							if(updatable) {	
								for(int k=0; k<4; k++) {
									
									Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].setRow(Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].getRow()+1);
									map.getSuppMatrix()[Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].getRow()][Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].getColumn()] = Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k];
									
								}
					
							updatable=false;
						
							}
								
						}
						else if(!checkScrollCondition(map, Gameloop.getInstance().getCurrPiecePlayer()) && Gameloop.getInstance().getCurrPiecePlayer().getPiece()[0].getRow()<1){	
							
							Gameloop.getInstance().setGameoverPlayer(true);
							//return;
						}
									
						else{
							sleepTime(100);
							
							if((checkScrollCondition(map, Gameloop.getInstance().getCurrPiecePlayer())))
								continue;
							
							Gameloop.getInstance().getCurrPiecePlayer().setMoving(false);
							
							for(int k=0; k<4; k++) {
								Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].setValue(Gameloop.getInstance().getCurrPiecePlayer().getPiece()[k].getValue()*-1);	
							}
							
						}
		
					}
				
				}
				
			
			}
			
			
}



	public PiecePlayer createPiecePlayer() {
		
		random = new Random();
		int min = 1; // numero minimo
		int max = 7; // numero massimo
		int c = ((max-min) + 1);
		int rand = random.nextInt(c) + min;
		piece = null;
		
		switch(rand) {
		case 1:
			piece = new iBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 2:
			piece = new jBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 3:
			piece = new lBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 4:
			piece = new oBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 5:
			piece = new sBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 6:
			piece = new tBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);
			
			break;
		case 7:
			piece = new zBlockPlayer();
			addPiecePlayer(piece);
			piece.setMoving(true);

			break;
			
		}
		
		piece.setId(id);
		
		for(int k=0;k<4;k++)
			piece.getPiece()[k].setId(id);
		
		id++;
		
		
		return piece;
		
		
	}
	
	public void addPiecePlayer(PiecePlayer piece2) {
		for(int i=0;i<4;i++) {
		map.getSuppMatrix()[piece2.getPiece()[i].getRow()][piece2.getPiece()[i].getColumn()] = piece2.getPiece()[i];
		}
	}

	public boolean SuppMatrixIsEmpty(){
		for(int i=0; i<map.getMatrix().length; i++) {
			for(int j=0; j<map.getMatrix()[i].length; j++) {
				if(map.getSuppMatrix()[i][j].getValue()!=0)
					return false;
			}
		}
	 return true;
	}


	@Override
	public void run() {
		while(true) {
			
			if(Gameloop.getInstance().getCurrPiecePlayer()!=null && map.getSuppMatrix() != null) {
				
				Copy(map.getMatrix(),map.getSuppMatrix());
				clearSuppMatrix();
				addPiecePlayer(Gameloop.getInstance().getCurrPiecePlayer());
			}
			map.update();
			ScorePanel.getInstance().repaint();
			sleepTime(10);
		}
	}
	
	public void sleepTime(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MapPlayer getMapPlayer() {
		return map;
	}
	
}