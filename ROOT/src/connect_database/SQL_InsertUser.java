package connect_database;

import member_system.Profile;
import member_system.User;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.*;

import framework_azure.ChangeStringForSQL;
import framework_azure.ConvertNameId;
import framework_azure.ManangeConnection;

public class SQL_InsertUser implements InsertUser 
{

	@Override
	public boolean insertUser(User user) throws Exception 
	{
		
		String sqlCommand;
		Statement statement=null;
		int checkComplete;
		
		String username,password,sessionId,age,sexId,jobId,provinceId,name;
		Profile profile = user.getProfile();
		
		
		try
		{
			Connection connection = ManangeConnection.getConnection();
			username = user.getUsername();
			sessionId = user.getSessionID();
			password = user.getPassword();
				
			sqlCommand = this.changeUserToInsertSQL(user);
			System.out.println(sqlCommand);
			statement = connection.createStatement();
			checkComplete =  statement.executeUpdate(sqlCommand);
			ManangeConnection.closeConnection(connection);
			return checkComplete > 0;
			
		}
		
		catch(Exception ex)
		{
			throw(ex);
		}
		
		
	}
	
	private String changeUserToInsertSQL(User user) throws Exception
	{
		if(user==null)
		{
			return null;
		}
		else
		{
			String userId =  String.valueOf(user.getUsername().hashCode()) ;
			String userName = user.getUsername();
			String password = user.getPassword();
			String sessionId = null;

			Profile profile = user.getProfile();
			ConvertNameId convert = ConvertNameId.getObject();
			
			String age =null ;
			String sexId =null ;
			String jobId =null ;
			String provinceId =null;
			String name =null;
			String email=null  ;
			
			
			if(profile==null)
			{
				
			}
			else
			{
				 age =  String.valueOf(profile.getAge()) ;
				 sexId = convert.nameToId("sex",profile.getSex() )  ;
				 jobId = convert.nameToId("job",profile.getJob() );
				 provinceId = convert.nameToId("province", profile.getProvince() );
				 name = profile.getName();
				 email = profile.getEmail();
			}
			
			
			String value = String.format("Values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
					ChangeStringForSQL.changeString(userId),
					ChangeStringForSQL.changeString(userName),
					ChangeStringForSQL.changeString(password),
					ChangeStringForSQL.changeString(sessionId),
					ChangeStringForSQL.changeString(age),
					ChangeStringForSQL.changeString(sexId),
					ChangeStringForSQL.changeString(jobId),
					ChangeStringForSQL.changeString(provinceId),
					ChangeStringForSQL.changeString(name),
					ChangeStringForSQL.changeString(email) 
					);
			
			String sqlCommand = "insert into user_data"
					+ " (userId,username,password,sessionId,age,sexId,jobId,provinceId,name,email) ";
			
			sqlCommand = sqlCommand+value;
			
			return sqlCommand;
		}
		
		
		
	}
	
}
