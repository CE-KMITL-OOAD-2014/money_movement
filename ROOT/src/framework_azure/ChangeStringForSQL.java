package framework_azure;

public class ChangeStringForSQL {
	
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

}
