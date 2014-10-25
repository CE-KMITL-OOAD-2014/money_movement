package manage_incomeoutlay;

import java.util.Date;

public class IncomeOutlay {
	private String owner;
	private double amount;
	private Date saveDate;
	private TypeOfUse typeOfUse;
	private String comment;
	
	public String getOwner()
	{
		return this.owner;
	}
	public double getAmount()
	{
		return this.amount;
	}
	public Date getDate()
	{
		return this.saveDate;
	}
	public TypeOfUse getTypeOfUse()
	{
		return this.typeOfUse;
	}
	public String getComment()
	{
		return this.comment;
	}
	
}
