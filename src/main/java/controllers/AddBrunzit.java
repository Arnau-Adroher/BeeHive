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
@WebServlet("/AddBrunzit")
public class AddBrunzit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBrunzit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brunzit brunzit = new Brunzit();
        ManageBrunzits brunzitManager = new ManageBrunzits();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        try {
            if (session != null || user != null) {
                BeanUtils.populate(brunzit, request.getParameterMap());
            	brunzit.setUid(user.getId());
                brunzit.setUserName(user.getUserName());
                brunzit.setPostDateTime(new Timestamp(System.currentTimeMillis()));
                boolean isFlash = Boolean.parseBoolean(request.getParameter("isFlash"));
                brunzit.setIsFlash(isFlash);
                brunzitManager.addBrunzit(brunzit);
                brunzitManager.finalize();
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
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