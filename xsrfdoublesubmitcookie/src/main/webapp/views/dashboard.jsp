<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--
This is the Dashboard of the logged in customer.
From here the user can navigate to different services provided by the web application.
For now, the given two links, both, are directed to money transference service.

From the given two links, one link  directs the user to the legitimate transference form where depending on whther the
correct details are inputed, the service will prevail and transfer the amount.

The other link directs the user to the illegitimate transference form where it is forged by an attacker who is trying to get the user
to execute a request to the server to transfer money, unbeknown to the user.

-->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="/xsrfdoublesubmitcookie/resrcs/css&js/customized02.css">
		<link rel="stylesheet" href="/xsrfdoublesubmitcookie/resrcs/css&js/bootstrap/css/bootstrap.css">

		<title>Dashboard Page</title>
	</head>
	
	<body>
		<%
			response.setHeader("Cache-Control","no-cache, must-revalidate"); //Forces caches to obtain a new copy of the page from the origin server
			response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
			response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
			response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
			
			if(session.getAttribute("sessionUserName") == null)
				response.sendRedirect("/xsrfdoublesubmitcookie/views/login.jsp");
		%>

		<h2 align="center">Anti-XSRF Bank</h2>
		<p><i>This is considered the Login page for Registered Customers.
				</br>
			  The customer MUST enter his/her credentials (required) and click the 'Sign In' button to receive the bank's services.
		   </i>
		</p>
		<h2 align="center">Dashboard</h2>

		<div class="container">
			<!-- Link directed to the legitimate transference form -->
			<a class="nav-link" href="/xsrfdoublesubmitcookie/views/legitimateForm.jsp" target="_blank"><button style="border-radius: 25px">Act as the legal user</button></a>
			<!-- Link directed to the illegitimate transference form -->
			<a class="nav-link" href="/xsrfdoublesubmitcookie/forgerViews/fabricatedForm.html" target="_blank"><button style="border-radius: 25px">Act as the forger</button></a>
		</div>
		<form action="/xsrfdoublesubmitcookie/Logout">
			<button type="submit" style="border-radius: 25px; background-color: #0000a0">Logout</button>
		</form>
	</body>
</html>