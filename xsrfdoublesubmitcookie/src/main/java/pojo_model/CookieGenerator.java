package pojo_model;

import java.util.function.Function;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

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