
package Reversi;
import javafx.scene.paint.Color;
import Reversi.Cell;

public class Board{
	//members:
	private Cell[][] matrix;
	private int size;
	
	//Constructor:
	public Board(int sizeOfBoard){
		this.size = sizeOfBoard;
		this.matrix = new Cell[size][size];
		for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                this.matrix[i][j] = new Cell();
	            }
		}
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				if ((row == size / 2 - 1 && col == size / 2 - 1) || (row == size / 2 && col == size / 2)){
					matrix[row][col].setX(row);
					matrix[row][col].setY(col);
					matrix[row][col].setColor(Color.BLACK);
				}
				else if((row == size / 2 && col == size / 2 - 1) || (row == size / 2 - 1 && col == size / 2)){
					matrix[row][col].setX(row);
					matrix[row][col].setY(col);
					matrix[row][col].setColor(Color.WHITE);
				}else {
					matrix[row][col].setX(row);
					matrix[row][col].setY(col);
					matrix[row][col].setColor(Color.RED);
			 	}
			 }
	     }
     }

	
	//getters and setters:
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public Cell getMatrix(int i , int j){
			return matrix[i][j];
		}
		public void setMatrix(int row, int col, Color color){
			matrix[row][col].setColor(color);
	}
}