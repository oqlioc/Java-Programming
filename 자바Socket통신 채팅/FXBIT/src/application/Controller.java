package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

	private int x = 0;
	private String na = "";
	private String operator = "";
	private Modle model = new Modle();

	@FXML
	private Text result1;
	@FXML
	private TextField name1;
	
	@FXML
	private void operand(ActionEvent event) {
		if ( operator.isEmpty() ) {
			result1.setText(result1.getText() + ((Button) event.getSource()).getText());
		} else {
			x = 0;
			na = "";
			operator = "";
			name1.setText("");
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
			 if (name1.getText().isEmpty()) {
				na = "";
			}else {
				na = name1.getText();
				na = "";
			}
		}
	}

	@FXML
	private void ac(ActionEvent event) {
		x = 0;
		na = "";
		name1.setText("");
		result1.setText("");
		operator = "";
	}
		
}
