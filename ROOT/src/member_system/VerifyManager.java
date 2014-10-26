package member_system;

import connect_database.SelectUser;

public class VerifyManager implements VerifyAble  {

	private SelectUser selectUser;
	
	public VerifyManager(SelectUser selectUser) {
		this.selectUser = selectUser;
	}
	@Override
	public boolean verify(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean checkUsername = false;
		boolean checkSessionId = false;
		try
		{			
			User userFromDatabase = selectUser.selectUser(user);		
			checkUsername = (userFromDatabase.getUsername().compareTo(user.getUsername())== 0); 
			checkSessionId = (userFromDatabase.getSessionID().compareTo(user.getSessionID())== 0);			
			return (checkUsername && checkSessionId);
		}
		catch(Exception ex)
		{
			throw(ex);
		}
		
	}

}
