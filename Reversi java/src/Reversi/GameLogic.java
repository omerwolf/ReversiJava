package Reversi;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class GameLogic {
	//members:
	private int scoreBlack, scoreWhite;
	
	public int getScoreBlack() {
		return scoreBlack;
	}
	
	public int getScoreWhite() {
		return scoreWhite;
	}

	public ArrayList<Cell> getWhiteMove() {
		return whiteMove;
	}

	protected Board board;
	protected ArrayList<Cell> blackMove, whiteMove;
	
	//constractor:
	public GameLogic(int size){
		this.board = new Board(size);
	}
	
	//function:
	public void updateScore(){
		this.scoreWhite = countBoard(Color.WHITE);
		this.scoreBlack = countBoard(Color.BLACK);
	}

	public int countBoard(Color sign) {
	    int counter=0;
	    for (int i = 0; i < board.getSize(); i++) {
	        for (int j = 0; j < board.getSize(); j++) {
	            if (board.getMatrix(i, j).getColor() == sign) {
	                counter++;
	            }
	        }
	    }
	    return counter;
	}
	
	public void printMoves(Color sign) {
		System.out.println("Your posible moves:");
	    if (sign == Color.WHITE) {
	    	int size = whiteMove.size();
	        for (int i=1;i<size; i++) {
	        	String temp = whiteMove.toString();
				System.out.println(temp);
	        }
	    }
	    else if (sign == Color.BLACK) {
	    	int size = blackMove.size();
	        for (int i=1;i<size; i++) {
	 			String temp = blackMove.toString();
				System.out.println(temp);        
				}
	    }
	    System.out.println("\n");
	}
	
	public boolean canReverseUp(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY())).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY())).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY())).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY())).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseDown(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		int sizeOfBoard = this.board.getSize();
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY())).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY())).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY())).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY())).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}

	public boolean canReverseRight(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		int sizeOfBoard = this.board.getSize();
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() + (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() + i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() + (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() + i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseLeft(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseUpLeft(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0 || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0 || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseDownLeft(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		int sizeOfBoard = this.board.getSize();
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY() - i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseUpRight(Color sign,Cell move){
		int counter = 0;
		int i = 0;
		int sizeOfBoard = this.board.getSize();
		if (sign == Color.BLACK){
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() + (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() + i)).getColor() == Color.RED)
						return false;
				     counter++;
				     if(move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
				     	return false;
				}
			}
			
		}else{
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() + (i + 1))).getColor() != Color.WHITE){
				i++;
				if((this.board.getMatrix(move.getX() - i, move.getY() + i)).getColor() == Color.RED)
					return false;
			     counter++;
			     if(move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
			     	return false;
				}
			}
			
		}
		if (counter > 0)
			return true;
		return false;
	}
	public boolean canReverseDownRight(Color sign,Cell move){
	int counter = 0;
	int i = 0;
	int sizeOfBoard = this.board.getSize();
	if (sign == Color.BLACK){
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() + (i + 1))).getColor() != Color.BLACK){
				i++;
				if((this.board.getMatrix(move.getX() + i, move.getY() + i)).getColor() == Color.RED)
					return false;
			     counter++;
			     if(move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			     	return false;
			}
		}
		
	}else{
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.RED || move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() + (i + 1))).getColor() != Color.WHITE){
				i++;
				if((this.board.getMatrix(move.getX() + i, move.getY() + i)).getColor() == Color.RED)
					return false;
			     counter++;
			     if(move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			     	return false;
			}
		}
		
	}
	if (counter > 0)
		return true;
	return false;
}
	
	
	////////
	private ArrayList <Cell> PossibleMoves(Color sign) {
	    ArrayList <Cell> arrTemp = new ArrayList<Cell>();
	    Cell temp = new Cell();
	    for (int i = 0; i < board.getSize(); i++) {
	        for (int j = 0; j < board.getSize(); j++) {
	            temp.setX(i);
	            temp.setY(j);
	            if (canReverseDownRight(sign, temp) || canReverseUp(sign, temp) ||
	                canReverseDown(sign, temp) || canReverseRight(sign, temp) ||
	                canReverseLeft(sign, temp) || canReverseDownLeft(sign, temp) ||
	                canReverseUpRight(sign, temp) || canReverseUpLeft(sign, temp)) {
	            	Cell fix = new Cell();
	            	fix.setX(i);
	            	fix.setY(j);
	                arrTemp.add(fix);
	            }
	        }
	    }
	    return arrTemp;
	}
	public boolean isWin() {
		setVector(PossibleMoves(Color.BLACK), Color.BLACK);
        setVector(PossibleMoves(Color.WHITE), Color.WHITE);
	    if ((blackMove.isEmpty()) && (whiteMove.isEmpty())) {
	        return true;
	    }
	    return false;
	}

	private void flip(Color sign, Cell cell) {
	    cell.setColor(sign);
	    if (canReverseDown(sign, cell))
	        flipDown(cell);
	    if (canReverseUp(sign, cell))
	        flipUp(cell);
	    if (canReverseLeft(sign, cell))
	        flipLeft(cell);
	    if (canReverseRight(sign, cell))
	        flipRight(cell);
	    if (canReverseDownLeft(sign, cell))
	        flipDownLeft(cell);
	    if (canReverseDownRight(sign, cell))
	        flipDownRight(cell);
	    if (canReverseUpLeft(sign, cell))
	        flipUpLeft(cell);
	    if (canReverseUpRight(sign, cell))
	        flipUpRight(cell);
	    board.setMatrix(cell.getX(), cell.getY(), cell.getColor());
	}
	private void flipDown(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() + i, cell.getY())).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() + i, cell.getY(), cell.getColor());
	        i++;
	    }
	}

	private void flipUp(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY())).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY(), cell.getColor());
	        i++;
	    }
	}

	private void flipRight(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() , cell.getY()+i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() , cell.getY()+i, cell.getColor());
	        i++;
	    }
	}

	private void flipLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX(), cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX(), cell.getY() - i, cell.getColor());
	        i++;
	    }
	}

	private void flipDownLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX()+i, cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX()+i, cell.getY() - i, cell.getColor());
	        i++;
	    }
	}

	private void flipDownRight(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() + i, cell.getY() + i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() + i, cell.getY() + i, cell.getColor());
	        i++;
	    }
	}

	private void flipUpLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY() - i, cell.getColor());
	        i++;
	    }
	}

	private void flipUpRight(Cell cell) {
	    int i=1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY() + i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY() + i, cell.getColor());
	        i++;
	    } 
	}
	public int playTurn(Color color, Cell cell) {
	    ArrayList <Cell> temp = PossibleMoves(color);
	    if (temp.isEmpty()){
	    	return -1;
	    }
	    else {
		    setVector(temp, color);
		    if (isLegal(temp, cell)){
	        flip(color, cell);
		    updateScore();
		    return 1;
		    }
		    else {
		    	return 0;
		    }
	    }
	}

	public boolean isLegal(ArrayList<Cell> allMoves, Cell checkCell){
		int arrayLen = allMoves.size();
		for (int i = 0; i < arrayLen; i++){
			if ((checkCell.getX() == allMoves.get(i).getX()) && (checkCell.getY() == allMoves.get(i).getY()))
				return true;
			}
			return false;
	}
	
	public Board getBoard(){
		return this.board;
	}
	private void setVector(ArrayList <Cell> temp, Color sign){
	    if (sign ==  Color.BLACK){
	        blackMove = temp;
	    }
	    else if (sign ==  Color.WHITE){
	        whiteMove =temp;
	    }
	}

}
