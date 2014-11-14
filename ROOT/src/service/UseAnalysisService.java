package service;


import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.GetIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyManager;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import analysis_and_compare.AnalysisManager;
import analysis_and_compare.FactoryAnalysisManager;
import analysis_and_compare.ResultAnalysis;
import sql_connect_database.SQL_SelectIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import framework_azure.ConvertDate;

@RestController
@RequestMapping("/useanalysis")
public class UseAnalysisService {
	
	@RequestMapping("")
	public byte[] getUseAnalysis(
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
			
			GetIncomeOutlayManager getIncome = new GetIncomeOutlayManager(new SQL_SelectIncomeOutlay(), new VerifyManager(new SQL_SelectUser()));
			
			ArrayList<IncomeOutlay> listIncomeOutlay = getIncome.getIncomeOutlay(user, startDate, stopDate);
			
			FactoryAnalysisManager factory = new FactoryAnalysisManager();
			
			AnalysisManager analysis =  factory.getUseAnalysisManager();
			
			ResultAnalysis resultAnalysis = analysis.analysis(user, listIncomeOutlay);
			
			status = Status.complete;
			data = resultAnalysis.toJSONObject();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = Status.error;
			message = String.format("%s\n%s\n%s\n",ex.toString(),ex.getMessage(),ex.getCause() );
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
		
		
	}

}
