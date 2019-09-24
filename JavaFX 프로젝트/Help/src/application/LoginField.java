package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginField {

	private StringProperty id;  
	private StringProperty password;
	private StringProperty nickName;
	private StringProperty Ip;
	public LoginField(){
		this.id = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.nickName = new SimpleStringProperty();
		this.Ip = new SimpleStringProperty();
	}
	
	// name
	public String getId(){
		return id.get();
	}
	public void setId(String name) {
		this.id.set(name);
	}
	
	
	public String getPassword(){
		return password.get();
	}
	public void setPassword(String name) {
		this.password.set(name);
	}
	
	
	public String getNickName(){
		return nickName.get();
	}
	public void setNickName(String name) {
		this.nickName.set(name);
	}
	
	
	public String getIp(){
		return Ip.get();
	}
	public void setIp(String name) {
		this.Ip.set(name);
	}
}
