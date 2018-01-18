/*
 * Name : Yoel Jasner & Omer Wolf
 */
package Reversi;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class GameLogic {
	//members:
	private int scoreBlack, scoreWhite;
	protected Board board;
	protected ArrayList<Cell> blackMove, whiteMove;
	
    /**
     * constructor- creates a GameLogic and initialize 
     *              its board according the size.
     *
     * @param size-the size of the board.
     * 
     */
	public GameLogic(int size){
		this.board = new Board(size);
	}
	
    /**
     * update the score of game.
     */
	public void updateScore(){
		this.scoreWhite = countBoard(Color.WHITE);
		this.scoreBlack = countBoard(Color.BLACK);
	}
    /**
     * count the score of the player depending his color
     * 
     * @param sign- the color of the counted player.
     * @return the score of given color.
     */
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
    /**
     * print all possible moves.
     * 
     */
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
    /**
     * Check if its possible to make reverse up
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse down
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse right
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse left
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse up-left
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse down-left
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse up-right
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse down-right
     * 
     * @param sign- the color that check.
     * @param move - the cell that check.
     * @return true if its possible and false O.W
     */
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
    /**
     * Check if its possible to make reverse in any direction.
     * 
     * @param sign- the color that check.
     * @return array of possible moves
     */
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
    /**
     * check if there are possible moves.
     * 
     * @return false if there are possible and true O.W
     */
	public boolean isWin() {
		setVector(PossibleMoves(Color.BLACK), Color.BLACK);
        setVector(PossibleMoves(Color.WHITE), Color.WHITE);
	    if ((blackMove.isEmpty()) && (whiteMove.isEmpty())) {
	        return true;
	    }
	    return false;
	}
    /**
     * flip the color on the board for any diraction.
     * 
     * @param sign- the color that want to change.
     * @param cell - the destination cell. 
     */
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
    /**
     * flip the color on the board down.
     * 
     * @param cell - the destination cell. 
     */
	private void flipDown(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() + i, cell.getY())).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() + i, cell.getY(), cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board up.
     * 
     * @param cell - the destination cell. 
     */
	private void flipUp(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY())).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY(), cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board right.
     * 
     * @param cell - the destination cell. 
     */
	private void flipRight(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() , cell.getY()+i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() , cell.getY()+i, cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board left.
     * 
     * @param cell - the destination cell. 
     */
	private void flipLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX(), cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX(), cell.getY() - i, cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board down-left.
     * 
     * @param cell - the destination cell. 
     */
	private void flipDownLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX()+i, cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX()+i, cell.getY() - i, cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board down-right.
     * 
     * @param cell - the destination cell. 
     */
	private void flipDownRight(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() + i, cell.getY() + i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() + i, cell.getY() + i, cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board up-left.
     * 
     * @param cell - the destination cell. 
     */
	private void flipUpLeft(Cell cell) {
	    int i = 1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY() - i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY() - i, cell.getColor());
	        i++;
	    }
	}
    /**
     * flip the color on the board up-right.
     * 
     * @param cell - the destination cell. 
     */
	private void flipUpRight(Cell cell) {
	    int i=1;
	    while ((board.getMatrix(cell.getX() - i, cell.getY() + i)).getColor() != cell.getColor()) {
	        board.setMatrix(cell.getX() - i, cell.getY() + i, cell.getColor());
	        i++;
	    } 
	}
    /**
     * play on turn.
     * 
     * @param sign- the color that want to change.
     * @param cell - the destination cell. 
     * @return -1 if there is no move, 1 if its successes to flip, and 0 is it's not a legal move
     */
	public int playTurn(Color color, Cell cell) {
	    ArrayList <Cell> temp = PossibleMoves(color);
	    setVector(temp, color);
	    if (isLegal(temp, cell)){
	        flip(color, cell);
		    updateScore();
		    if (counterColorCanPlay(color)){
		    	return 1;
		    	
		    }
		    else {
		    	return 2;
		    }
		}
		else {
			return 0;
		}
	}
	
    private boolean counterColorCanPlay(Color color) {
    	if (color == Color.BLACK){
    		setVector(PossibleMoves(Color.WHITE), Color.WHITE);
    		if (whiteMove.isEmpty()){
    			return false;
    		}
    	}
    	else{
    		setVector(PossibleMoves(Color.BLACK), Color.BLACK);
    		if (blackMove.isEmpty()){
    			return false;
    		}
    	}
    	return true;
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
     * Return the current board.

     * @return board
     */
	public Board getBoard(){
		return this.board;
	}
    /**
     * set the moves array.
     * 
     * @param temp-  array.
     * @param sign - color. 
     */
	private void setVector(ArrayList <Cell> temp, Color sign){
	    if (sign ==  Color.BLACK){
	        blackMove = temp;
	    }
	    else if (sign ==  Color.WHITE){
	        whiteMove =temp;
	    }
	}
    /**
     * Return the score of the black player.
     * @return score
     */
	public int getScoreBlack() {
		return scoreBlack;
	}
    /**
     * Return the score of the white player.
     * @return score
     */
	public int getScoreWhite() {
		return scoreWhite;
	}
    /**
     * Return the moves of the white player.
     * @return white moves array
     */
	public ArrayList<Cell> getWhiteMove() {
		return whiteMove;
	}


}
