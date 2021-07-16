package tetrisAI.AIClasses;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.Media;
import javax.swing.JFrame;

import tetrisAI.AIBlocks.iBlock;
import tetrisAI.AIBlocks.jBlock;
import tetrisAI.AIBlocks.lBlock;
import tetrisAI.AIBlocks.oBlock;
import tetrisAI.AIBlocks.sBlock;
import tetrisAI.AIBlocks.tBlock;
import tetrisAI.AIBlocks.zBlock;
import tetrisAI.Game.Gameloop;
import tetrisAI.PlayerClasses.PieceController;
import tetrisAI.View.ScorePanel;

public class Game implements Runnable{

	private Map map;
	private static int id = 0;
	private static EmptyBlock eb;
	private Piece piece;
	private Random random;
	private PieceController pc;
	//private ASPSolver asp; 
	private Thread t;
	
	public Game() {
		
		eb = new EmptyBlock(0,0,0);
		map = new Map(this);
	
//		asp = new ASPSolver();

		
	}	
	
	public  void checkDeleteCondition() {
		if(!Gameloop.getInstance().getCurrPiece().isMoving()) {
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
				ScorePanel.getInstance().setScoreAI(ScorePanel.getInstance().getScoreAI()+10);
			}
		}
		}
		
	}


	private  void lowMatrix(int index) {
		if(index!=0) {
		for(int i=index;i>=0;i--){
			for(int j=0; j<map.getMatrix()[i].length; j++) {	
					Cell temp;
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


	public  void clearSuppMatrix() {
		
		if(!SuppMatrixIsEmpty())
		for(int i=0; i<map.getMatrix().length; i++) {
			for(int j=0; j<map.getMatrix()[i].length; j++) {
			if(map.getSuppMatrix()!=null)
				if(map.getSuppMatrix()[i][j].getValue()>0) {	
					eb.setRow(i);
					eb.setColumn(j);
					map.getSuppMatrix()[i][j] =  eb;
				}
			}		
		}
	}


	public  void Copy(Cell[][] matrix, Cell[][] suppMatrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = suppMatrix[i][j];
			}
		}
	}


	public  boolean checkScrollCondition(Map map, Piece currPiece) {

		for(int i=0; i<4; i++) {
			
			if(currPiece.getPiece()[i].getRow()<=18) {
				
			if(map.getMatrix()[currPiece.getPiece()[i].getRow()+1][currPiece.getPiece()[i].getColumn()].getId()!=currPiece.getId() && map.getMatrix()[currPiece.getPiece()[i].getRow()+1][currPiece.getPiece()[i].getColumn()].getValue()!=0) {
				return false;
			}
			}
			else {
				return false;
			}
		
			
		}
		return true;
		
	}




	public Piece createPiece() {
	
		random = new Random();
		int min = 1; // numero minimo
		int max = 7; // numero massimo
		int c = ((max-min) + 1);
		int rand = random.nextInt(c) + min;
		piece = null;
		
		switch(rand) {
		case 1:
			piece = new iBlock();
			addPiece(piece);
			((iBlock) piece).setMoving(true);
			
			break;
		case 2:
			piece = new jBlock();
			addPiece(piece);
			((jBlock) piece).setMoving(true);
			
			break;
		case 3:
			piece = new lBlock();
			addPiece(piece);
			((lBlock) piece).setMoving(true);
			
			break;
		case 4:
			piece = new oBlock();
			addPiece(piece);
			((oBlock) piece).setMoving(true);
			
			break;
		case 5:
			piece = new sBlock();
			addPiece(piece);
			((sBlock) piece).setMoving(true);
			
			break;
		case 6:
			piece = new tBlock();
			addPiece(piece);
			((tBlock) piece).setMoving(true);
			
			break;
		case 7:
			piece = new zBlock();
			addPiece(piece);
			((zBlock) piece).setMoving(true);

			break;
			
		}
		
		piece.setId(id);
		
		for(int k=0;k<4;k++)
			piece.getPiece()[k].setId(id);
		
		id++;
		
		return piece;
		
		
	}
	
	public  void addPiece(Piece piece) {
		for(int i=0;i<4;i++)
		map.getSuppMatrix()[piece.getPiece()[i].getRow()][piece.getPiece()[i].getColumn()] = piece.getPiece()[i];
	}

	public  boolean SuppMatrixIsEmpty(){
		for(int i=0; i<map.getMatrix().length; i++) {
			for(int j=0; j<map.getMatrix()[i].length; j++) {
				if(map.getSuppMatrix()[i][j].getValue()!=0)
					return false;
			}
		}
	 return true;
	}
	
	public void gameConditions(List<Piece> pieces, boolean updatable) {
		if(!Gameloop.getInstance().getCurrPiece().isMoving()) {
			checkDeleteCondition();
			
			pieces.add(createPiece());

			Gameloop.getInstance().setCurrPiece(pieces.get(pieces.size()-1));
			
			ASPSolver.getInstance().addPiece(Gameloop.getInstance().getCurrPiece(), map,this);

			
			ASPSolver.getInstance().updateAspCells(map);
		}
			
		updatable=true;
			
			for(int i=0; i<map.getMatrix().length; i++) {
		
				
				for(int j=0; j<map.getMatrix()[i].length; j++) {
					
					if(map.getMatrix()[i][j].getValue()>0) {
					

						if( checkScrollCondition(map, Gameloop.getInstance().getCurrPiece())) {
												
							if(updatable) {	
								for(int k=0; k<4; k++) {
									Gameloop.getInstance().getCurrPiece().getPiece()[k].setRow(Gameloop.getInstance().getCurrPiece().getPiece()[k].getRow()+1);
									map.getSuppMatrix()[Gameloop.getInstance().getCurrPiece().getPiece()[k].getRow()][Gameloop.getInstance().getCurrPiece().getPiece()[k].getColumn()] = Gameloop.getInstance().getCurrPiece().getPiece()[k];
									
								}
					
							updatable=false;
						
							}
								
						}
						else if(!checkScrollCondition(map, Gameloop.getInstance().getCurrPiece()) && Gameloop.getInstance().getCurrPiece().getPiece()[0].getRow()<1){	
							Gameloop.getInstance().setGameoverai(true);
						}
									
						else{
							sleepTime(100);
							
							if((checkScrollCondition(map, Gameloop.getInstance().getCurrPiece())))
								continue;
							
							Gameloop.getInstance().getCurrPiece().setMoving(false);
							
							for(int k=0; k<4; k++) {
								Gameloop.getInstance().getCurrPiece().getPiece()[k].setValue(Gameloop.getInstance().getCurrPiece().getPiece()[k].getValue()*-1);	
							}
							
						}
		
					}
				
				}
				
			
			}
			
			
			//ASPSolver.getInstance().updateMovement(currPiece, map);
			
			
			
}


	@Override
	public void run() {
		while(true) {
			if(Gameloop.getInstance().getCurrPiece()!=null && map.getSuppMatrix() != null) {
				Copy(map.getMatrix(),map.getSuppMatrix());
				clearSuppMatrix();
				addPiece(Gameloop.getInstance().getCurrPiece());
			}
			
			
			map.update();
			ScorePanel.getInstance().repaint();
		//	ASPSolver.getInstance().addPiece(piece);
	//		asp.addPiece(piece);
			sleepTime(10);
		}
	}
	
	public  void sleepTime(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  Map getMap() {
		return map;
	}
	
}