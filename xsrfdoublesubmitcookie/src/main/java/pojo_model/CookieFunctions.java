package pojo_model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieFunctions {
	
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
	
	public static HttpServletResponse cookiesInvalidate(HttpServletResponse response) {
		Cookie sessionCookieRemove = new Cookie("userSesID", "");
		sessionCookieRemove.setMaxAge(0);
		response.addCookie(sessionCookieRemove);
		
		Cookie tokenCookieRemove = new Cookie("syncToken", "");
		tokenCookieRemove.setMaxAge(0);
		response.addCookie(tokenCookieRemove);
		
		return response;
	}
}