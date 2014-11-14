package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import member_system.Profile;
import member_system.RegisterAble;
import member_system.RegisterManager;
import member_system.User;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import connect_database.InsertUser;
import framework_azure.ChangeForTomcat;
import sql_connect_database.SQL_InsertUser;

@RestController

@RequestMapping(value="/register")

public class RegisterService {
	@RequestMapping(value="")
	public byte[] register(@RequestParam("username")String username,
			@RequestParam("email")String email,
			@RequestParam("sex")String sex,
			@RequestParam("password")String password,
			@RequestParam("confirmPassword")String confirmPassword,
			@RequestParam("name")String name,
			@RequestParam("birthday")String birthday,
			@RequestParam("job")String job,
			@RequestParam("province")String province
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		
		name = ChangeForTomcat.changeForThai(name);
		province = ChangeForTomcat.changeForThai(province);
		
		
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(birthday,"-");
		
		while(token.hasMoreTokens())
		{
			list.add(token.nextToken());
		}
		int day,month,year;
		
		year = Integer.parseInt(list.get(0)); 
		month = Integer.parseInt(list.get(1));
		day = Integer.parseInt(list.get(2));
		
		Date birthDate = new Date(year-1900, month-1, day);
		
	
		
		Profile profile = new Profile(name,birthDate, job, sex, email, province);
		User user = null;
		
		
		InsertUser insertUser = new SQL_InsertUser();
		
		RegisterAble registerManaget = new RegisterManager(insertUser);
		
		try
		{
			password = EncodePassword.hash(password);
			user = new User(username, password, null, profile);
			 if( registerManaget.register(user)==null )
			 {
				 status = Status.error;
				 message = "Plese check your input";
			 }
			 else
			 {
				 status = Status.complete;
			 }
		}
		catch(Exception ex)
		{
			status = Status.error;
			message = ex.toString()+ex.getMessage()+ex.getLocalizedMessage();
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status,data, message); 
			return returnJson.toJSONByteUTF8();
		}		
		
	}
}
