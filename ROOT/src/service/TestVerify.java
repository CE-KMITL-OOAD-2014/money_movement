package service;

import member_system.User;
import member_system.VerifyAble;
import member_system.VerifyManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_SelectUser;




@RestController
@RequestMapping(value="/verify")
public class TestVerify {

	@RequestMapping("")
	public String checkData(
			@RequestParam(value="username") String username, 
			@RequestParam(value="sessionId")String sessionId
			)
	{
		User user = new User(username,null,sessionId,null);
		VerifyAble verify = new VerifyManager(new SQL_SelectUser());
		
		try
		{
			boolean check = verify.verify(user);
			if(check)
			{
				return "Verify complete";
			}
			else
			{
				return "Fail";
			}
		}
		catch(Exception ex)
		{
			return ex.toString()+ex.getMessage()+ex.getLocalizedMessage();
		}
		
		
	}
	
}
