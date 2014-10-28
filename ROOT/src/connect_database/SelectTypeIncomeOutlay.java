package connect_database;

import java.util.ArrayList;

import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public interface SelectTypeIncomeOutlay {
	
	public ArrayList<TypeOfUse> selectTypeIncomeOutlay(User user) throws Exception;
	public TypeOfUse selectTypeIncomeOutlay(User user,TypeOfUse typeOfUse) throws Exception;
}
