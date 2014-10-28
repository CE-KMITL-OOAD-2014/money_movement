package connect_database;

import manage_incomeoutlay.IncomeOutlay;

public interface UpdateIncomeOutlay {
	
	public boolean updateIncomeOutlay(IncomeOutlay oldIncomeOutlay,IncomeOutlay newIncomeOutlay) throws Exception;

}
