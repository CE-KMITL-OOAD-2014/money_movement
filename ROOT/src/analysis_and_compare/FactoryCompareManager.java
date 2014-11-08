package analysis_and_compare;

import sql_connect_database.SQL_SelectUser;
import member_system.VerifyAble;
import member_system.VerifyManager;

public class FactoryCompareManager {
	
	public CompareManager getCompareMyIncomeWithAnotherIncomeByWork()
	{
		Compare compareMethod = new CompareMyIncomeWithAnotherIncome();
		VerifyAble verify = new VerifyManager(new SQL_SelectUser());
		
		
		CompareManager myManager = new CompareWithVerifyManager(compareMethod, verify);
		
		return myManager;
	}

}
