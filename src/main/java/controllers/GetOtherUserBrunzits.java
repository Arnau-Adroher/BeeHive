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

import managers.ManageBrunzits;
import models.Brunzit;
import models.User;

/**
 * Servlet implementation class dTcontroller
 */
@WebServlet("/GetOtherUserBrunzits")
public class GetOtherUserBrunzits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOtherUserBrunzits() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		List<Brunzit> brunzits = Collections.emptyList();
		User user = (User) session.getAttribute("user");
		User otherUser = (User) session.getAttribute("otherUser");

		ManageBrunzits brunzitManager = new ManageBrunzits();
		brunzits = brunzitManager.getUserBrunzits(otherUser.getId());
		if (user != null) {
			Integer uid = user.getId();
			
			for(Brunzit b: brunzits) {
				Integer bid = b.getId();
				b.setIsLiked(brunzitManager.isLiked(uid, bid));
			}
			
			request.setAttribute("anon", false);	
		}else {
			request.setAttribute("anon", true);	
		}
		brunzitManager.finalize();
			
		
		
		
		request.setAttribute("user", user);
		request.setAttribute("brunzits",brunzits);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewOtherBrunzits.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

