package analysis_and_compare;

import java.util.ArrayList;

import manage_incomeoutlay.IncomeOutlay;

public interface Compare {
	public ResultCompare compare(ArrayList<IncomeOutlay> myIncomeOutlay,ArrayList<IncomeOutlay> anotherIncomeOutlay );
	
}
