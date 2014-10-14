package member_system;

public class Profile 
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
	
}
