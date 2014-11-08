package analysis_and_compare;

import java.util.ArrayList;

import manage_incomeoutlay.IncomeOutlay;
import member_system.User;

public abstract class CompareManager {
	
	public abstract ResultCompare compare(User user,ArrayList<IncomeOutlay> myIncomeoutlay,ArrayList<IncomeOutlay> anotherIncomeoutlay) throws Exception;
}
