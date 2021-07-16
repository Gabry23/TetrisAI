package tetrisAI.PlayerClasses;

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
import tetrisAI.PlayerBlocks.iBlockPlayer;
import tetrisAI.PlayerBlocks.jBlockPlayer;
import tetrisAI.PlayerBlocks.lBlockPlayer;
import tetrisAI.PlayerBlocks.oBlockPlayer;
import tetrisAI.PlayerBlocks.sBlockPlayer;
import tetrisAI.PlayerBlocks.tBlockPlayer;
import tetrisAI.PlayerBlocks.zBlockPlayer;


public class MapPlayer extends JPanel {
	
	private CellPlayer[][] matrix;

	private iBlockPlayer ib;

	private jBlockPlayer jb;

	private lBlockPlayer lb;

	private oBlockPlayer ob;

	private sBlockPlayer sb;

	private tBlockPlayer tb;

	private zBlockPlayer zb;

	private EmptyBlockPlayer eb;

	private CellPlayer[][] suppMatrix;
	
	private Image ibl;
	
	private Image jbl;
	
	private Image lbl;
	
	private Image obl;
	
	private Image sbl;
	
	private Image tbl;
	
	private Image zbl;
	
	private PiecePlayer currPiece;
	
	private PieceController pc;
	
	private Integer score = 0;
	
	public MapPlayer(GamePlayer game) {

		matrix = new CellPlayer [20][10];
		suppMatrix = new CellPlayer [20][10];
		
		
		ib = new iBlockPlayer();
		ibl = ib.getImage();
		
		jb = new jBlockPlayer();
		jbl = jb.getImage();
		
		lb = new lBlockPlayer();
		lbl = lb.getImage();
		
		ob = new oBlockPlayer();
		obl = ob.getImage();
		
		sb = new sBlockPlayer();
		sbl = sb.getImage();
		
		tb = new tBlockPlayer();
		tbl = tb.getImage();
		
		zb = new zBlockPlayer();
		zbl = zb.getImage();
		
		pc = new PieceController(this,game);
		this.addKeyListener(pc);
		
		for(int i=0; i<matrix.length; i++) {
				
			for(int j=0; j<matrix[i].length; j++) {
				
				matrix[i][j] = new EmptyBlockPlayer(i,j,0);
				suppMatrix[i][j] = new EmptyBlockPlayer(i,j,0);
			}
			
		}
		
		this.setFocusable(true);
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
        
		//g.setColor(Color.BLACK);
        //g.drawRect(500, 100, 250, 150);
        //g.fillRect(500, 100, 250, 150);
        
		//g.setColor(Color.LIGHT_GRAY);
        //g.drawLine(500, 100, 500, 250);
        //g.drawLine(500, 100, 750, 100);
        //g.drawLine(750, 100, 750, 250);
        //g.drawLine(750, 250, 500, 250);
        
        //g.setFont(new Font("Arial", Font.PLAIN, 40));  
        //g.drawString("SCORE:",550,150);
        
        //String stringa = score.toString();
        //g.drawString(stringa,610,200);



		
	}
	

	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public synchronized  CellPlayer[][] getMatrix(){
		return matrix;
	}
	

	public synchronized  CellPlayer[][] getSuppMatrix(){
		return suppMatrix;
	}

	public synchronized void update (){
		repaint();
	}
	
	public void addPiece(PiecePlayer piecePlayer) {
		this.currPiece=piecePlayer;
		pc.updatePiece(currPiece);
	}
	
	public PieceController getController() {
		return pc;
	}
	
}
