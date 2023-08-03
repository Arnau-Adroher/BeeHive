package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
 * Servlet implementation class DelTweet
 */
@WebServlet("/DelBrunzit")
public class DelBrunzit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelBrunzit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Brunzit brunzit = new Brunzit();
		ManageBrunzits manager = new ManageBrunzits();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		try {
			if (session != null || user != null) {
				BeanUtils.populate(brunzit, request.getParameterMap());
				manager.deleteBrunzit(Integer.valueOf(request.getParameter("id")));
				manager.finalize();
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
