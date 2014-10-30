package manage_incomeoutlay;

import member_system.User;
import member_system.VerifyAble;
import member_system.VerifyManager;
import connect_database.InsertIncomeOutlay;

public class AddIncomeOutlayManager  {

	
	private InsertIncomeOutlay insertIncomeOutlay; 
	private VerifyAble verify;
	
	public AddIncomeOutlayManager(InsertIncomeOutlay insertIncomeOutlay,VerifyAble verify) 
	{	
		// TODO Auto-generated constructor stub
		this.insertIncomeOutlay = insertIncomeOutlay;
		this.verify = verify;
	}
	
	public boolean addIncomeOutlay(User user,IncomeOutlay incomeOutlay) throws Exception
	{
		boolean checkVerify = this.verify.verify(user);
		if(checkVerify)
		{
			boolean check;
			check = this.insertIncomeOutlay.insertIncomeOutlay(incomeOutlay);
			return check;
		}
		else
		{
			return false;
		}
	}
}
