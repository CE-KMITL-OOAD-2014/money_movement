package framework_azure;

import java.util.Date;

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
			
			
			
			
			return null;
		}
		
		
	}

}
