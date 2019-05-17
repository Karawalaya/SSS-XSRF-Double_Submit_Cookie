package dao_service;

import pojo_model.User;

public class LoginDAO {
//	  private static final String USERNAME = "LegitBrotherDoubleCookie";
//	  private static final String PASSWORD = "doubleCookieStuff";
	private static final String USERNAME = "abc";
	private static final String PASSWORD = "abc";

	  public static boolean isValid(User user) {
	    return USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword());
	  }
}
