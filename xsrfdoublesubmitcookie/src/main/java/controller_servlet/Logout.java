package controller_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo_model.CookieFunctions;

/**
 *
 *
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieFunctions.cookiesInvalidate(response);
		
		HttpSession userSession = request.getSession(false);
		userSession.removeAttribute("sessionUserName");
		userSession.invalidate();
		
		response.sendRedirect("/xsrfdoublesubmitcookie/views/login.jsp");
	}

	/**
	 *
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}