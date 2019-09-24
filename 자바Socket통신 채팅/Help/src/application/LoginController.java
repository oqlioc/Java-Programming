package application;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController extends main1{

	@FXML
	private TextField IDText;
	@FXML
	private TextField PWText;
	@FXML
	private TextField ID;
	@FXML
	private TextField PW;
	@FXML
	private TextField nickName;
	@FXML
	private Button signUp;
	@FXML
	private Button register;
	
	private InetAddress myIp;
	
	
	@FXML
	public void RegisterPage(ActionEvent event) throws IOException {

		Parent home_page_parent = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();

	}
	public void Register(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		myIp = InetAddress.getLocalHost();
		
		try {
			LoginDAO.insertFood(ID.getText(), PW.getText(), nickName.getText(),myIp.getHostAddress());
			
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.hide();
			app_stage.setScene(home_page_scene);
			app_stage.show();
			
		}catch (SQLException e)
		{
			System.out.println("Problem occured while inserting Food :" + e);
			throw e;
		}
	}
	

	public void Login(ActionEvent event)throws SQLException,ClassNotFoundException, IOException {
		boolean check;
		check = LoginDAO.login(IDText.getText(), PWText.getText());
		
		if(check == true) {
			System.out.println("Login succeed");
			
			main1 m1 = new main1();
			Pane pane = new Pane();
			Scene scene = new Scene(pane);
			Stage stage = new Stage();
			stage.setScene(scene);
			m1.start(stage);
			stage.show();
			
		}else {
			System.out.println("Login fail");
		}
	}
}
