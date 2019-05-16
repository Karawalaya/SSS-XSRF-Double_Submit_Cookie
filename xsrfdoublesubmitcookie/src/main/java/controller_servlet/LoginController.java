package controller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_service.LoginDAO;
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
		HttpSession userSession = request.getSession(true);
		User user = new User(request.getParameter("username"), request.getParameter("password"));
		
		if (LoginDAO.isValid(user)) {
			String userSessionID = userSession.getId();
			
			String synchronizationToken = SyncTokenGenerator.generateSyncToken(userSessionID);
			
			response.addCookie(CookieGenerator.SESSION_ID_COOKIE.apply(userSession));
//			Cookie cookie = CookieGenerator.SYNC_TOKEN_COOKIE.apply(synchronizationToken);
			response.addCookie(CookieGenerator.SYNC_TOKEN_COOKIE.apply(synchronizationToken));
//			System.out.println(cookie.getName().equals("syncToken") + " ==== " + cookie.getValue());
			response.sendRedirect("/xsrfdoublesubmitcookie/views/dashboard.jsp");
		}
	    else {
	    	userSession.invalidate();
	    	
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect Username or Password!');");
			out.println("location='/xsrfdoublesubmitcookie/views/login.jsp';");
			out.println("</script>");
	    };
	}

}
