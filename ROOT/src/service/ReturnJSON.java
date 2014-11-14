package service;

import java.io.UnsupportedEncodingException;

import org.json.simple.JSONObject;

public class ReturnJSON {

	private Status status;
	private JSONObject data;
	private String message;
	
	public ReturnJSON(Status status,JSONObject data,String message) {
		// TODO Auto-generated constructor stub
		
		this.status = status;
		this.data = data;
		this.message = message;
		
	}
	
	public String toJSONString()
	{
		JSONObject json = new JSONObject();
		
		json.put("status",this.status.toString());
		json.put("data",data);
		json.put("message", message);
		
		return json.toJSONString();
	}
	
	public byte[] toJSONByteUTF8() 
	{
	
			try 
			{
				return this.toJSONString().getBytes("UTF-8");
			} 
			catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
				return null;
			}
	}
	
}
