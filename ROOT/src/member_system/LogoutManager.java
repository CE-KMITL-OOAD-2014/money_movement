package member_system;

import connect_database.UpdateUser;

public class LogoutManager implements LogoutAble {

	private VerifyAble verify;
	private UpdateUser updateUser;
	
	public LogoutManager(VerifyAble verify,UpdateUser updateUser) {
		this.verify = verify;
		this.updateUser = updateUser;
	}
	
	@Override
	public boolean logout(User user) throws Exception {
		// TODO Auto-generated method stub
		
		try
		{
			boolean check=verify.verify(user);
			if(check)
			{
				user.setSessionId(null);
				updateUser.updateUser(user);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			throw(ex);
		}
	}

}
