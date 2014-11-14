package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
public class SpringServiceController {
 @RequestMapping(value="",method = RequestMethod.GET)
 public String getGreeting() {
//	String result = null;
	JSONArray list = new JSONArray();
	for(int i=0;i<20;i++)
	{
		JSONObject tem = new JSONObject();
		tem.put("id", i);
		list.add(tem);
	}
	
	
  return list.toJSONString(); 
 }
 
 @RequestMapping("/hello")
 public String getSamander()
 {
	 JSONObject tem = new JSONObject();
	 JSONObject returnData = new JSONObject();
	 tem.put("id",30);
	 returnData.put("data", tem);
	 
	 System.out.println(returnData.toJSONString());
	 
	 
	 
	 return returnData.toJSONString();
 }
 
}