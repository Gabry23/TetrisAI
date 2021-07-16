package tetrisAI.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import tetrisAI.View.GamePanel;

public class MainClass implements Runnable{

	public MainClass() {}
	

	
	private static String encodingResource="encodings/tetris";
	
	private static Handler handler;
	
	private static GamePanel g;
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		
		g = new GamePanel();
		
		f.add(g, BorderLayout.CENTER);
		f.setVisible(true);	
		
		f.setTitle("TETRIS AI...SPETTACOLO............");
		f.setSize(1000, 650);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void run() {
		while(true)
			g.repaint();
	}
	

}
