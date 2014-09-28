package manage_incomeoutlay;

public abstract class TypeOfUse {
	
	protected String name;
	protected Type type;
	protected Priority priority;
	
	public String getTypeName()
	{
		return this.name;
	}
	public Type getType()
	{
		return this.type;
	}
	public Priority getPriority()
	{
		return this.priority;
	}
}
