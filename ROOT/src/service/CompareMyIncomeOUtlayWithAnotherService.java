package service;

import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.GetIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.Profile;
import member_system.User;
import member_system.VerifyManager;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import analysis_and_compare.CompareManager;
import analysis_and_compare.FactoryCompareManager;
import analysis_and_compare.ResultCompare;
import connect_database.SelectUser;
import sql_connect_database.SQL_SelectIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import framework_azure.ConvertDate;

@RestController
@RequestMapping("/comparemyincomeoutlaywithanother")
public class CompareMyIncomeOUtlayWithAnotherService {
	
	@RequestMapping("")
	public byte[] getResultCompareMyIncomeOutlayWithAnother(
			@RequestParam(value="username")String username,
			@RequestParam(value="sessionId")String sessionId,
			@RequestParam(value="startsavedate",defaultValue="null",required=false)String startSaveDateString,
			@RequestParam(value="stopsavedate",defaultValue="null",required=false)String stopSaveDateString		
			) throws Exception
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		
		String nullString = "null";
		
		try
		{
			User user = new User(username, null, sessionId, null);
		
			Date startDate = null;
			Date stopDate = null;
		
			SelectUser select = new SQL_SelectUser();
		
			Profile profile = select.selectUser(user).getProfile();
		
			User temUser = new User(username,null,sessionId,profile);
	
			if(startSaveDateString.compareTo(nullString)==0)
			{
				startDate = null;
			}
			else
			{
				startDate = ConvertDate.ChangeYearMonthDate(startSaveDateString);
			}
		
			if(stopSaveDateString.compareTo(nullString)==0)
			{
				stopDate = null;
			}
			else
			{
				stopDate = ConvertDate.ChangeYearMonthDate(stopSaveDateString);
			}
		
			GetIncomeOutlayManager getIncomeOutlay = new GetIncomeOutlayManager(new SQL_SelectIncomeOutlay(),new VerifyManager(new SQL_SelectUser()));
		
			ArrayList<IncomeOutlay> myList = getIncomeOutlay.getIncomeOutlay(user, startDate, stopDate);
			ArrayList<IncomeOutlay> anotherList = getIncomeOutlay.getIncomeOutlayWithJob(temUser, startDate, stopDate);
			
			FactoryCompareManager factory = new FactoryCompareManager();
			CompareManager compareIncomeOutlayWithAnother = factory.getCompareMyIncomeWithAnotherIncomeByWork();
			
			ResultCompare result = compareIncomeOutlayWithAnother.compare(temUser, myList, anotherList);
			
			data = result.toJSONObject();
			status = Status.complete;
			
		//	System.out.println(result.toJSONObject().toJSONString());
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = Status.error;
			message = String.format("%s\n%s\n%s\n",ex.toString(),ex.getMessage(),ex.getCause());
		}
		
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
	}

}
