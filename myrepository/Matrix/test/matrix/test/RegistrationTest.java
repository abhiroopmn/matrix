package matrix.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import matrix.bo.UserBO;
import matrix.exceptions.ParameterValidationException;
import matrix.models.UserTO;

import org.junit.Test;

public class RegistrationTest{

	@Test
	public void validateName(){
		UserTO userTO = new UserTO();
		userTO.setName("Abh1iroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("The name cannot contain numbers of special characters", e.getMessage());
		}
	}

	@Test
	public void validateEmail1(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid email ID", e.getMessage());
		}
	}

	@Test
	public void validateEmail2(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid email ID", e.getMessage());
		}
	}

	@Test
	public void validateEmail3(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmailcom");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid email ID", e.getMessage());
		}
	}

	//	@Test
	//	public void validatePassword(){
	//		UserTO userTO = new UserTO();
	//		userTO.setName("Abhiroop");
	//		userTO.setEmail("abhiroop2008@gmail.com");
	//		userTO.setPassword("cognizant");
	//		userTO.setMobile("9551321180");
	//		userTO.setDob("1991-09-01");
	//		userTO.setAccountNo("111111");
	//		userTO.setIfsc("1111");
	//		try {
	//			UserBO.validate(userTO);
	//			fail();
	//		} catch (ParameterValidationException e) {
	//			assertEquals("The name cannot contain numbers of special characters", e.getMessage());
	//		} catch (DatabaseException e) {
	//			fail();
	//		}
	//	}

	@Test
	public void validateMobile(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("955132180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid mobile number", e.getMessage());
		}
	}

	@Test
	public void validateDob(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-13-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("The Format of Date of Birth is invalid", e.getMessage());
		}
	}

	@Test
	public void validateAccountNo(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111.111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid Account Number", e.getMessage());
		}
	}

	@Test
	public void validateIfsc(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("11.11");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			fail();
		} catch (ParameterValidationException e) {
			assertEquals("Invalid IFSC Code", e.getMessage());
		}
	}
	
	@Test
	public void validateDobFormat(){
		UserTO userTO = new UserTO();
		userTO.setName("Abhiroop");
		userTO.setPassword("cognizant");
		userTO.setEmail("abhiroop2008@gmail.com");
		userTO.setDob("1991-09-01");
		userTO.setAccountNo("111111");
		userTO.setIfsc("1111");
		userTO.setMobile("9551321180");
		try {
			UserBO.validateUser(userTO);
			System.out.println(userTO);
			assertEquals("01-Sep-1991", userTO.getDob());
		} catch (ParameterValidationException e) {
			fail();
		}
	}
}
