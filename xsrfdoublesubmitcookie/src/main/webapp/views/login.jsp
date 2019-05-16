<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- This is the Login page. This contains the login portal for the registered user -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="/xsrfdoublesubmitcookie/resrcs/css&js/customized02.css">
		
		<title>Login Page</title>
	</head>
	
	<body>
		<h2 align="center">Anti-XSRF Bank</h2>
		<p><i>This is considered the Login page for Registered Customers.
				</br>
			  The customer MUST enter his/her credentials (required) and click the 'Sign In' button to receive the bank's services.
		   </i>
		</p>
		<!-- 
			FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
	 	-->
   		<form style="align:center" action="/xsrfdoublesubmitcookie/LoginController" method="post">
			<div class="imgcontainer">
				<img src="/xsrfdoublesubmitcookie/resrcs/imgs/login_image.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label for="username"><b>Username</b></label>
				<input type="text" placeholder="Your Username" name="username" required>

				<label for="password"><b>Password</b></label>
				<input type="password" placeholder="Your Password" name="password" required>

				<button type="submit">Sign in</button>
			</div>
		</form>
	</body>
</html>