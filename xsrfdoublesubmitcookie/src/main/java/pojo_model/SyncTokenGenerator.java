package pojo_model;

import java.util.UUID;

/**
 * This POJO (Plain Old Java Object), or model object, is used to generate the token required by the LoginController.
 * 
 * This model object takes the user's session id sent by the LoginController to create an unique string by appending
 * an unique randomly generated string to the said session id.
 * 
 * @author Karawalaya - Isuru Samarasekara
 * @since 2019-05-17
 */
public class SyncTokenGenerator {
	
	  public static String generateSyncToken(String userSesID) {
	    return userSesID + "." + getRandomString();
	  }

	  private static String getRandomString() {
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	  }
}
