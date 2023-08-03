package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageBrunzits;
import models.Brunzit;
import models.User;

/**
 * Servlet implementation class AddTweetFromUser
 */
@WebServlet("/DislikeBrunzit")
public class DislikeBrunzit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DislikeBrunzit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ManageBrunzits brunzitManager = new ManageBrunzits();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

     
        if (session != null || user != null) {
                
             brunzitManager.dislike(user.getId(), Integer.parseInt(request.getParameter("bid")));
             brunzitManager.finalize();
        } 
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}