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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

   private int x = 0;
   private String operator = "";
   private Modle model = new Modle();

   @FXML
   private Text result1;
   
   
   @FXML
   private void operand(ActionEvent event) {
      if ( operator.isEmpty() ) {
         result1.setText(result1.getText() + ((Button) event.getSource()).getText());
      } else {
         x = 0;
         operator = "";
         result1.setText("");
         result1.setText(result1.getText() + ((Button) event.getSource()).getText());
      }
   }

   @FXML
   private void operator(ActionEvent event) {
      if( result1.getText().isEmpty() ) {
         
      }else if( operator.equals( ((Button) event.getSource()).getText()) ) {
          operator = ((Button) event.getSource()).getText();
      }else {
         operator= ((Button) event.getSource()).getText();
          x = Integer.parseInt(result1.getText());
          result1.setText("");
          result1.setText(Integer.toString(model.calculate(operator, x)));
      }
   }

   @FXML
   private void ac(ActionEvent event) {
      x = 0;
      result1.setText("");
      operator = "";
   }
   
   @FXML
   public void maingo(ActionEvent event) throws IOException {

      Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("FXmain.fxml"));
      Scene home_page_scene1 = new Scene(home_page_parent1);
      Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
      app_stage1.hide();
      app_stage1.setScene(home_page_scene1);
      app_stage1.show();
   }
   
   @FXML
   public void searchhistory(ActionEvent event) throws IOException {
      Parent home_page_parent1 = FXMLLoader.load(getClass().getResource("FXsearchhistory.fxml"));
      Scene home_page_scene1 = new Scene(home_page_parent1);
      Stage app_stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
      app_stage1.hide();
      app_stage1.setScene(home_page_scene1);
      app_stage1.show();
   }
	@FXML
	public void home8(ActionEvent event) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}
	
	@FXML
	private void naver8() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://cafe.naver.com/bufsbithigh6?iframe_url=/MyCafeIntro.nhn%3Fclubid=29531859"));
	}
	
	@FXML
	private void github8() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://github.com/"));
	}
	public void albumpage11(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("AlbumMain.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
		
	}
	public void calpage11(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
		
	}
	@FXML
	public void handle11(ActionEvent event) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

}