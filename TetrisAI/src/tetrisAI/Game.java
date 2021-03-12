package tetrisAI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class Game implements Runnable {

	private static Map map;
	private static int id = 0;
	private static EmptyBlock eb;
	
	public Game() {
		startGame();
		
	}
	
	
	public void startGame() {
		JFrame f = new JFrame();
		f.setTitle("TETRIS AI...SPETTACOLO............");
		f.setSize(520, 750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eb = new EmptyBlock(0,0,0);
		map = new Map();
		f.add(map);
		f.setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}


	@Override
	public void run() {
		
		List<Piece> pieces = new ArrayList<Piece>();
		
		boolean updatable;
		
		pieces.add(createPiece());
		Piece currPiece = pieces.get(pieces.size()-1);
	
		while(true) {
		
		if(!currPiece.isMoving()) {
			pieces.add(createPiece());
			currPiece = pieces.get(pieces.size()-1);
		}
			
		updatable=true;
			
		
			for(int i=0; i<map.getMatrix().length; i++) {
		
				
				for(int j=0; j<map.getMatrix()[i].length; j++) {
					
					if(map.getMatrix()[i][j].getValue()>0) {
					

						if( checkScrollCondition(map, currPiece)) {
												
							if(updatable) {	
								for(int k=0; k<4; k++) {
									currPiece.getPiece()[k].setRow(currPiece.getPiece()[k].getRow()+1);
									map.getSuppMatrix()[currPiece.getPiece()[k].getRow()][currPiece.getPiece()[k].getColumn()] = currPiece.getPiece()[k]; 
								}
							updatable=false;
						
							}
								
						}
									
						else {
							System.out.println("a");
							currPiece.setMoving(false);
							for(int k=0; k<4; k++) {
								currPiece.getPiece()[k].setValue(currPiece.getPiece()[k].getValue()*-1);
						
								System.out.println(currPiece.getPiece()[k].getRow());
								System.out.println(currPiece.getPiece()[k].getColumn());
								System.out.println(currPiece.getPiece()[k].getValue());
							}
				
						}
		
					}
				
				}
				
			
			}
			Copy(map.getMatrix(), map.getSuppMatrix());		
			clearSuppMatrix();
			
			map.update();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
	
	
	
	private void clearSuppMatrix() {

		for(int i=0; i<map.matrix.length; i++) {
			for(int j=0; j<map.matrix[i].length; j++) {
			
				if(map.getSuppMatrix()[i][j].getValue()>=0) {	
					eb.setRow(i);
					eb.setColumn(j);
					map.getSuppMatrix()[i][j] =  eb;
				}
			}		
		}
	}


	private void Copy(Cell[][] matrix, Cell[][] suppMatrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = suppMatrix[i][j];
			}
		}
	}


	private boolean checkScrollCondition(Map map, Piece currPiece) {

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
		
		Random random = new Random();
		int min = 1; // numero minimo
		int max = 7; // numero massimo
		int c = ((max-min) + 1);
		int rand = random.nextInt(c) + min;
		Piece piece = null;
		
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
	
	public void addPiece(Piece piece) {
		for(int i=0;i<4;i++)
		map.getSuppMatrix()[piece.getPiece()[i].getRow()][piece.getPiece()[i].getColumn()] = piece.getPiece()[i];
	}
	
	public void printMatrix() {
		for(int i=0; i<map.matrix.length; i++) {
			for(int j=0; j<map.matrix[i].length; j++) {
				System.out.print(map.getMatrix()[i][j].getValue());
			}	
			System.out.println("");
		}
	}
	
	
	
	
}
