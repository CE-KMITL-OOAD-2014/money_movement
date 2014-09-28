package manage_incomeoutlay;

import java.util.Date;

public class IncomeOutlay {
	private String owner;
	private double amount;
	private Date date;
	private TypeOfUse typeOfUse;
	
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
		return this.date;
	}
	public TypeOfUse getTypeOfUse()
	{
		return this.typeOfUse;
	}
	
}
