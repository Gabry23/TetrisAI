package tetrisAI;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.Media;
import javax.swing.JFrame;

public class Game implements Runnable{

	private static Map map;
	private JFrame f;
	private static int id = 0;
	private static EmptyBlock eb;
	private Piece piece;
	private Random random;
	private PieceController pc;
	private static Gameloop gl;
	//private ASPSolver asp; 
	private Thread t;
	
	public Game() {
		startGame();
		
	}
	
	
	public void startGame() {
		f = new JFrame();
		f.setTitle("TETRIS AI...SPETTACOLO............");
		f.setSize(800, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eb = new EmptyBlock(0,0,0);
		map = new Map(this);
		gl = new Gameloop(this,map); 

		f.add(map);
		f.setVisible(true);		
//		asp = new ASPSolver();

		t=new Thread(this);
		t.start();
		
		
	}	
	
	public void checkDeleteCondition() {
		if(!gl.getCurrPiece().isMoving()) {
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
				map.setScore(map.getScore()+10);
			}
		}
		}
		
	}


	private void lowMatrix(int index) {
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


	public void clearSuppMatrix() {

		for(int i=0; i<map.matrix.length; i++) {
			for(int j=0; j<map.matrix[i].length; j++) {
			
				if(map.getSuppMatrix()[i][j].getValue()>0) {	
					eb.setRow(i);
					eb.setColumn(j);
					map.getSuppMatrix()[i][j] =  eb;
				}
			}		
		}
	}


	public void Copy(Cell[][] matrix, Cell[][] suppMatrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = suppMatrix[i][j];
			}
		}
	}


	public static boolean checkScrollCondition(Map map, Piece currPiece) {

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
	
	public void addPiece(Piece piece) {
		for(int i=0;i<4;i++)
		map.getSuppMatrix()[piece.getPiece()[i].getRow()][piece.getPiece()[i].getColumn()] = piece.getPiece()[i];
	}

	public boolean SuppMatrixIsEmpty(){
		for(int i=0; i<map.matrix.length; i++) {
			for(int j=0; j<map.matrix[i].length; j++) {
				if(map.getSuppMatrix()[i][j].getValue()!=0)
					return false;
			}
		}
	 return true;
	}


	@Override
	public void run() {
		while(true) {
			if(gl.getCurrPiece()!=null) {
				Copy(map.getMatrix(),map.getSuppMatrix());
				clearSuppMatrix();
				addPiece(gl.getCurrPiece());
			}
			map.update();
		//	ASPSolver.getInstance().addPiece(piece);
	//		asp.addPiece(piece);
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


	public static Gameloop getLoop() {
		return gl;
	}
	
}