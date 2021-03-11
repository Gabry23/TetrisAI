package tetrisAI;

import java.util.Random;

import javax.swing.JFrame;

public class Game implements Runnable {

	private static Map map;

	
	public Game() {
		startGame();
		
	}
	
	
	public void startGame() {
		JFrame f = new JFrame();
		f.setTitle("TETRIS AI...SPETTACOLO............");
		f.setSize(520, 750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		map = new Map();
		f.add(map);
		f.setVisible(true);
		Thread t = new Thread(this);
		t.start();
	}


	@Override
	public void run() {
			
		
		while(true) {
			createPiece();
			for(int i=0; i<map.getMatrix().length; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j=0; j<map.getMatrix()[i].length; j++) {
					
					if(map.getMatrix()[i][j].getValue() != 0 && i<=18 && (map.getMatrix()[i+1][j].getValue() == 0 || map.getMatrix()[i+1][j].getValue() == map.getMatrix()[i][j].getValue() )) {
						
						int type = map.getMatrix()[i][j].getValue();
						
						System.out.println(map.getMatrix()[i][j].getRow());
					
						map.getMatrix()[i+1][j].setValue(type);
						map.getMatrix()[i][j].setValue(0);
						map.getMatrix()[i][j].setRow( map.getMatrix()[i][j].getRow() + 1 );
				
					
//						map.getMatrix()[i][j] = new EmptyBlock(i, j, 0);
				}
				
					
					
				}
				map.update();
			
			}

			
		
			


	

}
	}
	
	
	public void createPiece() {
		
		Random random = new Random();
		int min = 1; // numero minimo
		int max = 7; // numero massimo
		int c = ((max-min) + 1);
		int rand = random.nextInt(c) + min;
		
		if(rand==1) {
			iBlock ib = new iBlock();
			map.matrix[ib.getPiece()[0].getRow()][ib.getPiece()[0].getColumn()] = ib.getPiece()[0];
			map.matrix[ib.getPiece()[1].getRow()][ib.getPiece()[1].getColumn()] = ib.getPiece()[1];
			map.matrix[ib.getPiece()[2].getRow()][ib.getPiece()[2].getColumn()] = ib.getPiece()[2];
			map.matrix[ib.getPiece()[3].getRow()][ib.getPiece()[3].getColumn()] = ib.getPiece()[3];
		}
		
		if(rand==2) {
			jBlock jb = new jBlock();
			map.matrix[jb.getPiece()[0].getRow()][jb.getPiece()[0].getColumn()] = jb.getPiece()[0];
			map.matrix[jb.getPiece()[1].getRow()][jb.getPiece()[1].getColumn()] = jb.getPiece()[1];
			map.matrix[jb.getPiece()[2].getRow()][jb.getPiece()[2].getColumn()] = jb.getPiece()[2];
			map.matrix[jb.getPiece()[3].getRow()][jb.getPiece()[3].getColumn()] = jb.getPiece()[3];
		}
		
		if(rand==3) {
			lBlock lb = new lBlock();
			map.matrix[lb.getPiece()[0].getRow()][lb.getPiece()[0].getColumn()] = lb.getPiece()[0];
			map.matrix[lb.getPiece()[1].getRow()][lb.getPiece()[1].getColumn()] = lb.getPiece()[1];
			map.matrix[lb.getPiece()[2].getRow()][lb.getPiece()[2].getColumn()] = lb.getPiece()[2];
			map.matrix[lb.getPiece()[3].getRow()][lb.getPiece()[3].getColumn()] = lb.getPiece()[3];
		}
		
		
		if(rand==4) {
			oBlock ob = new oBlock();
			map.matrix[ob.getPiece()[0].getRow()][ob.getPiece()[0].getColumn()] = ob.getPiece()[0];
			map.matrix[ob.getPiece()[1].getRow()][ob.getPiece()[1].getColumn()] = ob.getPiece()[1];
			map.matrix[ob.getPiece()[2].getRow()][ob.getPiece()[2].getColumn()] = ob.getPiece()[2];
			map.matrix[ob.getPiece()[3].getRow()][ob.getPiece()[3].getColumn()] = ob.getPiece()[3];
		}
		
		
		if(rand==5) {
			sBlock sb = new sBlock();
			map.matrix[sb.getPiece()[0].getRow()][sb.getPiece()[0].getColumn()] = sb.getPiece()[0];
			map.matrix[sb.getPiece()[1].getRow()][sb.getPiece()[1].getColumn()] = sb.getPiece()[1];
			map.matrix[sb.getPiece()[2].getRow()][sb.getPiece()[2].getColumn()] = sb.getPiece()[2];
			map.matrix[sb.getPiece()[3].getRow()][sb.getPiece()[3].getColumn()] = sb.getPiece()[3];
		}
		
		
		if(rand==6) {
			tBlock tb = new tBlock();
			map.matrix[tb.getPiece()[0].getRow()][tb.getPiece()[0].getColumn()] = tb.getPiece()[0];
			map.matrix[tb.getPiece()[1].getRow()][tb.getPiece()[1].getColumn()] = tb.getPiece()[1];
			map.matrix[tb.getPiece()[2].getRow()][tb.getPiece()[2].getColumn()] = tb.getPiece()[2];
			map.matrix[tb.getPiece()[3].getRow()][tb.getPiece()[3].getColumn()] = tb.getPiece()[3];
		}
		
		if(rand==7) {
			zBlock zb = new zBlock();
			map.matrix[zb.getPiece()[0].getRow()][zb.getPiece()[0].getColumn()] = zb.getPiece()[0];
			map.matrix[zb.getPiece()[1].getRow()][zb.getPiece()[1].getColumn()] = zb.getPiece()[1];
			map.matrix[zb.getPiece()[2].getRow()][zb.getPiece()[2].getColumn()] = zb.getPiece()[2];
			map.matrix[zb.getPiece()[3].getRow()][zb.getPiece()[3].getColumn()] = zb.getPiece()[3];
		}
		
	}
	
}
