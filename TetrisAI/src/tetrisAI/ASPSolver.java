package tetrisAI;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ASPSolver {
	
	private static String encodingResource="encodings/tetris";
    private static Handler handler;
    private InputProgram facts;
    private InputProgram variableFacts;

public ASPSolver() {
	
	if(System.getProperty("os.name").equals("Mac OS X")) {
        handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.mac_7"));
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
      //  ASPMapper.getInstance().registerClass(Assegno.class);
    } catch (ObjectNotValidException | IllegalAnnotationException e1) {
        e1.printStackTrace();
    }
    facts= new ASPInputProgram();
    
    for(int i=0; i<20; i++) {
    	for(int j=0; j<10; j++) {
    try {
		facts.addObjectInput(new Cell(i, j, 0));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    }
    handler.addProgram(facts);
    
    System.out.println(facts.getPrograms());
    
    InputProgram encoding= new ASPInputProgram();
    encoding.addFilesPath(encodingResource);
    handler.addProgram(encoding);
    
}


public void addPiece(Piece piece) {
	
	int X1 = ((iBlock) piece).getX1();
	int X2 = ((iBlock) piece).getX2();
	int X3 = ((iBlock) piece).getX3();
	int X4 = ((iBlock) piece).getX4();
	
	int Y1 = ((iBlock) piece).getY1();
	int Y2 = ((iBlock) piece).getY2();
	int Y3 = ((iBlock) piece).getY3();
	int Y4 = ((iBlock) piece).getY4();
	try {
		variableFacts.addObjectInput(new iBlock(X1,Y1,X2,Y2,X3,Y3,X4,Y4,1));
	    handler.addProgram(variableFacts);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(facts.getPrograms());
}

/*public Cell getNextMove() {
	Output o = handler.startSync();
	AnswerSets answersets = (AnswerSets) o;
	
	for(Object obj:)
	return null;
	
	
	
}*/
}


