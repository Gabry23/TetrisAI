package tetrisAI.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScorePanel extends JPanel{
	
	private static ScorePanel s;
	
	private Integer scoreAI;
	
	private Integer scorePlayer;
	
	private ScorePanel() {
		
		scoreAI = 0;
		scorePlayer = 0;
		
		this.setPreferredSize(new Dimension(200,200));
		this.setBackground(Color.BLACK);
	}
	
	public static ScorePanel getInstance() {
		if(s == null)
			s =new ScorePanel();
		return s;
	}
	
	public void setScoreAI(int points) {
		scoreAI = points;
	}
	
	public void setScorePlayer(int points) {
		scorePlayer = points;
	}
	
	public int getScoreAI() {
		return scoreAI;
	}
	
	public int getScorePlayer() {
		return scorePlayer;
	}
	
	public synchronized void paintComponent(Graphics g) {
		
		super.paintComponent(g);
        
		g.setColor(Color.LIGHT_GRAY);
      
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));  
        g.drawString("SCORE AI:",15,20);
        
        String AI = scoreAI.toString();
        g.setFont(new Font("Arial", Font.PLAIN, 40)); 
        g.drawString(AI,100,70);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));  
        g.drawString("SCORE PLAYER:",15,120);
        
        String player = scorePlayer.toString();
        g.setFont(new Font("Arial", Font.PLAIN, 40)); 
        g.drawString(player,100,170);

	}

}
