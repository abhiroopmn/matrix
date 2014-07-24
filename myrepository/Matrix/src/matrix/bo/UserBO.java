package matrix.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import matrix.dao.UserDAO;
import matrix.exceptions.DatabaseException;
import matrix.exceptions.ParameterValidationException;
import matrix.models.UserTO;

public class UserBO {

	public static void validateAndStore(UserTO userTO) throws ParameterValidationException, DatabaseException{
		
		validateUser(userTO);
		System.out.println("All validations successsful. Storing object");
		storeUser(userTO);
		
	}
	
	public static void validateUser(UserTO userTO) throws ParameterValidationException{
		System.out.println("Validating userTO");

		//Evaluating name
		System.out.println("Evaluating name");
		String name = userTO.getName();
		if(!name.matches("[a-zA-Z ]+")){
			throw new ParameterValidationException("The name cannot contain numbers of special characters");
		}

		//Evaluating email
		System.out.println("Evaluating email");
		String email = userTO.getEmail();
		if(!email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
			throw new ParameterValidationException("Invalid email ID");
		}
		
		//Evaluating DOB
		System.out.println("Evaluating DOB");
		String dob = userTO.getDob();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat databaseFormat = new SimpleDateFormat("dd-MMM-yyyy");
		simpleDateFormat.setLenient(false);
		try {
			Date date = simpleDateFormat.parse(dob);
			userTO.setDob(databaseFormat.format(date));
		} catch (ParseException e) {
			throw new ParameterValidationException("The Format of Date of Birth is invalid");
		}

		//Evaluating Mobile number
		System.out.println("Evaluating mobile number");
		String mobile = userTO.getMobile();
		if(!mobile.matches("[0-9]{10}")){
			throw new ParameterValidationException("Invalid mobile number");
		}

		//Evaluating AccountNo
		System.out.println("Evaluating account number");
		String accountNo = userTO.getAccountNo();
		if(!accountNo.matches("[a-zA-Z0-9]+")){
			throw new ParameterValidationException("Invalid Account Number");
		}

		//Evaluating IFSC Code
		System.out.println("Evaluating IFSC Code");
		String ifsc = userTO.getIfsc();
		if(!ifsc.matches("[a-zA-Z0-9]+")){
			throw new ParameterValidationException("Invalid IFSC Code");
		}
	}
	public static void storeUser(UserTO userTO) throws DatabaseException{
		//Store in database
		try {
			UserDAO.store(userTO);
			System.out.println("Storing successful");
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("The database could not be connected");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("The data couldnt be stored in database");
		}
	}
}