/*
 * Name : Yoel Jasner & Omer Wolf
 */
package Reversi;

import javafx.scene.paint.Color;

public class Cell {
	//members:
	private int x;
	private int y;
	private Color color;

	
    /**
     * Default constructor- creates a cell.
     *
     * color red is default color.
     */
	public Cell(){
		this.x = 0;
		this.y = 0;
		this.color = Color.RED;
	}
	
	 /**
     * This method returns the row of the cell.
     * @return row.
     */
	public int getX() {
		return x;
	}
    /**
     * This method set the row of the cell.
     * 
     * @param x-the row number.
     */
	public void setX(int x) {
		this.x = x;
	}
    /**
     * This method returns the column of the cell.
     * @return column.
     */
	public int getY() {
		return y;
	}
    /**
     * This method set the column of the cell.
     * 
     * @param y-the row number.
     */
	public void setY(int y) {
		this.y = y;
	}
    /**
     * This method returns the color of the cell.
     * @return color.
     */
	public Color getColor() {
		return color;
	}
    /**
     * This method set the color of the cell.
     * 
     * @param color-the new color.
     */
	public void setColor(Color color) {
		this.color = color;
	}
    /**
     * This method print cell.
     * 
     */
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}


}
