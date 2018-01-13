
package Reversi;
import Reversi.Cell;
import Reversi.Cell.Color;


public class Board{
	//members:
	private Cell[][] matrix;
	private int size;
	
	//Constructor:
	public Board(int sizeOfBoard){
		this.size = sizeOfBoard;
		this.matrix = new  Cell[sizeOfBoard][sizeOfBoard];
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
					matrix[row][col].setColor(Color.EMPTY);
			 	}
			 }
	     }
     }
	public void insertion(int x, int y , Color color){
		matrix[x - 1][y - 1].setColor(color); 
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