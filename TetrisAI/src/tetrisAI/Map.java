package tetrisAI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("map")
public class Map extends JPanel {
	
	@Param(0)
	static Cell[][] matrix;
	
	@Param(1)
	private static iBlock ib;
	
	@Param(2)
	private static jBlock jb;
	
	@Param(3)
	private static lBlock lb;
	
	@Param(4)
	private static oBlock ob;
	
	@Param(5)
	private static sBlock sb;
	
	@Param(6)
	private static tBlock tb;
	
	@Param(7)
	private static zBlock zb;
	
	@Param(8)
	private static EmptyBlock eb;
	

	
	public Map() {
	
		matrix = new Cell [20][10];
		
		for(int i=0; i<matrix.length; i++) {
				
			for(int j=0; j<matrix[i].length; j++) {
				
				matrix[i][j] = new EmptyBlock(i,j,0);
				
				
			}
			
		}
		
		this.repaint();
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	
		
		
		for(int i=0; i<matrix.length; i++) {
			
			for(int j=0; j<matrix[i].length; j++) {
				
				
				if(matrix[i][j].getValue() == 0) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(eb.getImage(), x, y, 30, 30, null);
				}
				
				
				if(matrix[i][j].getValue() == 1) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(ib.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 2) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(jb.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 3) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(lb.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 4) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(ob.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 5) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(sb.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 6) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(tb.getImage(), x, y, 30, 30, null);	
				}
				
				if(matrix[i][j].getValue() == 7) {
				    int x = 20 + j * 30;
                    int y = 20 + i * 30;
                    g.drawImage(zb.getImage(), x, y, 30, 30, null);	
				}
				
				
				
				
				
				
				
			}
			
		}
		
		g.setColor(Color.BLACK);
		g.drawLine(20, 20, 320, 20);
		g.drawLine(20, 620, 320, 620);
		g.drawLine(320, 20, 320, 620);
		g.drawLine(20, 20, 20, 620);
		
	}
	
	
	

	public  Cell[][] getMatrix(){
		return matrix;
	}
	
	

	public void update (){
		repaint();
	}
	
}
