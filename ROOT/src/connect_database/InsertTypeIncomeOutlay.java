package connect_database;

import manage_incomeoutlay.TypeOfUse;

public interface InsertTypeIncomeOutlay {

	public boolean insertTypeIncomeOutlay(int userId,TypeOfUse typeOfuse) throws Exception;
}
