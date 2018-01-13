package Reversi;

public class Cell {
	//members:
	private int x;
	private int y;
	private Color color;
	public enum Color {BLACK,WHITE,EMPTY}
	
	//constructor:
	public Cell(){
		this.x = 0;
		this.y = 0;
		this.color = Color.EMPTY;
	}
	
	//getters and setters:
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	//toString:
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}


}
