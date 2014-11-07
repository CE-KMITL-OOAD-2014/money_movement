package analysis_and_compare;

import java.util.ArrayList;

import manage_incomeoutlay.IncomeOutlay;
import member_system.User;

public abstract class AnalysisManager {
	
	public abstract ResultAnalysis analysis(User user,ArrayList<IncomeOutlay> listIncomeOutlay) throws Exception;

}
