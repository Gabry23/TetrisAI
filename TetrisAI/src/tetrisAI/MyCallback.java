package tetrisAI;
import javax.swing.JFrame;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class MyCallback implements Callback {

	private Cell[][] tetrisMatrix;


	public MyCallback(Cell[][] tetrisMatrix) {
		this.tetrisMatrix = tetrisMatrix;
	}

	@Override
	public void callback(Output o) {

		AnswerSets answers = (AnswerSets) o;
		for(AnswerSet a:answers.getAnswersets()){
			try {
				for(Object obj: a.getAtoms()){
					//Scartiamo tutto ciò che non è un oggetto della classe Cell
					//if(!(obj instanceof Cell)) continue;
					//Convertiamo in un oggetto della classe Cell e impostiamo il valore di ogni cella 
					//nella matrice rappresentante la griglia del Sudoku
					//Cell cell = (Cell) obj;					
					System.out.println(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		//Visualizziamo la griglia così ottenuta
	//	displayMatrix();
	}


}
