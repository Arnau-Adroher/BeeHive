package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ManageUsers;
import models.Brunzit;
import models.User;

/**
 * Servlet implementation class dTcontroller
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		String newName = request.getParameter("name");
		String newDate = request.getParameter("birthDate");
		ManageUsers userManager = new ManageUsers();
		
		if (session != null || user != null) {
			if(newName != user.getName()) {
				userManager.changeName(newName, user.getId());
				user.setName(newName);
			}
			if(newDate != user.getBirthDate()) {
				userManager.changeBirthDate(newDate, user.getId());
				user.setBirthDate(newDate);
			}
			
			
					
			
		}
		userManager.finalize();
		
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewOwnProfile.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

