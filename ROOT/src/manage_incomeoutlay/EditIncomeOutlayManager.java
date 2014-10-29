package manage_incomeoutlay;

import member_system.User;
import member_system.VerifyAble;
import connect_database.UpdateIncomeOutlay;

public class EditIncomeOutlayManager {
	
	private UpdateIncomeOutlay updateIncomeOutlay;
	private VerifyAble verifyAble;
	
	public EditIncomeOutlayManager(UpdateIncomeOutlay updateIncomeOutlay,
			VerifyAble verifyAble) {
		
		this.updateIncomeOutlay = updateIncomeOutlay;
		this.verifyAble = verifyAble;
	}
	
	public boolean  editIncomeOutlay(User user,IncomeOutlay oldIncomeOutlay,IncomeOutlay newIncomeOutlay) throws Exception
	{
		boolean check = this.verifyAble.verify(user);
		if(check)
		{
			return updateIncomeOutlay.updateIncomeOutlay(oldIncomeOutlay, newIncomeOutlay);
		}
		else
		{
			return false;
		}
	}
}
