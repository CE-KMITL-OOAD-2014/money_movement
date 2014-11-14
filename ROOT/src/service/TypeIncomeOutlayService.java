package service;

import java.util.ArrayList;

import manage_incomeoutlay.TypeOfUse;
import member_system.User;
import member_system.VerifyAble;
import member_system.VerifyManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_SelectTypeIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import connect_database.SelectTypeIncomeOutlay;
import connect_database.SelectUser;

@RestController
@RequestMapping(value="/typeincomeoutlay")
public class TypeIncomeOutlayService {
	
	@RequestMapping(value="")
	public byte[] getTypeIncomeOutlay(
			@RequestParam(value="username")String username,
			@RequestParam(value="sessionId")String sessionId
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null;
		ArrayList<TypeOfUse> list = new ArrayList<TypeOfUse>();
		try
		{
			User user = new User(username, null, sessionId, null);
			
			SelectUser selectUser = new SQL_SelectUser();
			VerifyAble verify = new VerifyManager(selectUser);
			
			if(verify.verify(user))
			{
				SelectTypeIncomeOutlay selectTypeIncomeOutlay = new SQL_SelectTypeIncomeOutlay();
				list = selectTypeIncomeOutlay.selectTypeIncomeOutlay(user);
				JSONArray jsonArray = new JSONArray();
				
				for(int i=0;i<list.size();i++)
				{
					jsonArray.add(list.get(i).toJSONObject());
				}
				status = Status.complete;
				data  = new JSONObject();
				data.put("typeincomeoutlay", jsonArray);
			}
			else
			{
				status = Status.error;
				message = "Plese login ";
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = Status.error;
			message = ex.toString() + ex.getMessage() + ex.getLocalizedMessage();
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			
			
			
			return returnJson.toJSONByteUTF8();
		}
	}
	
	
}
