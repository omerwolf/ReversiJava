/***********************************************************************
* Name : Yoel Jasner & Omer Wolf									   *
***********************************************************************/
package Reversi;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;

public class Player {
	//members:
	private int score;
	private Color color;
	
	/**
     * constructor- creates a PLayer according to color.
     *
     * @param color1-the color of wanted Player.
     */
	public Player(Color color1){
		this.score = 2;
		this.color = color1;
	}
    /**
     * Check if its legal to make a move from possible move array.
     * 
     * @param allMoves- checked array.
     * @param checkCell - checked cell. 
     * @return true if its legal and false O.W
     */
	public boolean isLegal(ArrayList<Cell> allMoves, Cell checkCell){
		int arrayLen = allMoves.size();
		for (int i = 0; i < arrayLen; i++){
			if ((checkCell.getX() == allMoves.get(i).getX()) && (checkCell.getY() == allMoves.get(i).getY()))
				return true;
			}
			return false;
	}
    /**
     * scan cell from player .
     * 
     * @param allMoves- possible moves array.
     * @return the scanned cell
     */
	public Cell makeMove(ArrayList<Cell> allMoves) {
		Cell cell = new Cell();
		if(allMoves.isEmpty()){
			cell.setX(-1);
			cell.setY(-1);
			cell.setColor(Color.RED);
			return cell;
		}
		else {
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Please enter your move row col (for example:2 5): ");
				while(!sc.hasNextInt()) {
					int scannerNum1 = sc.nextInt();
					int scannerNum2 = sc.nextInt();
					cell.setX(scannerNum1 - 1);
					cell.setY(scannerNum2 - 1);
				}
				cell.setColor(this.color);
				if(!isLegal(allMoves, cell)){
					System.out.println("Not legal move.\n");
				}
			}	while(!isLegal(allMoves, cell));
		sc.close();
		return cell;
		}
		
	}
    /**
     * return the player score
     * 
     * @return score
     */
	public int getScore() {
		return score;
	}
    /**
     * set the player score
     * 
     * @param score - change score wanted
     */
	public void setScore(int score) {
		this.score = score;
	}
    /**
     * return the player color
     * 
     * @return color
     */
	public Color getColor() {
		return color;
	}
    /**
     * set the player color
     * 
     * @param color - change color wanted
     */
	public void setColor(Color color) {
		this.color = color;
	}

	
}
