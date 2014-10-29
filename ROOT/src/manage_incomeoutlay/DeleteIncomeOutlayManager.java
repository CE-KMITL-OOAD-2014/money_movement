package manage_incomeoutlay;

import connect_database.DeleteIncomeOutlay;
import member_system.User;
import member_system.VerifyAble;

public class DeleteIncomeOutlayManager {
	
	private DeleteIncomeOutlay deleteIncomeOutlay;
	private VerifyAble verify;
	
	public DeleteIncomeOutlayManager(VerifyAble verify,DeleteIncomeOutlay deleteIncomeOutlay) {
		// TODO Auto-generated constructor stub
		
		this.deleteIncomeOutlay = deleteIncomeOutlay;
		this.verify = verify;
	}
	
	public boolean deleteIncomeOutlay(User user,IncomeOutlay incomeOutlay) throws Exception
	{
		boolean check = verify.verify(user);
		
		if(check)
		{
			return this.deleteIncomeOutlay.deleteIncomeOutlay(incomeOutlay);
		}
		else
		{
		return false;
		}
	}
}
