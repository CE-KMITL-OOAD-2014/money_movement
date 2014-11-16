package analysis_and_compare;

import java.util.ArrayList;

import connect_database.SelectIncomeOutlay;
import manage_incomeoutlay.IncomeOutlay;
import member_system.VerifyAble;

// this class is one of analysis methods  for analysis  incomeoutlay  

public class BalanceAnalysis implements Analysis {

	@Override
	public ResultAnalysis analysis(ArrayList<IncomeOutlay> listIncomeOutlay) {
	
		String donotWantType = "income";
		double low = 0;
		double avg =0;
		double height =0;
		
		String lowString = "low";
		String avgString = "avg";
		String heightString = "height";
		
		ArrayList<IncomeOutlay> listWant = new ArrayList<IncomeOutlay>();
		
		for(int i=0;i<listIncomeOutlay.size();i++)
		{
			IncomeOutlay incomeOutlay = listIncomeOutlay.get(i);
			
			if(incomeOutlay.getTypeOfUse().getType().compareTo(donotWantType)!=0)
			{
				listWant.add(incomeOutlay);
			}
		}
		
		for(int i=0;i<listWant.size();i++)
		{
			IncomeOutlay incomeOutlay = listWant.get(i);
			
			if(incomeOutlay.getTypeOfUse().getPriority().compareTo(lowString)==0)
			{
				low += incomeOutlay.getAmount();
			}
			else if(incomeOutlay.getTypeOfUse().getPriority().compareTo(heightString)==0)
			{
				height += incomeOutlay.getAmount();
			}
			else if(incomeOutlay.getTypeOfUse().getPriority().compareTo(avgString)==0)
			{
				avg += incomeOutlay.getAmount();
			}
		}
		/*
		System.out.println(low);
		System.out.println(avg);
		System.out.println(height);
		*/
		
		
		
		
		ResultAnalysis result = new ResultBalanceAnalysis(low, avg, height);
		
		result.toJSONObject();
		
		return result;
	}
	
	

}
