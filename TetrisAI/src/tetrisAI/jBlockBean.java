package tetrisAI;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("jblockbean")
public class jBlockBean {
	@Param(0)
	private int X1;
	@Param(1)
	private int Y1;
	@Param(2)
	private int X2;
	@Param(3)
	private int Y2;
	@Param(4)
	private int X3;
	@Param(5)
	private int Y3;
	@Param(6)
	private int X4;
	@Param(7)
	private int Y4;
	@Param(8)
	private int value = 1;
	
	public jBlockBean(int X1,int X2,int X3,int X4,int Y1,int Y2,int Y3,int Y4, int v) {
		this.X1 = X1;
		this.X2 = X2;
		this.X3 = X3;
		this.X4 = X4;
		this.Y1 = Y1;
		this.Y2 = Y2;
		this.Y3 = Y3;
		this.Y4 = Y4;
	    value = v;
		
	}
	
	public jBlockBean() {
		
	}


	public int getX1() {
		return X1;
	}


	public void setX1(int x1) {
		X1 = x1;
	}


	public int getY1() {
		return Y1;
	}


	public void setY1(int y1) {
		Y1 = y1;
	}


	public int getX2() {
		return X2;
	}


	public void setX2(int x2) {
		X2 = x2;
	}


	public int getY2() {
		return Y2;
	}


	public void setY2(int y2) {
		Y2 = y2;
	}


	public int getX3() {
		return X3;
	}


	public void setX3(int x3) {
		X3 = x3;
	}


	public int getY3() {
		return Y3;
	}


	public void setY3(int y3) {
		Y3 = y3;
	}


	public int getX4() {
		return X4;
	}


	public void setX4(int x4) {
		X4 = x4;
	}


	public int getY4() {
		return Y4;
	}


	public void setY4(int y4) {
		Y4 = y4;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	
}
