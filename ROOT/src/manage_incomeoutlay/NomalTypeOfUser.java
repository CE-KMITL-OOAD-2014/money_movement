package manage_incomeoutlay;

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
}
