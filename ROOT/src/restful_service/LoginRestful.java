package restful_service;

import java.sql.SQLException;

import member_system.LoginManager;
import member_system.User;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import sql_connect_database.SQL_SelectUser;
import sql_connect_database.SQL_UpdateUserSessionId;




@RestController
@RequestMapping(value="/login")
public class LoginRestful {

	@RequestMapping(value="",method=RequestMethod.GET)
	
	public String loginAble(
			@RequestParam("username")String username,
			@RequestParam("password")String password
			)
	{
		LoginManager login = new LoginManager(new SQL_SelectUser(),new SQL_UpdateUserSessionId()); 
		User temUser = new User(username,password);
		User returnUser = null;
		
		try 
		{	
			returnUser = login.login(temUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(returnUser==null)
			{
				return "Login in fail";
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("username",returnUser.getUsername());
				json.put("sessionId",returnUser.getSessionID() );
				return  json.toJSONString();
			}
		}
		
		
	}
}