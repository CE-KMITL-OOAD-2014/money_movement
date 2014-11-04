package manage_incomeoutlay;

import org.json.simple.JSONObject;

public class NomalTypeOfUser extends TypeOfUse{
	
	public NomalTypeOfUser(String name,String type,String priority)
	{
		this.name = name;
		this.type = type;
		this.priority = priority;
	}
	@Override
	public String toString() {
		
		String returnString = String.format("name %s\ntype %s\npriority %s\n",name,type,priority );
		
		return returnString;
	}
	
	@Override
	public JSONObject toJSONObject()
	{
		JSONObject json = new JSONObject();
		
		json.put("name", this.name);
		json.put("type", this.type);
		json.put("priority", this.priority);
				
		return json;
	}
	
}
