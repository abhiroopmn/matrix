package matrix.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import matrix.bo.UserBO;
import matrix.exceptions.DatabaseException;
import matrix.exceptions.ParameterValidationException;
import matrix.models.UserTO;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet method of Registration Controller");
		Enumeration parameters = request.getParameterNames();
		while(parameters.hasMoreElements()){
			String parameter = (String) parameters.nextElement();
			System.out.println(parameter+": "+request.getParameter(parameter));
		}
		UserTO userTO = new UserTO();
		userTO.setAccountNo(request.getParameter("account"));
		userTO.setDob(request.getParameter("dob"));
		userTO.setEmail(request.getParameter("email"));
		userTO.setIfsc(request.getParameter("ifsc"));
		userTO.setMobile(request.getParameter("mobile"));
		userTO.setName(request.getParameter("name"));
		userTO.setPassword(request.getParameter("password"));
		System.out.println("Parameters set");
		System.out.println(userTO);
		try {
			UserBO.validateAndStore(userTO);
			System.out.println("Validation Successful. Redirecting to login.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.do");
			request.setAttribute("successMsg", "Registration was successful");
			requestDispatcher.forward(request, response);
		} catch(Exception e) {
			System.out.println("Validation Failed");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.do");
			request.setAttribute("errorMsg", e.getMessage());
			requestDispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost method of RegistrationController");
		doGet(request,response);
	}

}
