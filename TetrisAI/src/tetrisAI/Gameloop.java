package tetrisAI;

import java.util.ArrayList;
import java.util.List;

public class Gameloop implements Runnable{
	
	private Game game;
	
	private Map map;
	
	private Piece currPiece;
	
	private List<Piece> pieces;
	
	private Thread t;
	
	private int fps;
	
	private ASPSolver asp;
	
	private MyCallback mcb;
	
	public Gameloop(Game game,Map map) {
		this.game = game; 
		
		this.map = map;
		
		
		
		pieces = new ArrayList<Piece>();
		
		pieces.add(game.createPiece());
		ASPSolver.getAnswerset();
		currPiece = pieces.get(pieces.size()-1);
		
		
	//	asp.addPiece(currPiece);
		
		fps=400;
		
		t=new Thread(this);
		t.start();
	}
	
	public Piece getCurrPiece() {
		return currPiece;
	}
	
	@Override
	public void run() {
		
		boolean updatable;
		
		
		map.addPiece(currPiece);
		map.getController().updatePiece(currPiece);
		
		while(true) {
			
			if(!currPiece.isMoving()) {
				game.checkDeleteCondition();
				pieces.add(game.createPiece());
				currPiece = pieces.get(pieces.size()-1);
				map.getController().updatePiece(currPiece);
			}
				
			updatable=true;
				
			
				for(int i=0; i<map.getMatrix().length; i++) {
			
					
					for(int j=0; j<map.getMatrix()[i].length; j++) {
						
						if(map.getMatrix()[i][j].getValue()>0) {
						

							if( game.checkScrollCondition(map, currPiece)) {
													
								if(updatable) {	
									for(int k=0; k<4; k++) {
										currPiece.getPiece()[k].setRow(currPiece.getPiece()[k].getRow()+1);
										map.getSuppMatrix()[currPiece.getPiece()[k].getRow()][currPiece.getPiece()[k].getColumn()] = currPiece.getPiece()[k];
										
									}
						
								updatable=false;
							
								}
									
							}
							else if(!game.checkScrollCondition(map, currPiece) && currPiece.getPiece()[0].getRow()<1){	
								t.interrupt();
								return;
							}
										
							else{
								game.sleepTime(400);
								
								if((game.checkScrollCondition(map, currPiece)))
									continue;
								
								currPiece.setMoving(false);
								
								for(int k=0; k<4; k++) {
									currPiece.getPiece()[k].setValue(currPiece.getPiece()[k].getValue()*-1);	
								}
								
								ASPSolver.getInstance().updateAspCells(map);
				
								
								
							}
			
						}
					
					}
					
				
				}
				
				 ASPSolver.getInstance().addPiece(currPiece);

		
				game.sleepTime(fps);	
				
		}
	}


	public void setSleepTime(int i) {
		fps = i;
	}

}
