package manage_incomeoutlay;

import java.util.Comparator;

import org.json.simple.JSONObject;

public class NomalTypeOfUser extends TypeOfUse implements Comparable<TypeOfUse>{
	
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
	@Override
	public int compareTo(TypeOfUse right) {

		TypeOfUse left = this;
		
		if(left.name.compareTo(right.name)==0 && left.type.compareTo(right.type)==0 && left.priority.compareTo(right.priority)==0 )
		{
			return 0;
		}
		else
		{
			return 1;
		}
		
	}
	
	
	
}
