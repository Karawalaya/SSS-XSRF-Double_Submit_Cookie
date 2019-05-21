package pojo_model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This POJO (Plain Old Java Object), or model object, is used to provide two basic functionalities to help the Servlets.
 * First is to validate the token and second is to remove cookies from the client browser.
 * 
 * @author Karawalaya - Isuru Samarasekara
 * @since 2019-05-17
 */
public class CookieFunctions {
	
	/**
	 * This method is written to validate the hidden token sent via the legitimate money transference form.
	 * @param clientHiddenToken This is the first parameter to tokenValidate method which is of type String.
	 * @param request  This is the second parameter to tokenValidate method which is of type HttpServletRequest.
	 * @return boolean This returns true if there is a matching cookie which has the name syncToken containing the clientHiddenToken as the value.
	 */
	public static boolean tokenValidate(String clientHiddenToken, HttpServletRequest request) {
//		Optional<String> cookieValue = Stream.of(request.getCookies()).filter(c -> c.getName().equalsIgnoreCase("syncToken")).map(Cookie::getValue).findFirst();
//	    String sycToken = cookieValue.get();
		
		if (clientHiddenToken == null) return false;
		
	    String cookieToken = null;
	    Cookie[] cookies = request.getCookies();
	    for(Cookie cookie : cookies) {
	    	if(cookie.getName().equals("syncToken")) {
	    		cookieToken = cookie.getValue();
	    		
//	    		System.out.println(cookieToken);
//	    		System.out.println(sycToken.equals(cookieToken));
	    	return clientHiddenToken.equals(cookieToken);
	    	}
	    }
	    return false;
	}
	
	/**
	 * This method is used to invalidate existing cookies in the browser.
	 * @param response This is the first parameter to cookiesInvalidate method which is of type HttpServletResponse.
	 * @return HttpServletResponse This returns the response with the overwritten cookies, with the same name as the 
	 * existing ones in the browser which are set to be destroyed as soon as the client browser receives them
	 */
	public static HttpServletResponse cookiesInvalidate(HttpServletResponse response) {
		Cookie sessionCookieRemove = new Cookie("userSesID", "");
		sessionCookieRemove.setMaxAge(0);
		response.addCookie(sessionCookieRemove);
		
		Cookie tokenCookieRemove = new Cookie("syncToken", "");
		tokenCookieRemove.setMaxAge(0);
		response.addCookie(tokenCookieRemove);
		
		return response;
	}
	
	/**
	 * This method is written to validate the session id of the user via sessionCookie.
	 * @param request  This is the first parameter to sessionValidationBySessionCookie method which is of type HttpServletRequest.
	 * @return boolean This returns true if there is a matching cookie which contains the session id of the client.
	 */
	public static boolean sessionValidationBySessionCookie(HttpServletRequest request) {
		String userSessionID = request.getSession(false).getId();

		if (userSessionID == null) return false;
		
	    String cookieSessionID = null;
	    Cookie[] cookies = request.getCookies();
	    for(Cookie cookie : cookies) {
	    	if(cookie.getName().equals("userSesID")) {
	    		cookieSessionID = cookie.getValue();

	    	return userSessionID.equals(cookieSessionID);
	    	}
	    }
	    return false;
	}
}