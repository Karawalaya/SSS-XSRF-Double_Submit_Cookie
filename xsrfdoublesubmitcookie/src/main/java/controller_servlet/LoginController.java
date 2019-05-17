package controller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_service.LoginDAO;
import pojo_model.CookieFunctions;
import pojo_model.CookieGenerator;
import pojo_model.SyncTokenGenerator;
import pojo_model.User;

/**
 *
 *
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 *
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("username"), request.getParameter("password"));
		
		if (LoginDAO.isValid(user)) {
			HttpSession userSession = request.getSession(true);
			userSession.setAttribute("sessionUserName", user.getUsername());
			
			String userSessionID = userSession.getId();
			
			String synchronizationToken = SyncTokenGenerator.generateSyncToken(userSessionID);
			
			response.addCookie(CookieGenerator.SESSION_ID_COOKIE.apply(userSession));
			response.addCookie(CookieGenerator.SYNC_TOKEN_COOKIE.apply(synchronizationToken));

			response.sendRedirect("/xsrfdoublesubmitcookie/views/dashboard.jsp");
		}
	    else {
	    	response = CookieFunctions.cookiesInvalidate(response);
	    	
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect Username or Password!');");
			out.println("location='/xsrfdoublesubmitcookie/views/login.jsp';");
			out.println("</script>");
	    };
	}

}
