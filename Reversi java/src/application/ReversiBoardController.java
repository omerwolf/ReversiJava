package application;

import java.io.IOException;

import Reversi.Board;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ReversiBoardController extends GridPane {
	private Board board;
	private double heightCell, widthCell;
	
	public double getHeightCell() {
		return heightCell;
	}

	public double getWidthCell() {
		return widthCell;
	}

	ReversiBoardController (Board b){
		this.board = b;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	public void draw () {
		int sizeOfBoard = board.getSize();
		this.getChildren().clear();
		double height = this.getPrefHeight();
		double width = this.getPrefWidth();
		this.heightCell  = (height / sizeOfBoard) + 1;
		this.widthCell = (width / sizeOfBoard) + 1;
		double r = (heightCell*0.75)/2;
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				Rectangle rec = new Rectangle(widthCell,heightCell,Color.RED);
				rec.setStroke(Color.PINK);
                rec.setStrokeWidth(1);
                StackPane pane = new StackPane();
                pane.getChildren().addAll(rec);
                //this.add(pane, j, i);
                if (board.getMatrix(i, j).getColor() == Color.RED) 
                	this.add(pane, j, i);
                else {
                	pane.getChildren().add(new Circle(((widthCell + 1) / 2) * i,
                            ((heightCell + 1) / 2) * j, r, board.getMatrix(i, j).getColor()));
                    this.add(pane, j, i);
                }
			}
		}
	}
}


