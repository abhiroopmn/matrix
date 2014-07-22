package matrix.bo;

import matrix.dao.LoginDAO;
import matrix.models.LoginTO;

public class LoginBO {

	public boolean validate(LoginTO loginTO) {
		System.out.println("Validating login in BO");
		String dbPassword = LoginDAO.getPassword(loginTO.getUname());
		if(dbPassword!=null){
			if(dbPassword.equals(loginTO.getPassword())){
				return true;
			}
			else{
				return false;
			}
		}
		else
			return false;
	}

}
