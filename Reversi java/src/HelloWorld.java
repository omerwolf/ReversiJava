
import java.awt.Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.*;

public class HelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("REVERSI");
		Label lbl = new Label("WELCOME TO REVERSI");
		lbl.setFont(new Font("Arial", 30));
		StackPane root = new StackPane();
		root.getChildren().add(lbl);
		primaryStage.setScene(new Scene(root,300,500));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
