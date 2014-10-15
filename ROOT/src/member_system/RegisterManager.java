package member_system;

import connect_database.InsertUser;
import connect_database.SQL_InsertUser;
import manage_incomeoutlay.AddIncomeOutlayAble;

public class RegisterManager implements RegisterAble {

	@Override
	public User register(User user) {
		
		InsertUser sqlInsertUer = new SQL_InsertUser();
		boolean check;
		
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

}
