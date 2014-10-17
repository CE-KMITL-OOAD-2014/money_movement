package manage_incomeoutlay;

public abstract class TypeOfUse {
	
	protected String name;
	protected String type;
	protected String priority;
	
	public String getTypeName()
	{
		return this.name;
	}
	public String getType()
	{
		return this.type;
	}
	public String getPriority()
	{
		return this.priority;
	}
}
