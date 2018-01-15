package Reversi;
import javafx.scene.paint.Color;


public class GameManager {
	///members
	private GameLogic logic;
	private  Player firstPlayer; 
	private  Player secondPlayer;
	
	////functions
	private boolean isWinGame(){
		return logic.isWin();
	}
	
	public void start() {
	    do {
	        //logic.playTurn(firstPlayer);
	        if (isWinGame()) {
				return;
	        }
	        ///logic.playTurn(secondPlayer);
	    } while (!isWinGame());
	    return;
	}
	
	GameManager(int size, Color first, Color second ){
		this.firstPlayer = new Player(first);
		this.secondPlayer = new Player(second);
		this.logic = new GameLogic(size);
	}
	

}