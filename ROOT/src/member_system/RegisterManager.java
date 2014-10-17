package member_system;

import connect_database.InsertUser;
import connect_database.SQL_InsertUser;
import manage_incomeoutlay.AddIncomeOutlayAble;

public class RegisterManager implements RegisterAble {

	@Override
	public User register(User user) throws Exception {
		
		InsertUser sqlInsertUer = new SQL_InsertUser();
		boolean check;
		
		try
		{
			check = sqlInsertUer.insertUser(user);
			
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
