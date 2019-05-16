package controller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String clientHiddenToken = request.getParameter("hiddenTokenField");
	    System.out.println("****  " + clientHiddenToken);
		if (CookieFunctions.tokenValidate(clientHiddenToken, request)) {
			response.getWriter().append("Sucessfully Transfered!");
		}
		else {
			response = CookieFunctions.cookiesInvalidate(response);
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Transfer Unsuccessfull!');");
			out.println("</script>");
			
			response.sendRedirect("/xsrfdoublesubmitcookie/views/login.jsp");
		}
	}

}
