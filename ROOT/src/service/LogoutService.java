package service;

import member_system.LogoutAble;
import member_system.LogoutManager;
import member_system.User;
import member_system.VerifyManager;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_SelectUser;
import sql_connect_database.SQL_UpdateUserSessionId;


@RestController
@RequestMapping(value="/logout")
public class LogoutService 
{

	@RequestMapping("")
	public byte[] logout(
			
			@RequestParam("username") String username,
			@RequestParam("sessionId")String sessionId
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		try
		{
			User user = new User(username, null, sessionId, null);
			LogoutAble logout = new LogoutManager(new VerifyManager(new SQL_SelectUser()), new SQL_UpdateUserSessionId());
			
			boolean check = logout.logout(user);
			
			if(check)
			{
				status = Status.complete;
			}
			else
			{
				status = Status.error;
				message = "Plese login ";
			}
			
		}
		catch(Exception ex)
		{
			status = Status.error;
			message = String.format("%s\n%s\n%s\n", ex.toString(),ex.getMessage(),ex.getCause());
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
	}
	
}
