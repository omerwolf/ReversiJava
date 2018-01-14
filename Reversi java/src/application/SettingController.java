package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingController implements Initializable {
	@FXML
	private ChoiceBox<Integer> sizeBoard;
	@FXML
	private ChoiceBox<Color> playerColor;
	@FXML
	private ChoiceBox<Color> firstPlayer;
	@FXML
	private Button back;
	
	@FXML
    protected void mainMenu() throws IOException {
        try {
            String writeStartingP;
            SettingHandler handler = new SettingHandler();
            if (firstPlayer.getValue().equals(Color.WHITE)) {
                writeStartingP = "WHITE";
            } else {
                writeStartingP = "BLACK";
            }
            handler.writeSetting(sizeBoard.getValue(), writeStartingP, playerColor.getValue().toString());
            Stage primaryStage = (Stage) back.getScene().getWindow();
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("OpenWindow.fxml"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sizeBoard.getItems().addAll(4,6,8,10,12,14,16,18,20);
		playerColor.getItems().addAll(Color.BLACK, Color.WHITE);
		firstPlayer.getItems().addAll(Color.BLACK, Color.WHITE);
		handleSettingFile();
	}


	private void handleSettingFile() {
		SettingHandler handler = new SettingHandler();
        handler.readSetting();
        sizeBoard.setValue(handler.getSizeOfBoard());
        playerColor.setValue(Color.web(handler.getMyPlayer()));
        if (handler.getStartPlayer().equals("BLACK")) {
            firstPlayer.setValue(Color.BLACK);
        } else {
            firstPlayer.setValue(Color.WHITE);
        }
	}
}
