package service;

import java.util.Date;

import manage_incomeoutlay.EditIncomeOutlayManager;
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

import connect_database.UpdateIncomeOutlay;
import framework_azure.ChangeForTomcat;
import framework_azure.ConvertDate;
import sql_connect_database.SQL_InsertTypeIncomeOutlay;
import sql_connect_database.SQL_SelectIncomeOutlay;
import sql_connect_database.SQL_SelectTypeIncomeOutlay;
import sql_connect_database.SQL_SelectUser;
import sql_connect_database.SQL_UpdateIncomeOutlay;


@RestController
@RequestMapping(value="editincomeoutlay")
public class EditIncomeOutlayService {

	@RequestMapping(value="")
	public byte[] editIncomeOutlay(
			@RequestParam(value="username") String username,
			@RequestParam(value="sessionId") String sessionId,
			@RequestParam(value="owner") String owner,
			@RequestParam(value="nameincomeoutlay") String nameIncomeOutlay,
			@RequestParam(value="amount") String amountString,
			@RequestParam(value="savedate") String saveDateString, 
			@RequestParam(value="comment") String comment,
			@RequestParam(value="nametype") String nameType,
			@RequestParam(value="type") String type,
			@RequestParam(value="priority") String priority,
		
			@RequestParam(value="new_nameincomeoutlay") String newNameIncomeOutlay,
			@RequestParam(value="new_amount") String newAmountString,
			@RequestParam(value="new_savedate") String newSaveDateString, 
			@RequestParam(value="new_comment") String newComment,
			@RequestParam(value="new_nametype") String newNameType,
			@RequestParam(value="new_type") String newType,
			@RequestParam(value="new_priority") String newPriority
					
			)
	{
		Status status = null;
		String message = null;
		JSONObject data = null; 
		
		nameIncomeOutlay = ChangeForTomcat.changeForThai(nameIncomeOutlay);
		comment = ChangeForTomcat.changeForThai(comment);
		nameType = ChangeForTomcat.changeForThai(newType);
		
		newNameIncomeOutlay = ChangeForTomcat.changeForThai(newNameIncomeOutlay);
		newComment = ChangeForTomcat.changeForThai(newComment);
		newNameType = ChangeForTomcat.changeForThai(newNameType);
				
		try
		{
			User user = new User(username, null, sessionId, null);
			Date oldDate = ConvertDate.ChangeYearMonthDate(saveDateString);
			Date newDate = ConvertDate.ChangeYearMonthDate(newSaveDateString);
			double oldAmount = Double.parseDouble(amountString);
			double newAmount = Double.parseDouble(newAmountString);
			
			TypeOfUse oldTypeOfUse = new NomalTypeOfUser(nameType, type, priority);
			TypeOfUse newTypeOfUse = new NomalTypeOfUser(newNameType,newType, newPriority);
			
			IncomeOutlay oldIncomeOutlay = new IncomeOutlay(owner, nameIncomeOutlay, oldAmount, oldDate, oldTypeOfUse, comment);
			IncomeOutlay newIncomeOutlay = new IncomeOutlay(owner, newNameIncomeOutlay, newAmount, newDate, newTypeOfUse, newComment);
			
			UpdateIncomeOutlay updateIncomeOutlay = new SQL_UpdateIncomeOutlay(new SQL_SelectTypeIncomeOutlay(),new SQL_InsertTypeIncomeOutlay());
			VerifyAble verify = new VerifyManager(new SQL_SelectUser());
			EditIncomeOutlayManager editIncomeOutlay = new EditIncomeOutlayManager(updateIncomeOutlay, verify);
			
			boolean check = editIncomeOutlay.editIncomeOutlay(user, oldIncomeOutlay, newIncomeOutlay);
			
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
			message = String.format("%s\n%s\n%s\n",ex.toString(),ex.getMessage(),ex.getCause());
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}
		
		
		
	}
}
