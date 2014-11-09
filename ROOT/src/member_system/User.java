package member_system;

import org.json.simple.JSONObject;



public class User  {
	
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
	
	public User(String username,String password)
	{
		this.username = username;
		this.password = password;
		this.sessionID = null;
		this.profile = null;
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
	
	public void setSessionId(String sessionId)
	{
		this.sessionID = sessionId;
	}
	
	
	
	@Override
	public String toString()
	{
		String allString;
		
		String name = String.format("username : %s\n", this.username);
		String password = String.format("password : %s\n", this.password);
		String sessionId = String.format("sessionId : %s\n", this.sessionID);
		String profileString = null;
		
		
		if(this.profile!=null)
		{	
			profileString = this.profile.toString();
		}
		
		allString = name+password+sessionId+profileString;
		
		return allString;
	}

	
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		
		JSONObject json = new JSONObject();
		Profile profile = this.getProfile();
		
		json.put("username",this.getUsername());
		json.put("password", "-----------------------");
		json.put("sessionId",this.getSessionID());
		json.put("profile", profile.toJSONObject());
		
		return json;
	}

}
