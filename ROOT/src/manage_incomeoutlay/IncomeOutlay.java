package manage_incomeoutlay;

import java.util.Date;

import org.json.simple.JSONObject;

import framework_azure.ConvertDate;

public class IncomeOutlay {
	private String owner;
	private String nameIncomeOutlay;
	private double amount;
	private Date saveDate;
	private TypeOfUse typeOfUse;
	private String comment;
	
	public IncomeOutlay(String owner,String nameIncomeOutlay,
			double amount,Date saveDate,TypeOfUse typeOfUse,String comment)
	{
		this.owner = owner;
		this.nameIncomeOutlay = nameIncomeOutlay;
		this.amount = amount;
		this.saveDate = saveDate;
		this.typeOfUse = typeOfUse;
		this.comment = comment;
	}
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getNameIncomeOutlay() {
		return nameIncomeOutlay;
	}
	public void setNameIncomeOutlay(String nameIncomeOutlay) {
		this.nameIncomeOutlay = nameIncomeOutlay;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	public TypeOfUse getTypeOfUse() {
		return typeOfUse;
	}
	public void setTypeOfUse(TypeOfUse typeOfUse) {
		this.typeOfUse = typeOfUse;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	 
	@Override
	public String toString() {
		
		String returnString = String.format("owner %s \n nameIncomeoutlay %s \n amount %f \n saveDate %s \n typeofuse %s \n comment %s \n",
		this.owner ,
		this.nameIncomeOutlay ,
		this.amount,
		this.saveDate ,
		this.typeOfUse.toString(),
		this.comment
		);
		
		return returnString;
	}
	
	public JSONObject toJSONObject()
	{
		JSONObject json = new JSONObject();
		json.put("owner",this.owner);
		json.put("nameincomeoutlay",this.nameIncomeOutlay); 
		json.put("amount",this.amount);
		json.put("savedate",ConvertDate.ChangeDateToYearMonthDate(this.saveDate));
		json.put("typeofuse", this.getTypeOfUse().toJSONObject());
		json.put("comment", this.comment);
		
		return json;
	}
	
	
	
}
