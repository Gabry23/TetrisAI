package tetrisAI.Game;

import java.util.ArrayList;

import java.util.List;

import tetrisAI.AIClasses.ASPSolver;
import tetrisAI.AIClasses.Game;
import tetrisAI.AIClasses.Map;
import tetrisAI.AIClasses.Piece;
import tetrisAI.PlayerClasses.GamePlayer;
import tetrisAI.PlayerClasses.MapPlayer;
import tetrisAI.PlayerClasses.PiecePlayer;

public class Gameloop {
	
	private static Gameloop gl;
	
	private Game game;
	
	private Map map;
	
	private Piece currPiece;
	
	private GamePlayer player;
	
	private MapPlayer map2;
	
	private List<Piece> pieces;
	
	private PiecePlayer currPiecePlayer;
	
	
	private List<PiecePlayer> piecesPlayer;
	
	
	private Thread t;
	
	private Thread t1;
	
	private int fps;
	
	private int playerfps;
	
	private boolean gameoverai;
	
	private boolean gameoverplayer;

	private Gameloop(Game game,GamePlayer player,Map map,MapPlayer map2) {
		this.game = game;
		
		this.player = player;
		
		this.map = map;
		
		this.map2 = map2;
		
		pieces = new ArrayList<Piece>();
		
		pieces.add(game.createPiece());

		//ASPSolver.getAnswerset();
		currPiece = pieces.get(pieces.size()-1);
		
		piecesPlayer = new ArrayList<PiecePlayer>();
		
		piecesPlayer.add(player.createPiecePlayer());

		currPiecePlayer = piecesPlayer.get(piecesPlayer.size()-1);
		
		
	//	asp.addPiece(currPiece);
		
		fps=200;
		playerfps = fps;
		
		t= new Thread(new Runnable() {

			@Override
			public void run() {
				map.addPiece(currPiece);
				
				while(!Gameoverai()) {
					
					game.gameConditions(pieces,true);
					
					ASPSolver.getInstance().updateMovement2(currPiece, map);
					ASPSolver.getInstance().updateAspCells(map);
					
					game.sleepTime(fps);
					
				}
			}
			
		});
		
		t1= new Thread(new Runnable() {

			@Override
			public void run() {
				map2.addPiece(currPiecePlayer);
				
				while(!GameoverPlayer()) {
					
					player.gameConditions(piecesPlayer,true);
					
					player.sleepTime(playerfps);
					
				}
			}
			
		});
		
		t.start();
		t1.start();
		
	}
	
	public static Gameloop getInstance(Game g,GamePlayer p,Map m, MapPlayer m2) {
		if(gl == null)
			gl = new Gameloop(g,p,m,m2);
		return gl;
	}
	
	public synchronized Piece getCurrPiece() {
		return currPiece;
	}
	
	public synchronized PiecePlayer getCurrPiecePlayer() {
		
		return currPiecePlayer;
	}


	public synchronized void setSleepTime(int i) {
		fps = i;
	}

	public static Gameloop getInstance() {
		if(gl != null)
			return gl;
		return null;
	}

	public void setGameoverPlayer(boolean b) {
		gameoverplayer = b;
	}
	
	public void setGameoverai(boolean b) {
		gameoverai = b;
	}
	
	public boolean GameoverPlayer() {
		return gameoverplayer;
	}
	
	public boolean Gameoverai() {
		return gameoverai;
	}

	public int getFPS() {
		// TODO Auto-generated method stub
		return fps;
	}

	public void setPlayerSleepTime(int i) {
		playerfps = i;
	}

	public void setCurrPiecePlayer(PiecePlayer piecePlayer) {
		currPiecePlayer = piecePlayer;
	}
	
	public void setCurrPiece(Piece piece) {
		currPiece = piece;
	}

}
