package dao_service;

import pojo_model.User;

/**
 * This DAO (Database Access Object), or Service object, is used to hold the user credentials and validate login users.
 * 
 * In a practical scenario, this will contain the code where it accesses the database and retrieves a particular
 * credential to check and verify a user.
 * 
 * This service object validates the user inputted credentials against the hardcoded credentials.
 * 
 * @author Karawalaya - Isuru Samarasekara
 * @since 2019-05-17
 */
public class LoginDAO {
	  private static final String USERNAME = "LegitBrotherDoubleCookie";
	  private static final String PASSWORD = "doubleCookieStuff";

	  public static boolean isValid(User user) {
	    return USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword());
	  }
}