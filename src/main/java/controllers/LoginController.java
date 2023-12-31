package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageLogin;
import managers.ManageUsers;

import models.Login;
import models.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.print("LoginController: ");
		ManageLogin manager = new ManageLogin();
		ManageUsers userManager = new ManageUsers();
		Login login = new Login();
		
	    try {
			
			boolean[] errors = login.getError();
			BeanUtils.populate(login, request.getParameterMap());
			if (manager.isComplete(login)) {
				boolean check = manager.checkCredentials(login.getUserName(), login.getPwd(), errors);
				System.out.printf("check: %b", check);
				if(check) {
					System.out.println("login OK, forwarding to ViewLoginDone ");
					HttpSession session = request.getSession();
					User user = userManager.getUser(login.getUserName());
				
					session.setAttribute("user",user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginDone.jsp");
					dispatcher.forward(request, response);
					manager.finalize();					
				}
				else {
				     
					System.out.println("user is not logged, forwarding to ViewLoginForm ");
				    request.setAttribute("login",login);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
				    dispatcher.forward(request, response);
			    	
			    }
		    } 
			else {
		     
				System.out.println("user is not logged, forwarding to ViewLoginForm ");
			    request.setAttribute("login",login);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
			    dispatcher.forward(request, response);
		    	
		    }
	    }
		catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	    
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

