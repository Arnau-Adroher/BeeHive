package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ManageUsers;
import models.User;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/GetIsFollowing")
public class GetIsFollowing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIsFollowing() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ManageUsers userManager = new ManageUsers();

		User otherUser = (User) session.getAttribute("otherUser");
		User user = (User) session.getAttribute("user");

		if(user != null) {
			otherUser.setIsFollowed(userManager.isFollowed(user.getId(), otherUser.getId()));	
			request.setAttribute("anon", false);
		}else {
			request.setAttribute("anon", true);
		}

		session.setAttribute("otherUser", otherUser);
		/*if (session != null || user != null) {
			ManageUsers userManager = new ManageUsers();
			user = userManager.getUser(user.getUserName());
			userManager.finalize();
		}*/
		request.setAttribute("otherUser",otherUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewIsFollowing.jsp"); 
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
