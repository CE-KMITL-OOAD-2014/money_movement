package framework_azure;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class ConvertDate {
	
	
	public static Date ChangeYearMonthDate(String dateString)
	{
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(dateString,"-");
		
		while(token.hasMoreTokens())
		{
			list.add(token.nextToken());
		}
		int day,month,year;
		
		year = Integer.parseInt(list.get(0)); 
		month = Integer.parseInt(list.get(1));
		day = Integer.parseInt(list.get(2));
		
		Date returnDate = new Date(year-1900, month-1, day);
		
		return returnDate;
	}

}
