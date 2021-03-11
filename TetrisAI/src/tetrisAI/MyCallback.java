package tetrisAI;
import javax.swing.JFrame;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class MyCallback implements Callback {

	private int[][] sudokuMatrix;
	private int N = 9;

	public MyCallback(int[][] sm) {
		this.sudokuMatrix = sm;
	}

	@Override
	public void callback(Output o) {
		//Analizziamo l'answer set che in quest caso è unico e che rappresenta la soluzione
		//del Sudoku e aggiorniamo la matrice
		AnswerSets answers = (AnswerSets) o;
		for(AnswerSet a:answers.getAnswersets()){
			try {
				for(Object obj: a.getAtoms()){
					//Scartiamo tutto ciò che non è un oggetto della classe Cell
					if(!(obj instanceof Cell)) continue;
					//Convertiamo in un oggetto della classe Cell e impostiamo il valore di ogni cella 
					//nella matrice rappresentante la griglia del Sudoku
					Cell cell = (Cell) obj;					
					sudokuMatrix[cell.getRow()][cell.getColumn()] = cell.getValue();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		//Visualizziamo la griglia così ottenuta
		displayMatrix();
	}

	private void displayMatrix() {
		JFrame f = new JFrame();
		f.setTitle("TETRIS AI...SPETTACOLO............");
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
