package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OpenWindowController extends GridPane {
	@FXML
	private Button startGameB;
	@FXML
	private Button settingB;
	@FXML
	private Button exitB;
	
	@FXML
	protected void startGame() {
        try {
            Stage stage = (Stage) startGameB.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameFlow.fxml"));
            HBox root = (HBox) loader.load();
            Scene GameScene = new Scene(root, 600, 600);
            stage.setScene(GameScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	protected void settingGame() {
        try {
            Stage stage = (Stage) settingB.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Setting.fxml"));
            Pane root = (Pane) loader.load();
            loader.setController(new SettingController());
            Scene settingScene = new Scene(root, 500, 400);
            stage.setScene(settingScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	protected void exit(){
		Stage stage = (Stage) exitB.getScene().getWindow();
		stage.close();
	} 	
}