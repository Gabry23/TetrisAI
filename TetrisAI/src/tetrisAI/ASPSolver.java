package tetrisAI;

import tetrisAI.InserisciBlocks.*;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ASPSolver {
	
	private static ASPSolver asp = null;
	private static String encodingResource="encodings/tetris";
    private static Handler handler;
    private InputProgram currMatrix;
    private static InputProgram variablecurrMatrix;
    private static Map map;
	private static inserisciPezzo position;
	private static int movement = 0;
    
    
private ASPSolver() {
	
	
	if(System.getProperty("os.name").equals("Mac OS X")) {
        handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2-mac"));
        //handler.addOption(new OptionDescriptor("-n 0"));
        System.out.println("Sistema operativo Mac OS X");
    }
    else if(System.getProperty("os.name").equals("Windows 10")) {
        handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
        //handler.addOption(new OptionDescriptor("-n 0"));
        System.out.println("Sistema operativo Windows 10");
    }
    else {
        System.out.println("Errore, sistema operativo non riconosciuto con IDLV");
    }
            
            
    //classe Edge che viene prima registrata all'ASPMapper
    try {
        ASPMapper.getInstance().registerClass(Cell.class);
        ASPMapper.getInstance().registerClass(Piece.class);
        ASPMapper.getInstance().registerClass(iBlock.class);
        ASPMapper.getInstance().registerClass(iBlockBean.class);
        ASPMapper.getInstance().registerClass(jBlockBean.class);
        ASPMapper.getInstance().registerClass(lBlockBean.class);
        ASPMapper.getInstance().registerClass(oBlockBean.class);
        ASPMapper.getInstance().registerClass(sBlockBean.class);
        ASPMapper.getInstance().registerClass(tBlockBean.class);
        ASPMapper.getInstance().registerClass(zBlockBean.class);
        ASPMapper.getInstance().registerClass(inserisciIBlock.class);
        ASPMapper.getInstance().registerClass(inserisciJBlock.class);
        ASPMapper.getInstance().registerClass(inserisciLBlock.class);
        ASPMapper.getInstance().registerClass(inserisciOBlock.class);
        ASPMapper.getInstance().registerClass(inserisciSBlock.class);
        ASPMapper.getInstance().registerClass(inserisciTBlock.class);
        ASPMapper.getInstance().registerClass(inserisciZBlock.class);
        ASPMapper.getInstance().registerClass(movePiece.class);

      //  ASPMapper.getInstance().registerClass(Assegno.class);
    } catch (ObjectNotValidException | IllegalAnnotationException e1) {
        e1.printStackTrace();
    }
    
    currMatrix= new ASPInputProgram();
    variablecurrMatrix = new ASPInputProgram();
    
    for(int i=0; i<20; i++) {
    	for(int j=0; j<10; j++) {
    try {
		currMatrix.addObjectInput(new Cell(i, j, 0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    }
    handler.addProgram(currMatrix);
    System.out.println(currMatrix.getPrograms());
    
    
    
    InputProgram encoding= new ASPInputProgram();
    encoding.addFilesPath(encodingResource);
    handler.addProgram(encoding);
    
}


public void addPiece(Piece currPiece, Map map) {
	variablecurrMatrix.clearAll();
	int X1 = currPiece.getPiece()[0].getRow();
    int X2 = currPiece.getPiece()[1].getRow();
    int X3 = currPiece.getPiece()[2].getRow();
    int X4 = currPiece.getPiece()[3].getRow();
    int Y1 = currPiece.getPiece()[0].getColumn();
    int Y2 = currPiece.getPiece()[1].getColumn();
    int Y3 = currPiece.getPiece()[2].getColumn();
    int Y4 = currPiece.getPiece()[3].getColumn();

	 if(currPiece instanceof iBlock) {
	    	int v = ((iBlock) currPiece).getValue();
			iBlockBean ibb = new iBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);
			try {
				variablecurrMatrix.addObjectInput(ibb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	 
	    
	    else if(currPiece instanceof jBlock) {
	    	int v = ((jBlock) currPiece).getValue();
			jBlockBean jbb = new jBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(jbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    else if(currPiece instanceof lBlock) {
	    	int v = ((lBlock) currPiece).getValue();
			lBlockBean lbb = new lBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(lbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof oBlock) {
	    	int v = ((oBlock) currPiece).getValue();
			oBlockBean obb = new oBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(obb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof sBlock) {
	    	int v = ((sBlock) currPiece).getValue();
			sBlockBean sbb = new sBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(sbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof tBlock) {
	    	int v = ((tBlock) currPiece).getValue();
			tBlockBean tbb = new tBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(tbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof zBlock) {
	    	int v = ((zBlock) currPiece).getValue();
			zBlockBean zbb = new zBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,0);

			try {
				variablecurrMatrix.addObjectInput(zbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	
	


	   handler.addProgram(variablecurrMatrix);
       updateMovement(currPiece,map);

	
	
	
    

}

public static void updateMovement(Piece currPiece,Map map) {

	Output output = handler.startSync();

	AnswerSets answers = (AnswerSets) output;

	for(AnswerSet a: answers.getOptimalAnswerSets()){
		System.out.println(a);
		try {
		for(Object obj: a.getAtoms()){
			movement = 0;
			for(Object obj2: a.getAtoms()){
			if(obj2 instanceof movePiece) {
				movePiece m = (movePiece) obj2;
				movement = m.getP();
			}
			}
			if(obj instanceof inserisciIBlock) {
			position = (inserisciIBlock) obj;					
			move(currPiece,position,map,movement);
			System.out.println(((inserisciIBlock) position).getX1());
			System.out.println(((inserisciIBlock) position).getY1());
			System.out.println(((inserisciIBlock) position).getX2());
			System.out.println(((inserisciIBlock) position).getY2());
			System.out.println(((inserisciIBlock) position).getX3());
			System.out.println(((inserisciIBlock) position).getY3());
			System.out.println(((inserisciIBlock) position).getX4());
			System.out.println(((inserisciIBlock) position).getY4());
			}
			
			else if(obj instanceof inserisciJBlock) {
				position = (inserisciJBlock) obj;					
				move(currPiece,position,map,movement);
				}
			
			else if(obj instanceof inserisciLBlock) {
				 position = (inserisciLBlock) obj;					
				move(currPiece,position,map,movement);
				}
			
			else if(obj instanceof inserisciOBlock) {
				 position = (inserisciOBlock) obj;					
				move(currPiece,position,map,movement);
				}
			
			else if(obj instanceof inserisciSBlock) {
				 position = (inserisciSBlock) obj;					
				move(currPiece,position,map,movement);
				}
			
			else if(obj instanceof inserisciTBlock) {
				 position = (inserisciTBlock) obj;					
				move(currPiece,position,map,movement);
				}
			
			else if(obj instanceof inserisciZBlock) {
				position = (inserisciZBlock) obj;					
				move(currPiece,position,map,movement);			
				}
			
			else {
				continue;
			}
			
		
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
		}
		
}


/*public static void getAnswerSet() {

	   handler.addProgram(variablecurrMatrix);

 
	
	Output output = handler.startSync();
	AnswerSets answers = (AnswerSets) output;
	

	for(AnswerSet a: answers.getOptimalAnswerSets()){
		try {
		for(Object obj: a.getAtoms()){

			if(!(obj instanceof inserisciiBlock)) continue;
			//Convertiamo in un oggetto della classe Cell e impostiamo il valore di ogni cella 
			//nella matrice rappresentante la griglia del Sudoku
			inserisciiBlock position = (inserisciiBlock) obj;					
			move(currPiece,position);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
		}
}
*/

public static void move(Piece currPiece, inserisciPezzo position, Map map, int movement) {
	

	
	if(!Game.checkScrollCondition(map, currPiece)){
		if(movement == 2 && currPiece.canMoveRight(map)) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(),currPiece.getPiece()[i].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
			}
		}
		if(movement == 1 && currPiece.canMoveLeft(map)) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(),currPiece.getPiece()[i].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
			}
		}
		//fitPieces(map,currPiece);
}
	
	if(position instanceof inserisciIBlock) {
	if(currPiece.isMoving) {
			
			if(currPiece.getPiece()[0].getRow()>1) {
			if(currPiece.getState()[((inserisciIBlock) position).getV()] == false) {
				currPiece.Rotate(map);
				System.out.println("L'HO GIRATO!");
				currPiece.setState(true, ((inserisciIBlock) position).getV());
			}
			}
		
	if(currPiece.canMoveLeft(map) && (((inserisciIBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciIBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}

	else {
		return;
	}
	}
	
	
	
	if(position instanceof inserisciJBlock) {
	if(currPiece.isMoving) {
		if(currPiece.getPiece()[0].getRow()>1) {
			while(currPiece.getState()[((inserisciJBlock) position).getV()] == false) {
				currPiece.Rotate(map);
	
			}
			currPiece.setState(true, ((inserisciJBlock) position).getV());

			}
	if(currPiece.canMoveLeft(map) && (((inserisciJBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciJBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}
	
	if(!Game.checkScrollCondition(map, currPiece)){
		
		//fitPieces(map,currPiece);
}
	else {
		return;
	}
	}
	
	
	
	if(position instanceof inserisciLBlock) {
	if(currPiece.isMoving) {
		if(currPiece.getPiece()[0].getRow()>1) {
			while(currPiece.getState()[((inserisciLBlock) position).getV()] == false) {
				currPiece.Rotate(map);
	
			}
			currPiece.setState(true, ((inserisciLBlock) position).getV());

			}
	if(currPiece.canMoveLeft(map) && (((inserisciLBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciLBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}
	
	if(!Game.checkScrollCondition(map, currPiece)){
		
	//	fitPieces(map,currPiece);
	}
	else {
		return;
	}
	}
	
	
	if(position instanceof inserisciOBlock) {
	if(currPiece.isMoving) {
	if(currPiece.canMoveLeft(map) && (((inserisciOBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciOBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}

	
	else {
		return;
	}
	}
	
	
	if(position instanceof inserisciSBlock) {
	
	if(currPiece.isMoving) {
		if(currPiece.getPiece()[0].getRow()>1) {
			while(currPiece.getState()[((inserisciSBlock) position).getV()] == false) {
				currPiece.Rotate(map);
	
			}
			currPiece.setState(true, ((inserisciSBlock) position).getV());

			}

		if(currPiece.canMoveLeft(map) && (((inserisciSBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciSBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}
	
	if(!Game.checkScrollCondition(map, currPiece)){
	
	//		fitPieces(map,currPiece);
	}
	
	else {
		return;
	}
	}
	
	
	if(position instanceof inserisciTBlock) {
	if(currPiece.isMoving) {
		if(currPiece.getPiece()[0].getRow()>1) {
			while(currPiece.getState()[((inserisciTBlock) position).getV()] == false) {
				currPiece.Rotate(map);
	
			}
			currPiece.setState(true, ((inserisciTBlock) position).getV());

			}
	if(currPiece.canMoveLeft(map) && (((inserisciTBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciTBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	else {
		Game.getLoop().setSleepTime(200);

	}
	}
	
	if(Game.checkScrollCondition(map, currPiece)){
		
	//	fitPieces(map,currPiece);
}
	
	else {
		return;
	}
	}
	
	
	
	
	if(position instanceof inserisciZBlock) {
	if(currPiece.isMoving) {
		if(currPiece.getPiece()[0].getRow()>1) {
			while(currPiece.getState()[((inserisciZBlock) position).getV()] == false) {
				currPiece.Rotate(map);
	
			}
			currPiece.setState(true, ((inserisciZBlock) position).getV());

			}
	if(currPiece.canMoveLeft(map) && (((inserisciZBlock) position).getY1()<currPiece.getPiece()[0].getColumn())) {
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
		}
		}
	
	else if(currPiece.canMoveRight(map) && (((inserisciZBlock) position).getY1() > currPiece.getPiece()[0].getColumn())) {
		
		for(int i=0; i<4; i++) {
			currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
		}
		}
	

	else {
		Game.getLoop().setSleepTime(200);

	}
	}
	
	if(!Game.checkScrollCondition(map, currPiece)){
		
	//	fitPieces(map,currPiece);
}
	
	else {
		return;
	}
	}
	
	
}



public static ASPSolver getInstance() {
	if(asp == null) {
		asp = new ASPSolver();
	}
	return asp;
}
/*public Cell getNextMove() {
	Output o = handler.startSync();
	AnswerSets answersets = (AnswerSets) o;
	
	for(Object obj:)
	return null;
	
	
	
}*/


public void updateAspCells(Map map) {
	 currMatrix.clearAll();

	for(int i=0; i<20; i++) {
		for(int j=0; j<10; j++) {
		 int value = map.getMatrix()[i][j].getValue();
		 try {
			currMatrix.addObjectInput(new Cell(i,j,value));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		   
	}
	
	
}

public static void fitPieces(Map map, Piece currPiece) {
	
	if(currPiece.canMoveRight(map)) {
	
		//MOVIMENTO A DESTRA
		if((map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn()+1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[0].getRow()+1][currPiece.getPiece()[0].getColumn()+1].getValue() != 0) 
				) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
			}
		}
		
		else if((map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn()+1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[1].getRow()+1][currPiece.getPiece()[1].getColumn()+1].getValue() != 0)
				) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
			
			
				}
				
			}
				
	 else if((map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn()+1].getValue() == 0)
				&& (map.getMatrix()[currPiece.getPiece()[2].getRow()+1][currPiece.getPiece()[2].getColumn()+1].getValue() != 0) 
				) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
			}
		}
		
	 else if((map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn()+1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[3].getRow()+1][currPiece.getPiece()[3].getColumn()+1].getValue() != 0)
				) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()+1);
			}
		}
		}
		
		//MOVIMENTO A SINISTRA
	if(currPiece.canMoveLeft(map)) {
	  if((map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn()-1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[0].getRow()+1][currPiece.getPiece()[0].getColumn()-1].getValue() != 0) 
			) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
			}
		}
		
	  else if((map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn()-1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[1].getRow()+1][currPiece.getPiece()[1].getColumn()-1].getValue() != 0) 
		) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
			
			
				}
				
			}
				
	  else  if((map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn()-1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[2].getRow()+1][currPiece.getPiece()[2].getColumn()-1].getValue() != 0) 
				) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
			}
		}
		
	  else if((map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn()-1].getValue() == 0) 
				&& (map.getMatrix()[currPiece.getPiece()[3].getRow()+1][currPiece.getPiece()[3].getColumn()-1].getValue() != 0)
			) {
			for(int i=0; i<4; i++) {
				map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(),currPiece.getPiece()[1].getColumn(),0);
				currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn()-1);
			}
		}
	}
}


public void updateMovement2(Piece currPiece, Map map) {
	if(position != null)
	move(currPiece,position,map,movement);	
	
	
}





}



