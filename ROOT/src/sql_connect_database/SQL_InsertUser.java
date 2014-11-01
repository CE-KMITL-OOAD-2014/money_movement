package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;

import member_system.Profile;
import member_system.User;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.*;

import connect_database.InsertUser;
import connect_database.ManageConnection;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;

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
			
			username = user.getUsername();
			sessionId = user.getSessionID();
			password = user.getPassword();
			Connection connection  = ManageConnection.getConnection(username.hashCode());
			
			
			sqlCommand = this.changeUserToInsertSQL(user);
			System.out.println(sqlCommand);
			statement = connection.createStatement();
			checkComplete =  statement.executeUpdate(sqlCommand);
			ManageConnection.closeConnection(connection);
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
			
			String birthDateString =null ;
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
				 Date birthDate = profile.getBirthdate();
				 birthDateString =  ChangeForSQL.changeDateToString(birthDate) ;
				 sexId = convert.nameToId("sex",profile.getSex() )  ;
				 jobId = convert.nameToId("job",profile.getJob() );
				 provinceId = convert.nameToId("province", profile.getProvince() );
				 name = profile.getName();
				 email = profile.getEmail();
			}
			
			
			String value = String.format("Values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
					ChangeForSQL.changeString(userId),
					ChangeForSQL.changeString(userName),
					ChangeForSQL.changeString(password),
					ChangeForSQL.changeString(sessionId),
					ChangeForSQL.changeString(birthDateString),
					ChangeForSQL.changeString(sexId),
					ChangeForSQL.changeString(jobId),
					ChangeForSQL.changeString(provinceId),
					ChangeForSQL.changeString(name),
					ChangeForSQL.changeString(email) 
					);
			
			String sqlCommand = "insert into user_data"
					+ " (userId,username,password,sessionId,birthdate,sexId,jobId,provinceId,name,email) ";
			
			sqlCommand = sqlCommand+value;
			
			return sqlCommand;
		}
		
		
		
	}
	
}
