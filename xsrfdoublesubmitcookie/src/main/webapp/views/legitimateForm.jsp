<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="/xsrfdoublesubmitcookie/resrcs/css&js/customized02.css">
		<link rel="stylesheet" href="/xsrfdoublesubmitcookie/resrcs/css&js/bootstrap/css/bootstrap.css">
		
		<title>Legitimate Form</title>
	</head>
	
<!-- 	<body onload="checkCookies()"> -->
	<body>
		<%
			response.setHeader("Cache-Control","no-cache, must-revalidate"); //Forces caches to obtain a new copy of the page from the origin server
			response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
			response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
			response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
			
			if(session.getAttribute("sessionUserName") == null)
				response.sendRedirect("/xsrfdoublesubmitcookie/views/login.jsp");
		%>
		
		<h2 align="center">Fill and Submit the below Money Transference Form!</h2>
		<!-- 
			FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
	 	-->
   		<form id="moneyTransferenceForm" style="align:center" name="moneyTransferenceForm" action="/xsrfdoublesubmitcookie/TransferenceController" method="post">
			<div class="container">
				<label for="accountNo"><b>Receiver Account</b></label>
				<input type="text" placeholder="Receiver's Account Number" name="accountNo" required>

				<label for="transferAmount"><b>Transfer Amount</b></label>
				<input type="text" placeholder="Amount to Transfer (in LKR)" name="transferAmount" required>

				<button type="submit" style="border-radius: 25px">Transfer</button>
			</div>
		</form>
		<form action="/xsrfdoublesubmitcookie/Logout">
			<button type="submit" style="width: 50%; border-radius: 25px; background-color: #0000a0; align: center;">Logout</button>
		</form>

		<script type="text/javascript">
			function checkCookies() {
				  var text = "";
	
				  if (navigator.cookieEnabled == true) {
				    text = "Cookies are enabled.";
				  } else {
				     text = "Cookies are not enabled.";
				  }
				  alert(text);
			}
			
			function getCookieValueOf(cookieName) {
		    var name = cookieName + "=";
		    var decodedCookie = decodeURIComponent(document.cookie);
		    var cookieArray = decodedCookie.split(';');
		    for(var i = 0; i < cookieArray.length; i++) {
		        var cook = cookieArray[i];
		        while (cook.charAt(0) == ' ') {
		        	cook = cook.substring(1);
		        }
		        if (cook.indexOf(name) == 0) {
		            return cook.substring(name.length, cook.length);
		        }
		    }
		    return "";
		}
	
		function insertCookieValueToForm() {
		    var cookieValue = getCookieValueOf("syncToken");

		    if (cookieValue != "") {
		    	var input = document.createElement("INPUT");
		    	input.setAttribute("type", "hidden");
		    	input.setAttribute("name", "hiddenTokenField");
		    	input.setAttribute("value", cookieValue);
		    	document.getElementById("moneyTransferenceForm").appendChild(input);
		    }
		}
	
		insertCookieValueToForm();
		</script>
	</body>
</html>