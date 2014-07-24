package matrix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import matrix.exceptions.DatabaseException;
import matrix.util.DatabaseConnection;

public class LoginDAO {

	public static String getPassword(String uname) throws DatabaseException {
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select name,password from user_details where email='"+uname+"'");
			while(resultSet.next()){
				System.out.println("Account found");
				return resultSet.getString(1);
			}
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("The database driver is not responding. Try again");
		} catch (SQLException e) {
			throw new DatabaseException("The query couldnt be executed");
		}
		return null;
		
		
	}

	
	
}
