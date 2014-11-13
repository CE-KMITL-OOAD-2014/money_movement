package analysis_and_compare;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListMap;

import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.TypeOfUse;

public class UseAnalysis implements Analysis {

	@Override
	public ResultAnalysis analysis(ArrayList<IncomeOutlay> listIncomeOutlay) {
		// TODO Auto-generated method stub
				
		ConcurrentSkipListMap<TypeOfUse,Double> map = new ConcurrentSkipListMap<TypeOfUse,Double>();
		
		for(int i=0;i<listIncomeOutlay.size();i++)
		{
			IncomeOutlay temIncome = listIncomeOutlay.get(i);
			
			if(map.containsKey(temIncome.getTypeOfUse()))
			{
				double temSum = map.get(temIncome.getTypeOfUse()) + temIncome.getAmount();
				map.put(temIncome.getTypeOfUse(), temSum);
			}
			else
			{
				map.put(temIncome.getTypeOfUse(),temIncome.getAmount());
			}
		}
		
		ResultAnalysis resultAnayAnalysis = new ResultUseAnalysis(map);
		
		return resultAnayAnalysis;
	}

}
