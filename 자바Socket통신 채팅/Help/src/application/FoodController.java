package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FoodController {
	@FXML
	private TextField name;
	@FXML
	private TextField post;
	@FXML
	private TextArea postscript;
	@FXML
	private ImageView image1;
	
	private String food;
	
	//평점 용으로 만든것들
	@FXML
	private SplitMenuButton selectScore;
	
	@FXML
	private MenuItem score1;
	@FXML
	private MenuItem score2;
	@FXML
	private MenuItem score3;
	@FXML
	private MenuItem score4;
	@FXML
	private MenuItem score5;
	
	private int score;
	
	//버튼들
	@FXML
	private Button confirm;
	@FXML
	private Button postScript;
	
	//데이터베이스에 있는 값들을 가져오기위해서 만들엇음.
	@FXML
	private TableView<FieldsModel> postScriptTable;
	@FXML
	private TableColumn<FieldsModel, String> nameColumn;
	@FXML
	private TableColumn<FieldsModel, String> postScriptColumn;
	@FXML
	private TableColumn<FieldsModel, Integer> scoreColumn;
	
	@FXML
	private void insertPostScript() throws SQLException,ClassNotFoundException {
		food = image1.getId();
		try {
			FoodDAO.insertFood(name.getText(), food, post.getText(), score);
			
		}catch (SQLException e)
		{
			System.out.println("Problem occured while inserting Food :" + e);
			throw e;
		}
	}
	
	
//	private void populateFood(FieldsModel model) throws SQLException, ClassNotFoundException{
//		//Declare and ObservableList for TextArea
//		ObservableList<FieldsModel> foodData = FXCollections.observableArrayList();
//		//Add Food to the ObservableList
//		foodData.add(model);
//		//Set items to the TextArea
//		
//	}
	@FXML
	private void searchFoods(ActionEvent actionEvent) throws SQLException,ClassNotFoundException{
		food = image1.getId();
		try {
			//Get All Foods information
			ObservableList<FieldsModel> foodData = FoodDAO.searchFood(food);
			//populate Foods on TextArea
			setFoodInfoToTextArea(foodData);
		}catch(SQLException e) {
			System.out.println("Error occured while getting food information from DB.\n"+e);
			throw e;
		}
	}
	@FXML
	private void setFoodInfoToTextArea(ObservableList<FieldsModel> foodData)throws ClassNotFoundException {
		postScriptTable.setItems(foodData);

	}
	//Initializing the controller class
	//This method is automatically called after the fxml file has been Loaded
	@FXML
	private void initialize() {
		//테이블의 열을 초기화 시켜주는 작업임당
		 nameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
		 postScriptColumn.setCellValueFactory(cellData->cellData.getValue().postProperty());
		 scoreColumn.setCellValueFactory(cellData->cellData.getValue().scoreProperty().asObject());
	}
	
	@FXML
	private void setScore1(ActionEvent actionEvent)throws SQLException,ClassNotFoundException { this.score = 1; }
	@FXML
	private void setScore2(ActionEvent actionEvent)throws SQLException,ClassNotFoundException { this.score = 2; }
	@FXML
	private void setScore3(ActionEvent actionEvent)throws SQLException,ClassNotFoundException { this.score = 3; }
	@FXML
	private void setScore4(ActionEvent actionEvent)throws SQLException,ClassNotFoundException { this.score = 4; }
	@FXML
	private void setScore5(ActionEvent actionEvent)throws SQLException,ClassNotFoundException { this.score = 5; }
	
	public void albumpage11(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("AlbumMain.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}

	public void calpage11(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}

	@FXML
	public void home4(ActionEvent event) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}

	@FXML
	private void naver4() throws IOException, URISyntaxException {
		Desktop.getDesktop()
				.browse(new URI("https://cafe.naver.com/bufsbithigh6?iframe_url=/MyCafeIntro.nhn%3Fclubid=29531859"));
	}

	@FXML
	private void github4() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://github.com/"));
	}
	
	@FXML
	private void game4(ActionEvent event)throws IOException{
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Checking2.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}
}