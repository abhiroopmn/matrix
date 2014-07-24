package matrix.controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import matrix.bo.LoginBO;
import matrix.dao.LoginDAO;
import matrix.exceptions.DatabaseException;
import matrix.models.LoginTO;

/**
 * Servlet implementation class LoginControlle
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		System.out.println("Inside constructor of LoginController");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet method of LoginController");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost method of LoginController");
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String object = (String) enumeration.nextElement();
			System.out.println("["+object+":"+request.getParameter(object)+"]");
		}
		LoginTO loginTO = new LoginTO(request.getParameter("uname"),request.getParameter("password"));
		LoginBO loginBO = new LoginBO();
		try {
			loginBO.validate(loginTO);
			System.out.println("Login successful");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.do");
			HttpSession session = request.getSession();
			session.setAttribute("uname", loginTO.getUname());
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Login failed");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.do");
			request.setAttribute("error", e.getMessage());
			requestDispatcher.forward(request, response);
		}
	}
}
