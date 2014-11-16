package analysis_and_compare;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.TypeOfUse;

 // this class is one of compare methods  for compare user  incomeoutlay with one another incomeoutlay   

public class CompareMyIncomeWithAnotherIncome implements Compare {

	private String stringIncome = "income";
	private String stringOutcome = "outcome";
	private int maxMonth = 12;
	private String low = "low";
	private String avg = "avg";
	private String height = "height";
	
	@Override
	public ResultCompare compare(
			ArrayList<IncomeOutlay> myIncomeOutlay,
			ArrayList<IncomeOutlay> anotherIncomeOutlay) 
	{
		ConcurrentSkipListMap<Integer,ArrayList<IncomeOutlay>> myMap;
		ConcurrentSkipListMap<Integer,ArrayList<IncomeOutlay>> anotherMap;
		
		myMap = this.classificationMounth(myIncomeOutlay);		
		anotherMap = this.classificationMounth(anotherIncomeOutlay);
		
		JSONArray jsonArray = new JSONArray();
		
		
		for(int i=0;i<this.maxMonth;i++)
		{
			JSONObject jsonObject = this.calPerMonth(i,myMap.get(i) ,anotherMap.get(i) );
			
//			System.out.println(jsonObject.toJSONString());
//			System.out.println("*************************************");
			
			jsonArray.add(jsonObject);
		}
		
		JSONObject returnJSON  = new JSONObject();
		returnJSON.put("result", jsonArray);
		
		ResultComapareMyIncomeWithAnother result = new ResultComapareMyIncomeWithAnother(returnJSON);
		
		return result ;
	}
	
	
	
	private ConcurrentSkipListMap<Integer,ArrayList<IncomeOutlay>>  classificationMounth(ArrayList<IncomeOutlay> listIncomeOutlay)
	{
		ConcurrentSkipListMap<Integer,ArrayList<IncomeOutlay>> map = new ConcurrentSkipListMap<Integer,ArrayList<IncomeOutlay>>();
		
		for(int i=0;i<maxMonth;i++)
		{
			map.put(i, new ArrayList<IncomeOutlay>());
		}
		
		for(int i=0;i<listIncomeOutlay.size();i++)
		{
			IncomeOutlay temIncome = listIncomeOutlay.get(i);
			int month = temIncome.getSaveDate().getMonth();
			map.get(month).add(temIncome);
		}
		return map;
	}

	private JSONObject calPerMonth(int month,ArrayList<IncomeOutlay> myList,ArrayList<IncomeOutlay> listAnother)
	{
		ConcurrentSkipListSet<String> nameUser = new ConcurrentSkipListSet<String>() ;
		
		double sumHeight = 0;
		double sumAvg = 0;
		double sumLow = 0;
		
		double mySumHeight = 0;
		double mySumAvg = 0;
		double mySumLow = 0;
		
		
		for(int i=0;i<listAnother.size();i++)
		{
			IncomeOutlay temIncomeOutlay = listAnother.get(i);
			nameUser.add(temIncomeOutlay.getOwner());
			TypeOfUse typeOfUse = temIncomeOutlay.getTypeOfUse();
			
			if(typeOfUse.getType().compareTo(this.stringOutcome)==0)
			{
				if(typeOfUse.getPriority().compareTo(this.low)==0)
				{
					sumLow += temIncomeOutlay.getAmount();
				}
				else if(typeOfUse.getPriority().compareTo(this.avg)==0)
				{
					sumAvg += temIncomeOutlay.getAmount();
				}
				else if(typeOfUse.getPriority().compareTo(this.height)==0)
				{
					sumHeight += temIncomeOutlay.getAmount();
				}
			}	
		}
		
		
		for(int i=0;i<myList.size();i++)
		{
			IncomeOutlay temIncomeOutlay = myList.get(i);
			TypeOfUse typeOfUse = temIncomeOutlay.getTypeOfUse();
			
			if(typeOfUse.getType().compareTo(this.stringOutcome)==0)
			{
				if(typeOfUse.getPriority().compareTo(this.low)==0)
				{
					mySumLow += temIncomeOutlay.getAmount();
				}
				else if(typeOfUse.getPriority().compareTo(this.avg)==0)
				{
					mySumAvg += temIncomeOutlay.getAmount();
				}
				else if(typeOfUse.getPriority().compareTo(this.height)==0)
				{
					mySumHeight += temIncomeOutlay.getAmount();
				}
			}
			
			
		}
		
		if(nameUser.size()==0)
		{
			sumHeight = 0;
			sumAvg = 0;
			sumLow = 0;
		}
		else
		{
			sumHeight = sumHeight/nameUser.size();
			sumAvg = sumAvg/nameUser.size();
			sumLow = sumLow/nameUser.size();
		}
		JSONArray jsonArray = new JSONArray();
		
				
		JSONObject returnJson = new JSONObject();
		returnJson.put("valueref",sumHeight+sumAvg+sumLow);
		returnJson.put("valueuse",mySumLow+mySumAvg+mySumHeight);
		returnJson.put("month",month+1 );
		
		return returnJson;
	}
}
