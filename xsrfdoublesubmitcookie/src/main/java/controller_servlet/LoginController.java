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
 * This LoginController is the servlet designed to handle the login functionality.
 * 
 * This controler checks whether the user credentials are valid, sets the session parameters, generates a unique
 * token, creates two cookies - one using the session id and another using the generated token, sets those
 * cookies to the response and sends them to the client browser.
 * 
 * At the end of the function, 
 * if the user is authenticated, he/she is directed to the dashboard.jsp,
 * else, he/she is directed to the login.jsp.
 * 
 * @author Karawalaya - Isuru Samarasekara
 * @since 2019-05-17
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Post method implementation to handle data sent via the method 'post'.
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
