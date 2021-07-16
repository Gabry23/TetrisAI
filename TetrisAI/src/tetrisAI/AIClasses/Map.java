package tetrisAI.AIClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import tetrisAI.AIBlocks.iBlock;
import tetrisAI.AIBlocks.jBlock;
import tetrisAI.AIBlocks.lBlock;
import tetrisAI.AIBlocks.oBlock;
import tetrisAI.AIBlocks.sBlock;
import tetrisAI.AIBlocks.tBlock;
import tetrisAI.AIBlocks.zBlock;

@Id("map")
public class Map extends JPanel {
	
	
	
	@Param(0) 
	private Cell[][] matrix;
	
	@Param(1)
	private iBlock ib;
	
	@Param(2)
	private jBlock jb;
	
	@Param(3)
	private lBlock lb;
	
	@Param(4)
	private oBlock ob;
	
	@Param(5)
	private sBlock sb;
	
	@Param(6)
	private tBlock tb;
	
	@Param(7)
	private zBlock zb;
	
	@Param(8)
	private EmptyBlock eb;
	
	@Param(9)
	private Cell[][] suppMatrix;
	
	private Image ibl;
	
	private Image jbl;
	
	private Image lbl;
	
	private Image obl;
	
	private Image sbl;
	
	private Image tbl;
	
	private Image zbl;
	
	
	
	private Piece currPiece;
	
	private Integer score = 0;
	
	public Map(Game game) {
	
		
		
		
		matrix = new Cell [20][10];
		suppMatrix = new Cell [20][10];
		
		
		ib = new iBlock();
		ibl = ib.getImage();
		
		jb = new jBlock();
		jbl = jb.getImage();
		
		lb = new lBlock();
		lbl = lb.getImage();
		
		ob = new oBlock();
		obl = ob.getImage();
		
		sb = new sBlock();
		sbl = sb.getImage();
		
		tb = new tBlock();
		tbl = tb.getImage();
		
		zb = new zBlock();
		zbl = zb.getImage();
		
		for(int i=0; i<matrix.length; i++) {
				
			for(int j=0; j<matrix[i].length; j++) {
				
				matrix[i][j] = new EmptyBlock(i,j,0);
				suppMatrix[i][j] = new EmptyBlock(i,j,0);
			}
			
		}
	
		this.repaint();
		
	}
	

public synchronized void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		//g.drawImage(wallpaper, 0 , 0, null);
		
		for(int i=0; i<matrix.length; i++) {
			
			for(int j=0; j<matrix[i].length; j++) {
				
				
				if(matrix[i][j].getValue() == 0) {
				    int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    g.setColor(Color.BLACK);
                    g.fillRect(x,y,30,30);
				}
				
				
				else if(matrix[i][j].getValue() == 1 || matrix[i][j].getValue() == -1 ) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                   
                    g.drawImage(ibl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 2 || matrix[i][j].getValue() == -2 ) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    
                    g.drawImage(jbl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 3 || matrix[i][j].getValue() == -3 ) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                  
                    g.drawImage(lbl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 4 || matrix[i][j].getValue() == -4) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    
                    g.drawImage(obl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 5|| matrix[i][j].getValue() == -5) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    
                    g.drawImage(sbl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 6 || matrix[i][j].getValue() == -6) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    
                    g.drawImage(tbl, x, y, 30, 30, null);	
				}
				
				else if(matrix[i][j].getValue() == 7 || matrix[i][j].getValue() == -7) {
					int x = 0 + j * 30;
                    int y = 0 + i * 30;
                    
                    g.drawImage(zbl, x, y, 30, 30, null);	
				}
			}
			
		}
		
		g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, 0, 300, 0);
        g.drawLine(0, 600, 300, 600);
        g.drawLine(300, 0, 300, 600);
        g.drawLine(0, 0, 0, 600);
 
		
	}
	

	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public synchronized  Cell[][] getMatrix(){
		return matrix;
	}
	

	public synchronized  Cell[][] getSuppMatrix(){
		return suppMatrix;
	}

	public synchronized void update (){
		repaint();
	}
	
	public synchronized void addPiece(Piece piece) {
		this.currPiece=piece;
	}
	
}
