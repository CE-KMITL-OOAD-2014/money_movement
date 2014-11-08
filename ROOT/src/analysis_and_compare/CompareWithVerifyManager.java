package analysis_and_compare;

import java.util.ArrayList;

import manage_incomeoutlay.GetIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyAble;

public class CompareWithVerifyManager extends CompareManager {

	private Compare compareMethod;
	private VerifyAble verify;
	
	
	
	
	public CompareWithVerifyManager(Compare compareMethod, VerifyAble verify) {		
		this.compareMethod = compareMethod;
		this.verify = verify;
	}

	@Override
	public ResultCompare compare(User user,
			ArrayList<IncomeOutlay> myIncomeOutlay,
			ArrayList<IncomeOutlay> anotherIncomeOutlay) throws Exception {
		
		boolean check = verify.verify(user);
		
		if(check)
		{
			return this.compareMethod.compare(myIncomeOutlay, anotherIncomeOutlay);
		}
		else
		{
			throw (new Exception("plese login"));
		}
		
	}
}
