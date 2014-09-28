package member_system;

public class Profile 
{
	private String name;
	private int age ;
	private String job;
	private SexType sex;
	private String email;
	private String province;
	
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
	
	public SexType getSex() 
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
}
