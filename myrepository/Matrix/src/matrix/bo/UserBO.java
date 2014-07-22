package matrix.bo;

import matrix.dao.UserDAO;
import matrix.models.UserTO;

public class UserBO {

	public static boolean validate(UserTO userTO){
		System.out.println("Validating userTO");
		if(true){
			UserDAO.store(userTO);
			System.out.println("Storing successful");
		}
		return true;
	}
}
