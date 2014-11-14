package service;

import java.util.Date;

import manage_incomeoutlay.AddIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;
import member_system.VerifyAble;
import member_system.VerifyManager;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sql_connect_database.SQL_InsertIncomeOutlay;
import sql_connect_database.SQL_InsertTypeIncomeOutlay;
import sql_connect_database.SQL_SelectTypeIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import connect_database.InsertIncomeOutlay;
import connect_database.SelectUser;
import framework_azure.ChangeForTomcat;
import framework_azure.ConvertDate;

@RestController
@RequestMapping(value="/addincomeoutlay")
public class AddIncomeOutlayService {

	@RequestMapping(value="")
	public byte[] addIncomeOutlay(
			@RequestParam(value="username") String username,
			@RequestParam(value="sessionId") String sessionId,
			@RequestParam(value="owner") String owner,
			@RequestParam(value="nameincomeoutlay") String nameIncomeOutlay,
			@RequestParam(value="amount") String amountString,
			@RequestParam(value="savedate") String saveDateString, 
			@RequestParam(value="comment") String comment,
			@RequestParam(value="nametype") String nameType,
			@RequestParam(value="type") String type,
			@RequestParam(value="priority") String priority
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		nameIncomeOutlay = ChangeForTomcat.changeForThai(nameIncomeOutlay);
		comment = ChangeForTomcat.changeForThai(comment);
		nameType = ChangeForTomcat.changeForThai(nameType);
		
		try
		{
			boolean check; 
			double amount = Double.parseDouble(amountString);
			Date saveDate = ConvertDate.ChangeYearMonthDate(saveDateString);
			
			User user = new User(username, null, sessionId, null);
			TypeOfUse typeOfUse = new NomalTypeOfUser(nameType, type, priority);
			
			System.out.println(typeOfUse.toString());
			
			
			IncomeOutlay incomeOutlay = new IncomeOutlay(owner, nameIncomeOutlay, amount, saveDate, typeOfUse, comment);
			
			
			VerifyAble verifyManager = new VerifyManager(new SQL_SelectUser());		
			InsertIncomeOutlay insertIncome = new SQL_InsertIncomeOutlay( 
				new SQL_SelectTypeIncomeOutlay(),
				new SQL_InsertTypeIncomeOutlay()
				);			
			
			AddIncomeOutlayManager addIncomeOutlay = new AddIncomeOutlayManager(insertIncome, verifyManager);
			
			
			if(addIncomeOutlay.addIncomeOutlay(user, incomeOutlay))
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
