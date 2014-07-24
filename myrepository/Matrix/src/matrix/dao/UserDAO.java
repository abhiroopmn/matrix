package matrix.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import matrix.exceptions.DatabaseException;
import matrix.models.UserTO;
import matrix.util.DatabaseConnection;

public class UserDAO {

	public static void store(UserTO userTO) throws ClassNotFoundException, SQLException, DatabaseException {
		System.out.println("Inside userDAO. Storing userTO");
		Connection connection = DatabaseConnection.getConnection();
//		PreparedStatement statement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?,?)");
		Statement statement = connection.createStatement();
		String query = "insert into user_details values('"+userTO.getName()+"','"+userTO.getDob()+"','"+userTO.getMobile()+"','"+userTO.getEmail()+"','"+userTO.getAccountNo()+"','"+userTO.getIfsc()+"','"+userTO.getPassword()+"')";
		System.out.println(query);
//		statement.setString(1, userTO.getName());
//		statement.setString(2, userTO.getDob());
//		statement.setString(3, userTO.getMobile());
//		statement.setString(4, userTO.getEmail());
//		statement.setString(5, userTO.getAccountNo());
//		statement.setString(6, userTO.getIfsc());
//		statement.setString(7, userTO.getPassword());
		int insertedRows = statement.executeUpdate(query);
		connection.commit();
		connection.close();
		System.out.println(insertedRows+" rows were inserted");
		if(insertedRows<1){
			throw new DatabaseException("The values could not be stored. Please try again");
		}
		else{
			System.out.println("The values were stored");
		}
	}
}
