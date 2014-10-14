package connect_database;

import member_system.Profile;
import member_system.User;

import java.sql.*;

import javax.jms.Session;

import com.microsoft.sqlserver.jdbc.*;

import framework_azure.ManangeConnection;

public class SQL_InsertUser implements InsertUser 
{

	@Override
	public boolean insertUser(User user) 
	{
		Connection connection = ManangeConnection.getConnection();
		String sqlCommand;
		Statement statement=null;
		int checkComplete;
		
		String username,password,sessionId,age,sexId,jobId,provinceId,name;
		Profile profile = user.getProfile();
		
		
		username = user.getUsername();
		sessionId = user.getSessionID();
		password = user.getPassword();
		age = String.valueOf(profile.getAge()); 
		name = profile.getName();
		
		
		
		try
		{
			sqlCommand = "insert into user_data"
					+ " (userId,username,password,sessionId,age,sexId,jobId,provinceId,name) "
					+ " Values ('0','samander','samander',NULL,'30','0','0','0','surapong') ";
			statement = connection.createStatement();
			checkComplete =  statement.executeUpdate(sqlCommand);
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			ManangeConnection.closeConnection(connection);
			return false;
		}
		ManangeConnection.closeConnection(connection);
		return checkComplete > 0;
	}
}
