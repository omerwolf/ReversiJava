package application;

import java.net.URL;
import java.util.ResourceBundle;

import Reversi.Board;
import Reversi.Cell;
import Reversi.GameLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameFlowController implements Initializable {
	@FXML
	private static final int NUM_OF_LINES = 3;
	@FXML
	private int size;
	@FXML
	private Color P1, P2, current;
	@FXML
	private Label scoreBlack, scoreWhite, currentTrun;
	@FXML
	private ReversiBoardController boardControl;
	@FXML
	private GameLogic logic;
	@FXML
	private HBox root;
	@FXML
	private Label message, otherMessage;
	@FXML
	private Button exit;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        SettingHandler handler = new SettingHandler();
        handler.readSetting();
        this.size = handler.getSizeOfBoard();
        P1 = Color.web(handler.getStartPlayer());
        if (P1 == Color.BLACK) {
            P2 = Color.WHITE;
        } else {
            P2 = Color.BLACK;
        }
        this.logic = new GameLogic(size);
        this.boardControl = new ReversiBoardController(logic.getBoard());
        root.getChildren().add(0, boardControl);
        root.setAlignment(Pos.TOP_LEFT);
        boardControl.draw();
        VBox notes = new VBox();
        this.currentTrun = new Label("\nCurrent player: Player 1");
        this.scoreBlack = new Label("Black player score: 2");
        this.scoreWhite = new Label("White player score: 2");
        message = new Label("Player 1:\nIt's your move!");
        message.setFont(new Font(15));
        otherMessage = new Label("");
        otherMessage.setFont(new Font(15));
        this.exit = new Button("Exit");
        this.exit.setOnAction(ev -> {
            goToMenu("OpenWindow.fxml", 600, 600, ev);
        });
        root.setAlignment(Pos.BOTTOM_LEFT);
        root.setSpacing(20);
        notes.setSpacing(10);
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 200;
            boardControl.setPrefWidth(boardNewWidth);
            boardControl.draw();
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
        	boardControl.setPrefHeight(newValue.doubleValue());
        	boardControl.draw();
        });
        notes.getChildren().addAll(currentTrun, scoreBlack, scoreWhite, message, otherMessage, exit);
        root.getChildren().add(notes);
        this.current = P1;
        boardControl.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Cell move = convertClick(e.getX(), e.getY());
            Move(move);
        });	
	}
@FXML
private void Move(Cell move) {
	Cell cell = move;
	cell.setX(move.getX()-1);
	cell.setY(move.getY()-1);
	if (logic.isWin()){
		return;
	}
	if (this.current == Color.BLACK){
		int check = logic.playTurn(Color.BLACK, cell);
		if (check == -1){
			///message
		}
		else if (check ==1){
			this.scoreBlack.setText("Black player score is: " + logic.getScoreBlack());
			this.scoreWhite.setText("White player score is: " + logic.getScoreWhite());
			current = Color.WHITE;
			boardControl.draw();
		}
		else {
			return;
		}
	}
	else{
		int check = logic.playTurn(Color.WHITE, cell);
		if (check == -1){
			///message
		}
		else if (check == 1){
			this.scoreBlack.setText("Black player score is: " + logic.getScoreBlack());
			this.scoreWhite.setText("White player score is: " + logic.getScoreWhite());
			current = Color.BLACK;
			boardControl.draw();
		}
		else {
			return;
		}
	}
}

	private Cell convertClick(double x, double y) {
			
			  for (int i = 0; i < this.size; i++) {
		            for (int j = 0; j < this.size; j++) {
		                if (x >= i * boardControl.getWidthCell() && x <= (i + 1) * boardControl.getWidthCell()) {
		                    if (y >= j * boardControl.getHeightCell() && y <= (j + 1) * boardControl.getHeightCell()) {
		                        Cell temp = new Cell();
		                        temp.setX(j+1);
		                        temp.setY(i+1);
		                    	return temp;
		                    }
		                }
		            }
		        }
			  Cell temp = new Cell();
              temp.setX(-1);
              temp.setY(-1);
          	  return temp;
	}
		
	private void goToMenu(String string, int i, int j, ActionEvent ev) {
			try {
	            Stage primaryStage = (Stage) this.exit.getScene().getWindow();
	            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("OpenWindow.fxml"));
	            root.setAlignment(Pos.CENTER);
	            Scene scene = new Scene(root, 600, 600);
	            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            primaryStage.setTitle("Reversi");
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
		
}