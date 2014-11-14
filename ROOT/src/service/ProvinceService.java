package service;

import java.awt.List;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import framework_azure.ConvertNameId;
import framework_azure.Pair;


@RestController
@RequestMapping(value="/province")
public class ProvinceService {

	@RequestMapping(value="")
	public byte[] getProvince()
	{
		String tableName = "province";
		Status status=null;
		String message="";
		JSONObject data=null;
		
		ConvertNameId convert = ConvertNameId.getObject();
		
		try
		{	
			ArrayList<Pair<String,String >> list =convert.getListFromTable(tableName);
			JSONArray listArray = new JSONArray();
			
			for(int i=0;i<list.size();i++)
			{
				JSONObject temObj = new JSONObject();
				temObj.put("name",list.get(i).getSecound());
				listArray.add(temObj);
			}
			data = new JSONObject();
			data.put(tableName,listArray);
			status = Status.complete;			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = Status.error;
			message = String.format("%s\n%s\n%s",ex.toString(),ex.getMessage(),ex.getLocalizedMessage() );
		}
		finally
		{
			ReturnJSON returnJson = new ReturnJSON(status, data, message);
			return returnJson.toJSONByteUTF8();
		}

	}
	
}
