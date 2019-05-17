package pojo_model;

import java.util.function.Function;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * This POJO (Plain Old Java Object), or model object, is used to generate cookies.
 * 
 * It creates cookies based on, 
 * either the session id (session id is derived using the session object) of the user or the unique token,
 * both sent by the Login Controller.
 * 
 * @author Karawalaya - Isuru Samarasekara
 * @since 2019-05-17
 */
public class CookieGenerator {
	public static final Function<HttpSession, Cookie> SESSION_ID_COOKIE = new Function<HttpSession, Cookie>() {
		public Cookie apply(HttpSession userSession) {
			return new Cookie("userSesID", userSession.getId());
		}
	};
	
	public static final Function<String, Cookie> SYNC_TOKEN_COOKIE = new Function<String, Cookie>() {
		public Cookie apply(String synchronizationToken) {
			return new Cookie("syncToken", synchronizationToken);
		}
	};
}