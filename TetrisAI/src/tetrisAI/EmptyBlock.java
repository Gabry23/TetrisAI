package tetrisAI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("emptyBlock")
public class EmptyBlock extends Cell {

	@Param(1)
	private int id = 0;
	
	private static Image image;
	
	public EmptyBlock(int r,int c,int v) {
		super(r,c,v);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/background.png"));
			Image icon = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			image = icon;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static Image getImage() {
		return image;
	}
	
	
}
