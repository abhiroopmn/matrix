package matrix.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        System.out.println("Inside constructor of MainController");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inside init method of MainController");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Inside destroy method of MainController");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet method of MainController");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost method of MainController");
		String requested_URI = request.getHeader("referer");
		String request_URI = request.getRequestURI();
		System.out.println("Requested URI: "+requested_URI);
		System.out.println("Request_URI: "+request_URI);
		if(request_URI.contains("LoginController")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginController");
			System.out.println("Forwarding to LoginController");
			requestDispatcher.forward(request, response);
		}
		else if(request_URI.contains("Home")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			System.out.println("Forwarding to index.html");
			requestDispatcher.forward(request, response);
		}
		else if(request_URI.contains("Login")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			System.out.println("Forwarding to login.html");
			requestDispatcher.forward(request, response);
		}
		else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			System.out.println("Forwarding to login.html");
			requestDispatcher.forward(request, response);
		}
		
	}

}
