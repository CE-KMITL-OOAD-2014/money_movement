package analysis_and_compare;

import java.util.ArrayList;

import connect_database.SelectIncomeOutlay;
import manage_incomeoutlay.IncomeOutlay;
import member_system.VerifyAble;

public class BalanceAnalysis implements Analysis {

	@Override
	public ResultAnalysis analysis(ArrayList<IncomeOutlay> listIncomeOutlay) {
	
		String donotWantType = "income";
		double low;
		double mediam;
		
		ArrayList<IncomeOutlay> listWant = new ArrayList<IncomeOutlay>();
		
		for(int i=0;i<listIncomeOutlay.size();i++)
		{
			IncomeOutlay incomeOutlay = listIncomeOutlay.get(i);
			
			if(incomeOutlay.getTypeOfUse().getType().compareTo(donotWantType)==0)
			{
				listWant.add(incomeOutlay);
			}
		}
		
		
		
		
		
		
		
		return null;
	}
	
	

}
