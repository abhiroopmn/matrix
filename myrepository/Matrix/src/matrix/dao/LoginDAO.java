package matrix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import matrix.util.DatabaseConnection;

public class LoginDAO {

	public static String getPassword(String uname) {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select password from login_user where uname='"+uname+"'");
			while(resultSet.next()){
				return resultSet.getString(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	
	
}
