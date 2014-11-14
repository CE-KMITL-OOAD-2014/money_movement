package service;

import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.GetIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_SelectIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import connect_database.SelectIncomeOutlay;
import framework_azure.ConvertDate;

@RestController
@RequestMapping(value="/getincomeoutlay")
public class GetSelectIncomeOutlayService {

	@RequestMapping(value="")
	public byte[] getIncomeOutlay(
			@RequestParam(value="username")String username,
			@RequestParam(value="sessionId")String sessionId,
			@RequestParam(value="startsavedate",defaultValue="null",required=false)String startSaveDateString,
			@RequestParam(value="stopsavedate",defaultValue="null",required=false)String stopSaveDateString
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		try
		{
			
			Date startDate=null;
			Date stopDate=null;
			
			User user = new User(username, null, sessionId, null);
			
			if(startSaveDateString.compareTo("null")==0)
			{
				startDate = null;
			}
			else
			{
				startDate = ConvertDate.ChangeYearMonthDate(startSaveDateString);
			}
			if(stopSaveDateString.compareTo("null")==0)
			{
				stopDate =null;
			}
			else
			{
				stopDate = ConvertDate.ChangeYearMonthDate(stopSaveDateString);
			}
			
			GetIncomeOutlayManager getIncomeOutlay = new GetIncomeOutlayManager(new SQL_SelectIncomeOutlay(),new VerifyManager(new SQL_SelectUser()));
			ArrayList<IncomeOutlay> list =  getIncomeOutlay.getIncomeOutlay(user, startDate, stopDate);
			
			JSONArray jsonArray = new JSONArray();
			
			for(int i=0;i<list.size();i++)
			{
				JSONObject temJson = list.get(i).toJSONObject();
				jsonArray.add(temJson);
			}
			data = new JSONObject();
			data.put("incomeoutlay", jsonArray);
			status = Status.complete;
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = Status.error;
			message = String.format("%s\n%s\n%s", ex.toString(),ex.getMessage(),ex.getCause());
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
		
		
	}
	
}
