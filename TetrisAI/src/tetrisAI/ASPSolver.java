package tetrisAI;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ASPSolver {
	private static String encodingResource="encodings/DotsAndBoxes";
    private static Handler handler;
    private InputProgram facts;
    
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
		/*try {
            ASPMapper.getInstance().registerClass(Edge.class);
            ASPMapper.getInstance().registerClass(Size.class);
            ASPMapper.getInstance().registerClass(Assegno.class);
        } catch (ObjectNotValidException | IllegalAnnotationException e1) {
            e1.printStackTrace();
        }*/
        facts= new ASPInputProgram();
        
        InputProgram encoding= new ASPInputProgram();
        encoding.addFilesPath(encodingResource);
        handler.addProgram(encoding);
	}

}
