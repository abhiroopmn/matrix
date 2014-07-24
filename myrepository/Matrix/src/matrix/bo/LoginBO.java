package matrix.bo;

import javax.security.auth.login.LoginException;

import matrix.dao.LoginDAO;
import matrix.exceptions.DatabaseException;
import matrix.models.LoginTO;

public class LoginBO {

	public boolean validate(LoginTO loginTO) throws DatabaseException, LoginException {
		System.out.println("Validating login in BO");
		String dbPassword = null;
		dbPassword = LoginDAO.getPassword(loginTO.getUname());
		if(dbPassword!=null){
			if(dbPassword.equals(loginTO.getPassword())){
				return true;
			}
			else{
				throw new LoginException("Incorrect password");
			}
		}
		else{
			throw new LoginException("Incorrect ID or password");
		}
	}
}