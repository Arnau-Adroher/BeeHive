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
@WebServlet("/GetOtherUserInfo")
public class GetOtherUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOtherUserInfo() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewOtherUserInfo.jsp"); 
		
		otherUser.setFollowers(userManager.getNumberFollowers(otherUser.getId()));
		request.setAttribute("otherUser",otherUser);
		request.setAttribute("user",user);
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
