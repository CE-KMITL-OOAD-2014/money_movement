package connect_database;

import java.sql.Connection;
import java.sql.Statement;

import framework_azure.ChangeStringForSQL;
import member_system.User;

public class SQL_UpdateUserSessionId implements UpdateUser {

	
	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = ManageConnection.getConnection(user.getUsername().hashCode());
		Statement statement = connection.createStatement();
		String sqlCommand = this.changeUserToSQL(user);
		int check = 0;
		try
		{
			check = statement.executeUpdate(sqlCommand);
		}
		catch( Exception ex)
		{
			ex.printStackTrace();
			throw(ex);
		}
		finally
		{
			return check > 0;
		}
	}
	
	private String changeUserToSQL(User user)
	{
		String sqlCommand =  String.format("Update user_data Set sessionId=%s where userId=%s"
				,ChangeStringForSQL.changeString(user.getSessionID())
				,ChangeStringForSQL.changeString( String.valueOf(user.getUsername().hashCode()))
				); 
		return sqlCommand;
	}

}
