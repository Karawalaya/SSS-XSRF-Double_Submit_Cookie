package controller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
public class TransferenceController extends HttpServlet {
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
		HttpSession userSession = request.getSession(false);
		String sessionUserName = (String) userSession.getAttribute("sessionUserName");
		if (null == sessionUserName) {
			request.setAttribute("Error", "Session has ended.  Please login.");
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You cannot go back!');");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		
		String clientHiddenToken = request.getParameter("hiddenTokenField");
		
		if (CookieFunctions.tokenValidate(clientHiddenToken, request)) {
			response.getWriter().append("Sucessfully Transfered!");
		}
		else {
//			response = CookieFunctions.cookiesInvalidate(response);
//			userSession.removeAttribute("sessionUserName");
//			userSession.invalidate();
//			
//			PrintWriter out = response.getWriter();
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('Transfer Unsuccessfull!');");
//			out.println("location='/xsrfdoublesubmitcookie/views/login.jsp';");
//			out.println("</script>");
			
			response.getWriter().append("Transfer Unsuccessful!");
		}
	}

}
