package tetrisAI;

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
		
		Piece currPiece = createPiece();
		

	
		while(true) {
			
		
			
		
			for(int i=0; i<map.getMatrix().length; i++) {
		
				
				for(int j=0; j<map.getMatrix()[i].length; j++) {
					
					if(map.getMatrix()[i][j].getValue()>0) {
					

						if( checkScrollCondition(map, currPiece)) {
												
							
						/*	for(int k=0; k<4; k++) {
						 
								currPiece.getPiece()[k].setRow(currPiece.getPiece()[k].getRow()+1);
								map.getSuppMatrix()[currPiece.getPiece()[k].getRow()][currPiece.getPiece()[k].getColumn()] = currPiece.getPiece()[k]; 
							}
								
						*/
							
							
							if(currPiece.getPiece()[0].getRow() == i && currPiece.getPiece()[0].getColumn() == j){
								currPiece.getPiece()[0].setRow(currPiece.getPiece()[0].getRow()+1);
				
								map.getSuppMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn()] = currPiece.getPiece()[0]; 
							}
							else if(currPiece.getPiece()[1].getRow() == i && currPiece.getPiece()[1].getColumn() == j){
								currPiece.getPiece()[1].setRow(currPiece.getPiece()[1].getRow()+1);
					
								map.getSuppMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn()] = currPiece.getPiece()[1];
							}
							
							else if(currPiece.getPiece()[2].getRow() == i && currPiece.getPiece()[2].getColumn() == j){
								currPiece.getPiece()[2].setRow(currPiece.getPiece()[2].getRow()+1);
					
								map.getSuppMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn()] = currPiece.getPiece()[2];
							}

							else if(currPiece.getPiece()[3].getRow() == i && currPiece.getPiece()[3].getColumn() == j){
								currPiece.getPiece()[3].setRow(currPiece.getPiece()[3].getRow()+1);
						
								map.getSuppMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn()] = currPiece.getPiece()[3];
							}
							
								
				//			currPiece.getPiece()[z].setRow(currPiece.getPiece()[z].getRow()+1);
					//		System.out.println(currPiece.getPiece()[z].getRow());
						//	map.getSuppMatrix()[currPiece.getPiece()[z].getRow()][currPiece.getPiece()[z].getColumn()].setValue(currPiece.getPiece()[z].getValue()); 
						
						

							//currPiece = createPiece();
						}
									
					else {
						System.out.println("a");
						currPiece.setMoving(false);
						for(int k=0; k<4; k++) {
							currPiece.getPiece()[k].setValue(currPiece.getPiece()[k].getValue()*-1);
						
							System.out.println(currPiece.getPiece()[k].getRow());
							System.out.println(currPiece.getPiece()[k].getColumn());
						}


						//System.out.println(currPiece.getPiece()[0].getRow());
					
				
					}
		
				}
				
				}
				
			
			}
			Copy(map.getMatrix(), map.getSuppMatrix());		
			clearSuppMatrix(currPiece);
			
			map.update();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


	

}
	}
	
	
	
	private void clearSuppMatrix(Piece currPiece) {

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
				
			if(map.getMatrix()[currPiece.getPiece()[i].getRow()+1][currPiece.getPiece()[i].getColumn()].getId() != map.getMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()].getId()) {
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
		int max = 8; // numero massimo
		int c = ((max-min) + 1);
		int rand = random.nextInt(c) + min;
		Piece piece = null;
		
		
		if(rand==1) {
			piece = new iBlock();
			map.matrix[((iBlock) piece).getPiece()[0].getRow()][((iBlock) piece).getPiece()[0].getColumn()] = ((iBlock) piece).getPiece()[0];
			map.matrix[((iBlock) piece).getPiece()[1].getRow()][((iBlock) piece).getPiece()[1].getColumn()] = ((iBlock) piece).getPiece()[1];
			map.matrix[((iBlock) piece).getPiece()[2].getRow()][((iBlock) piece).getPiece()[2].getColumn()] = ((iBlock) piece).getPiece()[2];
			map.matrix[((iBlock) piece).getPiece()[3].getRow()][((iBlock) piece).getPiece()[3].getColumn()] = ((iBlock) piece).getPiece()[3];
			((iBlock) piece).setMoving(true);
		}
		
		if(rand==2) {
			piece = new jBlock();
			map.matrix[((jBlock) piece).getPiece()[0].getRow()][((jBlock) piece).getPiece()[0].getColumn()] = ((jBlock) piece).getPiece()[0];
			map.matrix[((jBlock) piece).getPiece()[1].getRow()][((jBlock) piece).getPiece()[1].getColumn()] = ((jBlock) piece).getPiece()[1];
			map.matrix[((jBlock) piece).getPiece()[2].getRow()][((jBlock) piece).getPiece()[2].getColumn()] = ((jBlock) piece).getPiece()[2];
			map.matrix[((jBlock) piece).getPiece()[3].getRow()][((jBlock) piece).getPiece()[3].getColumn()] = ((jBlock) piece).getPiece()[3];
			((jBlock) piece).setMoving(true);
		}
		
		if(rand==3) {
			piece = new lBlock();
			map.matrix[((lBlock) piece).getPiece()[0].getRow()][((lBlock) piece).getPiece()[0].getColumn()] = ((lBlock) piece).getPiece()[0];
			map.matrix[((lBlock) piece).getPiece()[1].getRow()][((lBlock) piece).getPiece()[1].getColumn()] = ((lBlock) piece).getPiece()[1];
			map.matrix[((lBlock) piece).getPiece()[2].getRow()][((lBlock) piece).getPiece()[2].getColumn()] = ((lBlock) piece).getPiece()[2];
			map.matrix[((lBlock) piece).getPiece()[3].getRow()][((lBlock) piece).getPiece()[3].getColumn()] = ((lBlock) piece).getPiece()[3];
			((lBlock) piece).setMoving(true);
		}
		
		
		if(rand==4) {
			piece = new oBlock();
			map.matrix[((oBlock) piece).getPiece()[0].getRow()][((oBlock) piece).getPiece()[0].getColumn()] = ((oBlock) piece).getPiece()[0];
			map.matrix[((oBlock) piece).getPiece()[1].getRow()][((oBlock) piece).getPiece()[1].getColumn()] = ((oBlock) piece).getPiece()[1];
			map.matrix[((oBlock) piece).getPiece()[2].getRow()][((oBlock) piece).getPiece()[2].getColumn()] = ((oBlock) piece).getPiece()[2];
			map.matrix[((oBlock) piece).getPiece()[3].getRow()][((oBlock) piece).getPiece()[3].getColumn()] = ((oBlock) piece).getPiece()[3];
			((oBlock) piece).setMoving(true);
		}
		
		
		if(rand==5) {
			piece = new sBlock();
			map.matrix[((sBlock) piece).getPiece()[0].getRow()][((sBlock) piece).getPiece()[0].getColumn()] = ((sBlock) piece).getPiece()[0];
			map.matrix[((sBlock) piece).getPiece()[1].getRow()][((sBlock) piece).getPiece()[1].getColumn()] = ((sBlock) piece).getPiece()[1];
			map.matrix[((sBlock) piece).getPiece()[2].getRow()][((sBlock) piece).getPiece()[2].getColumn()] = ((sBlock) piece).getPiece()[2];
			map.matrix[((sBlock) piece).getPiece()[3].getRow()][((sBlock) piece).getPiece()[3].getColumn()] = ((sBlock) piece).getPiece()[3];
			((sBlock) piece).setMoving(true);
		}
		
		
		if(rand==6) {
			piece = new tBlock();
			map.matrix[((tBlock) piece).getPiece()[0].getRow()][((tBlock) piece).getPiece()[0].getColumn()] = ((tBlock) piece).getPiece()[0];
			map.matrix[((tBlock) piece).getPiece()[1].getRow()][((tBlock) piece).getPiece()[1].getColumn()] = ((tBlock) piece).getPiece()[1];
			map.matrix[((tBlock) piece).getPiece()[2].getRow()][((tBlock) piece).getPiece()[2].getColumn()] = ((tBlock) piece).getPiece()[2];
			map.matrix[((tBlock) piece).getPiece()[3].getRow()][((tBlock) piece).getPiece()[3].getColumn()] = ((tBlock) piece).getPiece()[3];
			((tBlock) piece).setMoving(true);
		}
		
		if(rand==7) {
			piece = new zBlock();
			map.matrix[((zBlock) piece).getPiece()[0].getRow()][((zBlock) piece).getPiece()[0].getColumn()] = ((zBlock) piece).getPiece()[0];
			map.matrix[((zBlock) piece).getPiece()[1].getRow()][((zBlock) piece).getPiece()[1].getColumn()] = ((zBlock) piece).getPiece()[1];
			map.matrix[((zBlock) piece).getPiece()[2].getRow()][((zBlock) piece).getPiece()[2].getColumn()] = ((zBlock) piece).getPiece()[2];
			map.matrix[((zBlock) piece).getPiece()[3].getRow()][((zBlock) piece).getPiece()[3].getColumn()] = ((zBlock) piece).getPiece()[3];
			((zBlock) piece).setMoving(true);
		}
		piece.setId(id);
		id++;
		return piece;
		
		
	}
	
	
	
	
}
