package member_system;

public class User {
	
	private String username;
	private String password;
	private String sessionID;
	private Profile profile;
	
	public User(String username,String password,String sessionId,Profile profile)
	{
		this.username = username;
		this.password = password;
		this.sessionID = sessionId;
		this.profile = profile;
	}
	
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
	
	@Override
	public String toString()
	{
		String allString;
		
		String name = String.format("username : %s\n", this.username);
		String password = String.format("password : %s\n", this.password);
		String sessionId = String.format("sessionId : %s\n", this.sessionID);
		String profile = this.profile.toString();
		allString = name+password+sessionId+profile;
		
		return allString;
	}

}
