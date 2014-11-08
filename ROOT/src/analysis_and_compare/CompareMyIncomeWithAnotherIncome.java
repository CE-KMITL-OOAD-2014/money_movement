package analysis_and_compare;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import manage_incomeoutlay.IncomeOutlay;

public class CompareMyIncomeWithAnotherIncome implements Compare {

	@Override
	public ResultCompare compare(
			ArrayList<IncomeOutlay> myIncomeOutlay,
			ArrayList<IncomeOutlay> anotherIncomeOutlay) 
	{
		String stringIncome = "income";
		String stringOutcome = "outcome";
		
		// TODO Auto-generated method stub
		double sumMyIncomeOutlay = 0;
		double sumAnotherIncome = 0;
		double sumAnotherOutlay = 0;
		double sumAnotherIncomeOutlay=0;
		
		ConcurrentSkipListSet<String> nameUser = new ConcurrentSkipListSet<String>() ;
		
		
		for(int i=0;i<myIncomeOutlay.size();i++)
		{
			IncomeOutlay tem = myIncomeOutlay.get(i);
			
			if(tem.getTypeOfUse().getType().compareTo(stringIncome)==0)
			{
				sumMyIncomeOutlay+=tem.getAmount();
			}
			else if(tem.getTypeOfUse().getType().compareTo(stringOutcome)==0)
			{
				sumMyIncomeOutlay -= tem.getAmount();
			}
		}
		
		for(int i=0;i<anotherIncomeOutlay.size();i++)
		{
			IncomeOutlay tem = anotherIncomeOutlay.get(i);
			nameUser.add(tem.getOwner());
			
			if(tem.getTypeOfUse().getType().compareTo(stringIncome)==0)
			{
				sumAnotherIncome+=tem.getAmount();
			}
			else if(tem.getTypeOfUse().getType().compareTo(stringOutcome)==0)
			{
				sumAnotherOutlay += tem.getAmount();
			}		
		}
		
		System.out.println(nameUser.size());
		sumAnotherIncomeOutlay = (sumAnotherIncome/nameUser.size()) - (sumAnotherOutlay/nameUser.size());
		
		
		ResultCompare result = new ResultComapareMyIncomeWithAnother(sumMyIncomeOutlay, sumAnotherIncomeOutlay);
		
		return result;
	}

	
	
	
}
