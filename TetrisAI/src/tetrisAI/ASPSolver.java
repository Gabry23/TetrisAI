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
	
	System.out.println(piece.getPiece()[0].getRow());
	
	try {
		variableFacts.addObjectInput(piece);
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


