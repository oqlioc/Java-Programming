package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Albumsub4 {

	public void albumpage14(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("AlbumMain.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
		
	}
	public void calpage14(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
		
	}
	@FXML
	public void home7(ActionEvent event) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}
	
	@FXML
	private void naver7() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://cafe.naver.com/bufsbithigh6?iframe_url=/MyCafeIntro.nhn%3Fclubid=29531859"));
	}
	
	@FXML
	private void github7() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://github.com/"));
	}
}
