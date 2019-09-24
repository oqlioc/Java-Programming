package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("유진이가 랩을한다 홍~홍~홍~");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
