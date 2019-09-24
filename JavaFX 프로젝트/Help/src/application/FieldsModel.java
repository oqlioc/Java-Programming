package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FieldsModel {
	//Declare Food Table Columns
	private StringProperty name;  
	private StringProperty food; 
	private StringProperty post; // ��湲�
	private IntegerProperty score; // ������ 以��ㅺ� 留���.
	
//	private SimpleObjectProperty<Date> postscript; //�닿� 紐⑤�� �곗�댄�곕�� ��踰��� 紐⑥�� �ъ�⑺�������� �⑥���멸굅媛����� �곕��諛⑸��� 李얠���쇳����..
	
	//Constructor
	public FieldsModel() {
		this.name = new SimpleStringProperty();
		this.food = new SimpleStringProperty();
		this.post = new SimpleStringProperty();
		this.score = new SimpleIntegerProperty();
		
//		this.postscript = new SimpleObjectProperty<>();
	}
	// name
	public String getName(){
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	//food
	public String getFood(){
		return food.get();
	}
	public void setFood(String food) {
		this.food.set(food);
	}
	public StringProperty foodProperty() {
		return food;
	}
	
	//post
	public String getPost(){
		return post.get();
	}
	public void setPost(String post) {
		this.post.set(post);
	}
	public StringProperty postProperty() {
		return post;
	}
	
	//score
	public int getScore(){
		return score.get();
	}
	public void setScore(int score) {
		this.score.set(score);
	}
	public IntegerProperty scoreProperty() {
		return score;
	}
	
//	//All_postScript
//	public Object getPostScript()
//	{
//		return postscript.get();
//	}
//	public void setPostScript(Date postscript)
//	{
//		this.postscript.set(postscript);
//	}
//	public SimpleObjectProperty<Date> postScriptProperty(){
//		return postscript;
//	}
}
