package analysis_and_compare;

import sql_connect_database.SQL_SelectUser;
import member_system.VerifyAble;
import member_system.VerifyManager;

public class FactoryAnalysisManager {
	
	public AnalysisManager getBalanceAnalysisManager()
	{
		VerifyAble verify = new VerifyManager(new SQL_SelectUser());
		Analysis analysisMethod = new BalanceAnalysis();
		AnalysisManager analysisManager = new AnalysisWithVerifyManager(analysisMethod, verify);
		return analysisManager;
	}
	
	public AnalysisManager getUseAnalysisManager()
	{
		VerifyAble verify = new VerifyManager(new SQL_SelectUser());
		Analysis analysisMethod = new UseAnalysis();
		AnalysisManager analysisManager = new AnalysisWithVerifyManager(analysisMethod, verify);
		return analysisManager;
	}
}
