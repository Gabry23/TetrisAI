package tetrisAI.View;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tetrisAI.AIClasses.Game;
import tetrisAI.Game.Gameloop;
import tetrisAI.PlayerClasses.GamePlayer;

public class GamePanel extends JPanel{
	
	private Image wallpaper;
	
	public GamePanel(){
		
		
		try {
			wallpaper = ImageIO.read(this.getClass().getResource("/resources/wallpaper.jpg"));
			Image icon = wallpaper.getScaledInstance(1000, 650, Image.SCALE_SMOOTH);
			wallpaper = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Game g = new Game();
		
		
		
		g.getMap().setPreferredSize(new Dimension(301,601));
		//GamePanel left = new GamePanel(g);
		
		GamePlayer g2 = new GamePlayer();
		
		g2.getMapPlayer().setPreferredSize(new Dimension(301,601));
		//GamePanel right = new GamePanel(g2);
		
		this.add(g.getMap());
		this.add(ScorePanel.getInstance());
		this.add(g2.getMapPlayer());
		
			
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(g2);
		
		Gameloop.getInstance(g,g2,g.getMap(),g2.getMapPlayer());
		//GameloopPlayer.getInstance(g2,g2.getMapPlayer());
		
		//Thread t3 = new Thread(GameloopPlayer.getInstance());
		
		
		t1.start();
		t2.start();
		
		//t3.start();
		
        
      
		
		
		
		
		
		//Thread gl1 = new Thread(Gameloop.getInstance());
		//Thread gl2 = new Thread(GameloopPlayer.getInstance());
		
		
		
		//gl1.start();
		//gl2.start();
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		g.drawImage(wallpaper, 0 , 0, 1000, 650, null);

	}
	
	
	
}
