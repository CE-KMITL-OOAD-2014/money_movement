package member_system;

import java.sql.SQLException;

import connect_database.SelectUser;
import connect_database.SQL_SelectUser;

public class LoginManager implements LoginAble{

	@Override
	public User login(User user) throws SQLException, Exception {
		// TODO Auto-generated method stub
		boolean checkUsername,checkPassword;
		
		SelectUser selectUser = new SQL_SelectUser(); 
		User checkUser = selectUser.selectUser(user);
		
		if(checkUser!=null)
		{
			checkUsername = checkLogin(user.getUsername(), selectUser.selectUser(user).getUsername());
			checkPassword = checkLogin(user.getPassword(), selectUser.selectUser(user).getPassword());
		
			
			if(checkCorrect(checkUsername, checkPassword))
			{
				System.out.println(">>>>Start genarate SessionID");
				user = checkUser;
			}
			else
			{
				System.out.println("try Username or Password again");
				user = null;
			}
		}
		else
		{
			System.out.println("Login incorrect");
			user =null;
		}
		return user;
	}
	
	private boolean checkLogin(String userlogin, String selectname){
		boolean check;
		if(selectname.equals(userlogin)){
			//System.out.println("true");
			check = true;
		}
		else
		{
			//System.out.println("false");
			check = false;
		}
		
		return check;
	}
	private boolean checkCorrect(boolean checkUsername, boolean checkPassword)
	{
		boolean result;
		if(checkUsername && checkPassword){
			System.out.println("Seccessful!!!!!!!!!!!!!!!");
			result = true;
		}
		else if(!checkUsername)
		{
			System.out.println("Username incorrect");
			result = false;
		}	
		else
		{
			System.out.println("Password incorrect");
			result = false;
		}
		 return result;
	}

}
