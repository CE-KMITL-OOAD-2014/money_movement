package framework_azure;

import java.io.UnsupportedEncodingException;

public  class ChangeForTomcat {
	
	
	public static String changeForThai(String input)
	{
		if(input==null)
		{
			return null;
		}
		
		
		String oneEncode =null;
		String twoDecode =null;
		try {
			oneEncode = java.net.URLEncoder.encode(input,"ISO-8859-1");
			twoDecode= java.net.URLDecoder.decode(oneEncode,"UTF-8");
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return twoDecode;
	}

}
