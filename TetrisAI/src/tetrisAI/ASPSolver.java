package tetrisAI;

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
    private InputProgram variablecurrMatrix;

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
        ASPMapper.getInstance().registerClass(iBlockBean.class);
        ASPMapper.getInstance().registerClass(jBlockBean.class);
        ASPMapper.getInstance().registerClass(lBlockBean.class);
        ASPMapper.getInstance().registerClass(oBlockBean.class);
        ASPMapper.getInstance().registerClass(sBlockBean.class);
        ASPMapper.getInstance().registerClass(zBlockBean.class);
        ASPMapper.getInstance().registerClass(tBlockBean.class);
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


public void addPiece(Piece currPiece) {
	
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
			iBlockBean ibb = new iBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);
			try {
				variablecurrMatrix.addObjectInput(ibb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	 
	    
	    else if(currPiece instanceof jBlock) {
	    	int v = ((jBlock) currPiece).getValue();
			jBlockBean jbb = new jBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(jbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    else if(currPiece instanceof lBlock) {
	    	int v = ((lBlock) currPiece).getValue();
			lBlockBean lbb = new lBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(lbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof oBlock) {
	    	int v = ((oBlock) currPiece).getValue();
			oBlockBean obb = new oBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(obb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof sBlock) {
	    	int v = ((sBlock) currPiece).getValue();
			sBlockBean sbb = new sBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(sbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof tBlock) {
	    	int v = ((tBlock) currPiece).getValue();
			tBlockBean tbb = new tBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(tbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
	    
	    else if(currPiece instanceof zBlock) {
	    	int v = ((zBlock) currPiece).getValue();
			zBlockBean zbb = new zBlockBean(X1,X2,X3,X4,Y1,Y2,Y3,Y4,v);

			try {
				variablecurrMatrix.addObjectInput(zbb);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	
	


	   handler.addProgram(variablecurrMatrix);
    System.out.println(variablecurrMatrix.getPrograms());
    handler.removeProgram(variablecurrMatrix);
    variablecurrMatrix.clearAll();
    variablecurrMatrix.clearPrograms();

    

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
	
	handler.addProgram(currMatrix);
	
	Output output = handler.startSync();
	AnswerSets answers = (AnswerSets) output;
	
	for(AnswerSet a: answers.getAnswersets()){
		System.out.println(a.toString());
		}
	//System.out.println(answers.getOutput());
	
	
	for(AnswerSet a:answers.getAnswersets()){

		/*try {
			for(Object obj: a.getAtoms()){
				//Scartiamo tutto ci� che non � un oggetto della classe Cell
				//if(!(obj instanceof Cell)) continue;
				//Convertiamo in un oggetto della classe Cell e impostiamo il valore di ogni cella 
				//nella matrice rappresentante la griglia del Sudoku
				//Cell cell = (Cell) obj;					
				System.out.println(obj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
	//   System.out.println(currMatrix.getPrograms());
}


}


