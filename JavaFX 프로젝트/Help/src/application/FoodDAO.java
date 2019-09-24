package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FoodDAO {

    //*************************************
    //INSERT an Food postScript
    //*************************************
	public static void insertFood(String name,String food,String post,int score) throws SQLException,ClassNotFoundException{
		//Declare a Insert statement
		String updateStmt = "INSERT INTO FOOD\n"+
				"(NAME,FOOD,POST,SCORE)\n"+
				"VALUES\n"+
				"('"+name+"','"+food+"','"+post+"','"+score+"')";
		
		//Execute Insert Operation
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERTE Operation: " + e);
			throw e;
		}
	}
	
    //*************************************
    //Select * from Food operation
    //*************************************
	private static ObservableList<FieldsModel> getFoodList(ResultSet rs)throws SQLException, ClassNotFoundException{
		ObservableList<FieldsModel> foodList= FXCollections.observableArrayList();
		System.out.println("getFoodList에 들어왓음");
		while(rs.next())
		{
			FieldsModel fm = new FieldsModel();
			fm.setName(rs.getString("name"));
			System.out.println(fm.getName());
			fm.setFood(rs.getString("food"));
			System.out.println(fm.getFood());
			fm.setPost(rs.getString("post"));
			System.out.println(fm.getPost());
			fm.setScore(rs.getInt("score"));
			System.out.println(fm.getScore());
			
			foodList.add(fm);
		}
		return foodList;
	}
//	//Use ResultSet from DB as parameter and set FieldsModel Object`s attributes and return FieldsModel object
//	private static FieldsModel getFoodFromResultSet(ResultSet rs)throws SQLException{
//		FieldsModel model = null;
//		if(rs.next())
//		{
//			model = new FieldsModel();
//			model.setName(rs.getString("name"));
//			model.setFood(rs.getString("name"));
//			model.setName(rs.getString("name"));
//			model.setName(rs.getString("name"));
//		}
//		return model;
//	}
	public static ObservableList<FieldsModel> searchFood(String food)throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM FOOD WHERE FOOD = '"+food+"'";
				
		
		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsFoods = DBUtil.dbExecuteQuery(selectStmt);
			//Send ResultSet to the getFoodList method and get FieldsModel object
			ObservableList<FieldsModel> foodList = getFoodList(rsFoods);
			return foodList;
		}catch(SQLException e) {
			System.out.println("SQL select operation has been failed : " + e);
			//Return exception
			throw e;
		}
	}
	
	//*************************************
    //DELETE an employee
    //*************************************
	public static void deleteFoodWithName(String name) throws SQLException,ClassNotFoundException{
		//Declare a Delete statement
		
		String updateStmt = "DELETE FROM SYSTEM.FOOD WHERE NAME = '" + name +"'";
		
		//Excute Update Operation
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		}catch(SQLException e) {
			System.out.println("ERROR occured while DELETE Operation : " + e);
			throw e;
		}
	}
	

}
