package member_system;

import connect_database.InsertUser;

import manage_incomeoutlay.AddIncomeOutlayAble;

public class RegisterManager implements RegisterAble {

	private InsertUser insertUser;
	
	
	public RegisterManager(InsertUser insertUser) {
		// TODO Auto-generated constructor stub
		this.insertUser = insertUser;
	}
	
	@Override
	public User register(User user) throws Exception {
	
		boolean check;
		
		try
		{
			check = insertUser.insertUser(user);
			
			if(check)
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			throw(ex);
		}
	}

}
