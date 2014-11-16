package framework_azure;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


// create class for change format string for sql server

public class ChangeForSQL {
	

	public static String changeString(String inputString)
	{
		if(inputString==null)
		{
			return "NULL";
		}
		else
		{
			return String.format("'%s'", inputString);
		}
		
	}
	
	public static String changeDateToString(Date inputDate)
	{
		if(inputDate==null)
		{
			return "NULL";
		}
		else
		{
			int date = inputDate.getDate();
			int month = inputDate.getMonth()+1;
			int year = inputDate.getYear()+1900;
			
			String stringDate = String.format("%d/%d/%d",month,date,year);
			
			return stringDate;
		}
	}
	
	public static Date changeStringToDate(String inputString)
	{
		if(inputString==null)
		{
			return null;
		}
		else
		{
			ArrayList<String> list = new ArrayList<String>();
			StringTokenizer token = new StringTokenizer(inputString,"-");
				do
				{ 
					list.add(token.nextToken());			
				}
				while(token.hasMoreTokens());
			
				
			int month = Integer.parseInt(list.get(1))-1; 
			int day = Integer.parseInt(list.get(2));
			int year = Integer.parseInt(list.get(0))-1900;
		/*	
			System.out.println(list.size());
			System.out.println(day);
			System.out.println(month);
			System.out.println(year);
		*/
			Date returnDate = new Date(year,month,day);
			
			
			return returnDate;
		}
		
		
	}
	

}
