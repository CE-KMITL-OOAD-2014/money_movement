package manage_incomeoutlay;

import java.util.ArrayList;
import java.util.Date;

import member_system.User;
import member_system.VerifyAble;
import connect_database.SelectIncomeOutlay;

public class GetIncomeOutlayManager {
	
	private SelectIncomeOutlay selectIncomeOutlay;
	private VerifyAble verifyAble;
	
	public GetIncomeOutlayManager(SelectIncomeOutlay selectIncomeOutlay,
			VerifyAble verifyAble) {
		this.selectIncomeOutlay = selectIncomeOutlay;
		this.verifyAble = verifyAble;
	}
	
	public ArrayList<IncomeOutlay> getIncomeOutlay(User user,Date startDate,Date stopDate) throws Exception
	{
		boolean check=this.verifyAble.verify(user);
		
		if(check)
		{
			if(startDate==null )
			{
				startDate = new Date(0, 0, 1);
				
			}
			if(stopDate==null)
			{
				stopDate = new Date(9999-1900,11,31);
			}

			return this.selectIncomeOutlay.selectIncomeOutlay(user, startDate, stopDate);
		}
		else
		{
			throw(new Exception("Plese login"));	
		}
	}
	
	
	
	public ArrayList<IncomeOutlay> getIncomeOutlayWithJob(User user,Date startDate,Date stopDate) throws Exception
	{
		boolean check=this.verifyAble.verify(user);
		
		if(check)
		{
			if(startDate==null )
			{
				startDate = new Date(0, 0, 1);
				
			}
			if(stopDate==null)
			{
				stopDate = new Date(9999-1900,11,31);
			}

			return this.selectIncomeOutlay.selectIncomeOutlayWithJob(user.getProfile().getJob(), startDate, stopDate);
		}
		else
		{
			throw(new Exception("Plese login"));	
		}
	}
	
	
	
	
}
