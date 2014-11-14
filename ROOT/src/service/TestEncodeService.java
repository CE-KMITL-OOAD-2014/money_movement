package service;

import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.org.mozilla.javascript.ast.NewExpression;

@RestController
@RequestMapping(value="testencode")
public class TestEncodeService  {
	
	@RequestMapping(value="")
	public byte[] getMessage(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("message")String message
			)
	{
		System.out.println("In Controller");
		byte[] returnMessage = null;
		
		System.out.println(message);
		
		try
		{	
			JSONObject json = new JSONObject();
			json.put("name", message);
			
			byte[] data = json.toJSONString().getBytes("UTF-8");
			
			returnMessage = data;
			
		}
		
		catch(Exception ex)
		{
			System.out.println("Error");
			returnMessage  = "Error".getBytes("UTF-8");
		}
		finally
		{
			return returnMessage;
		}
		
		
	}
	
}
