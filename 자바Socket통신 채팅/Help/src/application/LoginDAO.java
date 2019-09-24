package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;

public class LoginDAO {
	public static void insertFood(String ID,String Password,String nickName, String myIp) throws SQLException,ClassNotFoundException{
		//Declare a Insert statement
		String updateStmt = "INSERT INTO MEMBER\n"+
				"(ID,PASSWORD,NICKNAME,IP)\n"+
				"VALUES\n"+
				"('"+ID+"','"+Password+"','"+nickName+"','"+myIp+"')";

		//Execute Insert Operation
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERTE Operation: " + e);
			throw e;
		}
	}

	public static boolean login(String ID,String Password)throws SQLException,ClassNotFoundException{
		String queryStmt = "SELECT * FROM MEMBER WHERE ID IN('"+ID+"') AND PASSWORD IN('"+Password+"')";

		String check_id = null;
		String check_pw = null;
		try {
			ResultSet rs = DBUtil.dbExecuteQuery(queryStmt);
			LoginField log = getLoginFromResultSet(rs);
			
			if(log !=null) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured while LOGIN Operation :" +e);
			return false;
		}
	}

	private static LoginField getLoginFromResultSet(ResultSet rs)throws SQLException{
		LoginField model = null;
		if(rs.next())
		{
			model = new LoginField();
			model.setId(rs.getString("ID"));
			model.setPassword(rs.getString("PASSWORD"));
			model.setNickName(rs.getString("NICKNAME"));
			model.setIp(rs.getString("IP"));
		}
		return model;
	}
}