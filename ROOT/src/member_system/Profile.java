package member_system;

import java.util.Date;

import org.json.simple.JSONObject;



public class Profile 
{
	private String name;
	private int age ;
	private String job;
	private String sex;
	private String email;
	private String province;
	private Date birthdate;
	
	
	public Profile(String name,Date birthdate ,String job,String sex,String email,String province)
	{
		this.name = name;
		this.job = job;
		this.sex = sex;
		this.email = email;
		this.province = province;
		if(birthdate==null)
		{
			age = 0;
		}
		else
		{
			this.birthdate = birthdate;
			Date currentDate = new Date();	
			age = currentDate.getYear() - birthdate.getYear();
		}
		
	}
	
	
	public String getName() 
	{
		return name;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getJob() 
	{
		return job;
	}
	
	public String getSex() 
	{
		return sex;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getProvince()
	{
		return this.province;
	}
	
	public Date getBirthdate()
	{
		return this.birthdate;
	}
	
	@Override
	public String toString()
	{
		String allString;
		
		String name = String.format("name: %s\n", this.name) ;
		String birthdate = String.format("birthdate: ",this.birthdate.toGMTString());
		String age = String.format("age: %d\n", this.age);
		String job= String.format("job: %s\n", this.job);
		String sex= String.format("sex: %s\n", this.sex);
		String email= String.format("email: %s\n", this.email);
		String province= String.format("province: %s\n", this.province);
		
		allString = name+birthdate+age+job+sex+email+province;
		
		return allString;
	}


	public JSONObject toJSONObject() {
		
		JSONObject json = new JSONObject();
		String birthdate  = String.format("%d-%d-%d",this.birthdate.getYear()+1900,this.birthdate.getMonth()+1,this.birthdate.getDate());
		
		json.put("name",this.name = name);
		json.put("birthdate", birthdate);
		json.put("age",this.age = age);
		json.put("job",this.job = job);
		json.put("sex",this.sex = sex);
		json.put("email",this.email = email);
		json.put("province",this.province = province);
		
		return json;
	}
	
}
