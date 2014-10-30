package member_system;

import org.json.simple.JSONObject;

import restful_service.ToJSONObject;

public class Profile implements ToJSONObject 
{
	private String name;
	private int age ;
	private String job;
	private String sex;
	private String email;
	private String province;
	
	public Profile(String name,int age ,String job,String sex,String email,String province)
	{
		this.name = name;
		this.age = age;
		this.job = job;
		this.sex = sex;
		this.email = email;
		this.province = province;
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
	
	@Override
	public String toString()
	{
		String allString;
		
		String name = String.format("name: %s\n", this.name) ;
		String age = String.format("age: %d\n", this.age);
		String job= String.format("job: %s\n", this.job);
		String sex= String.format("sex: %s\n", this.sex);
		String email= String.format("email: %s\n", this.email);
		String province= String.format("province: %s\n", this.province);
		
		allString = name+age+job+sex+email+province;
		
		return allString;
	}


	@Override
	public JSONObject toJSONObject() {
		
		JSONObject json = new JSONObject();
			
		json.put("name",this.name = name);
		json.put("age",this.age = age);
		json.put("job",this.job = job);
		json.put("sex",this.sex = sex);
		json.put("email",this.email = email);
		json.put("province",this.province = province);
		
		return json;
	}
	
}
