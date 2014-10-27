package connect_database;

import java.util.ArrayList;

import manage_incomeoutlay.TypeOfUse;

public interface SelectTypeIncomeOutlay {
	
	public ArrayList<TypeOfUse> selectTypeIncomeOutlay(int userId) throws Exception;
	public TypeOfUse selectTypeIncomeOutlay(int userId,String typeName) throws Exception;
}
