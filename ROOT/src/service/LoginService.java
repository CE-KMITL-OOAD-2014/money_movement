package service;

import java.sql.SQLException;

import member_system.LoginManager;
import member_system.Profile;
import member_system.User;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import sql_connect_database.SQL_SelectUser;
import sql_connect_database.SQL_UpdateUserSessionId;

@RestController
@RequestMapping(value="/login")
public class LoginService {

	@RequestMapping(value="",method=RequestMethod.GET)
	
	public byte[] loginAble(
			@RequestParam("username")String username,
			@RequestParam("password")String password
			)
	{
		LoginManager login = new LoginManager(new SQL_SelectUser(),new SQL_UpdateUserSessionId()); 
		User temUser = null;
		User returnUser = null;
		Status status = null;
		String message = "";
		JSONObject data = null;
		
		try 
		{	
			password = EncodePassword.hash(password);
			
			temUser = new User(username,password);
			returnUser = login.login(temUser);
			
			if(returnUser==null)
			{
				status = Status.error;
			}
			else
			{
				status = Status.complete;
				data = returnUser.toJSONObject();
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			status = Status.error;
			message = String.format("%s\n%s\n%\n",e.toString(),e.getMessage(),e.getMessage());
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
	}
}
