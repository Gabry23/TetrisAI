package tetrisAI.InserisciBlocks;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("movePiece")
public class movePiece {
	@Param(0)
	private int P;

	public int getP() {
		return P;
	}

	public void setP(int p) {
		P = p;
	}
	
	
}
