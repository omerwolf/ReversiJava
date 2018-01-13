package Reversi;
import Reversi.Cell;
import Reversi.Cell.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	//members:
	private int score;
	private Color color;
	
	//Constructor:
	public Player(Color color1){
		this.score = 2;
		this.color = color1;
	}
	//function:
	public boolean isLegal(ArrayList<Cell> allMoves, Cell checkCell){
		int arrayLen = allMoves.size();
		for (int i = 0; i < arrayLen; i++){
			if ((checkCell.getX() == allMoves.get(i).getX()) && (checkCell.getY() == allMoves.get(i).getY()))
				return true;
			}
			return false;
	}
	
	public Cell makeMove(ArrayList<Cell> allMoves) {
		Cell cell = new Cell();
		if(allMoves.isEmpty()){
			cell.setX(-1);
			cell.setY(-1);
			cell.setColor(Color.EMPTY);
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
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	
}
