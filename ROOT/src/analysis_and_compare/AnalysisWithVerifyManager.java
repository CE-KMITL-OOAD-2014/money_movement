package analysis_and_compare;

import java.util.ArrayList;

import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyAble;

public class AnalysisWithVerifyManager extends AnalysisManager {

	private Analysis analysisMethod;
	private VerifyAble verify;
	
	
	
	public AnalysisWithVerifyManager(Analysis analysisMethod, VerifyAble verify) {

		this.analysisMethod = analysisMethod;
		this.verify = verify;
	}

	@Override
	public ResultAnalysis analysis(User user, ArrayList<IncomeOutlay> list) throws Exception {
		
		boolean check = verify.verify(user);
		if(check)
		{
			return analysisMethod.analysis(list);
		}
		else
		{
			throw(new Exception("Plese login" ));
		}
	}

	
}
