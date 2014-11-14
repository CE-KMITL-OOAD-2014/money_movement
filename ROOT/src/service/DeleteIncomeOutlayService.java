package service;

import java.util.Date;

import manage_incomeoutlay.DeleteIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyManager;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_DeleteIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import connect_database.DeleteIncomeOutlay;
import framework_azure.ChangeForTomcat;
import framework_azure.ConvertDate;


@RestController
@RequestMapping(value="/deleteincomeoutlay")

public class DeleteIncomeOutlayService {

	@RequestMapping(value="")
	public byte[] deleteIncomeOutlay(
			@RequestParam("username")String username,
			@RequestParam("sessionId")String sessionId,
			@RequestParam("owner")String owner,
			@RequestParam("nameincomeoutlay")String nameIncomeOutlay,
			@RequestParam("savedate")String saveDateString
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		
		nameIncomeOutlay = ChangeForTomcat.changeForThai(nameIncomeOutlay);
		
		
		try
		{
			boolean check;
			Date saveDate = ConvertDate.ChangeYearMonthDate(saveDateString);
			User user = new User(username,null, sessionId, null);
			IncomeOutlay incomeOutlay = new IncomeOutlay(owner, nameIncomeOutlay,0, saveDate, null, null);
			
			DeleteIncomeOutlayManager deleteIncome = new DeleteIncomeOutlayManager(new VerifyManager(new SQL_SelectUser()), new SQL_DeleteIncomeOutlay());

			check=deleteIncome.deleteIncomeOutlay(user, incomeOutlay);
		
			if(check)
			{
				status = Status.complete;
			}
			else
			{
				status = Status.error;
				message = "Plese login or check input";
			}
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
