package connect_database;

import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public interface InsertTypeIncomeOutlay {

	public boolean insertTypeIncomeOutlay(User user,TypeOfUse typeOfuse) throws Exception;
}
