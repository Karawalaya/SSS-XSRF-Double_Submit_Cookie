package pojo_model;

import java.util.UUID;

public class SyncTokenGenerator {
	
	  public static String generateSyncToken(String userSesID)
	  {
	    return userSesID + "." + getRandomString();
	  }

	  private static String getRandomString()
	  {
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	  }
}
