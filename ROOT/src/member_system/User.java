package member_system;

public class User {
	
	private String username;
	private String password;
	private String sessionID;
	private Profile profile;
	
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getSessionID()
	{
		return this.sessionID;
	}
	public Profile getProfile()
	{
		return this.profile;
	}

}
