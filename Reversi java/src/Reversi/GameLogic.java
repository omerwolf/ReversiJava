package Reversi;
import java.util.ArrayList;
import Reversi.Cell.Color;

public class GameLogic {
	//members:
	protected Board board;
	protected ArrayList<Cell> blackMove, whiteMove;
	
	//constractor:
	GameLogic(int size){
		this.board = new Board(size);
		
	}
	//function:
	public void printWinner(){
		int numOfWhite = countBoard(Color.WHITE);
		int numOfBlack = countBoard(Color.BLACK);
		if (numOfWhite > numOfBlack)
			System.out.println("Congratulation the white player is the winner");
		else if (numOfWhite < numOfBlack)
			System.out.println("Congratulation the black player is the winner");
		else
			System.out.println("It's a tie, well done");
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY())).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY())).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY())).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY())).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY())).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY())).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY())).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY())).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() + (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() + i)).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getY() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() + (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() + i)).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() - i)).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getY() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX(), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX(), move.getY() - i)).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0 || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() - i)).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() - i == 0)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0 || move.getX() - i == 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() - i)).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() - (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY() - i)).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				     	return false;
				}
			}
			
		}
		else {
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() - i == 0 || move.getX() + i + 1 == sizeOfBoard)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() - (i + 1))).getColor() != Color.WHITE){
					i++;
					if((this.board.getMatrix(move.getX() + i, move.getY() - i)).getColor() == Color.EMPTY)
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
			if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
				return false;
			else {
				while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() + (i + 1))).getColor() != Color.BLACK){
					i++;
					if((this.board.getMatrix(move.getX() - i, move.getY() + i)).getColor() == Color.EMPTY)
						return false;
				     counter++;
				     if(move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
				     	return false;
				}
			}
			
		}else{
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1== sizeOfBoard || move.getX() - i== 0)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() - (i + 1), move.getY() + (i + 1))).getColor() != Color.WHITE){
				i++;
				if((this.board.getMatrix(move.getX() - i, move.getY() + i)).getColor() == Color.EMPTY)
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
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() + (i + 1))).getColor() != Color.BLACK){
				i++;
				if((this.board.getMatrix(move.getX() + i, move.getY() + i)).getColor() == Color.EMPTY)
					return false;
			     counter++;
			     if(move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			     	return false;
			}
		}
		
	}else{
		if((this.board.getMatrix(move.getX(), move.getY())).getColor() != Color.EMPTY || move.getY() + i + 1== sizeOfBoard || move.getX() + i + 1== sizeOfBoard)
			return false;
		else {
			while ((this.board.getMatrix(move.getX() + (i + 1), move.getY() + (i + 1))).getColor() != Color.WHITE){
				i++;
				if((this.board.getMatrix(move.getX() + i, move.getY() + i)).getColor() == Color.EMPTY)
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
	    ArrayList <Cell> arrTemp = new ArrayList<>();
	    Cell temp = new Cell();
	    for (int i = 0; i < board.getSize(); i++) {
	        for (int j = 0; j < board.getSize(); j++) {
	            temp.setX(i);
	            temp.setY(j);
	            if (canReverseDownRight(sign, temp) || canReverseUp(sign, temp) ||
	                canReverseDown(sign, temp) || canReverseRight(sign, temp) ||
	                canReverseLeft(sign, temp) || canReverseDownLeft(sign, temp) ||
	                canReverseUpRight(sign, temp) || canReverseUpLeft(sign, temp)) {
	                arrTemp.add(temp);
	            }
	        }
	    }
	    return arrTemp;
	}
	public boolean isWin() {
	    if ((blackMove.isEmpty()) && (whiteMove.isEmpty())) {
	        printWinner();
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
	public int playTurn(Player player) {
	    Cell cell;
	    ArrayList <Cell> temp = PossibleMoves(player.getColor());
	    setVector(temp, player.getColor());
	    printMoves(player.getColor());
	    cell = player.makeMove(temp);
	    if (cell.getX() == -1 && cell.getY() == -1) {
	        System.out.println("You have no legal Move.\n");
	        return -1;
	    }
	    else {
			System.out.println("Played :" + cell);
	        flip(player.getColor(), cell);
	        setVector(PossibleMoves(Color.BLACK), Color.BLACK);
	        setVector(PossibleMoves(Color.WHITE), Color.WHITE);
	    }
	    return 1;
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
