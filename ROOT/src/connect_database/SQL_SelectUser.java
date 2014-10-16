package connect_database;

import member_system.Profile;
import member_system.User;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.*;

import framework_azure.ConvertNameId;
import framework_azure.ManangeConnection;

public class SQL_SelectUser implements SelectUser {

	@Override
	public User selectUser(User user) throws Exception {
		
		// return null when don't have match
		
		
		Statement statement = null;
		ResultSet resultSet = null;
		String sqlCommand = null;
		User returnUser=null;
		Profile profileUser = null;
		
		String username = user.getUsername();
		
		int userId = username.hashCode();
		
		sqlCommand = String.format("select * from user_data where userId='%d'",userId );
				
		try
		{
			Connection connection = ManangeConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.next())
			{	
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String sessionId = resultSet.getString("sessionId");
				
				int age = resultSet.getInt("age");
				String name = resultSet.getString("name");	
				String email = resultSet.getString("email");
				String sex =    ConvertNameId.getObject().idToName("sex",String.valueOf(resultSet.getInt("sexId")));
				String province = ConvertNameId.getObject().idToName("province",String.valueOf(resultSet.getInt("provinceId")));
				String job = ConvertNameId.getObject().idToName("job",String.valueOf(resultSet.getInt("jobId")));
				
				profileUser = new Profile(name, age, job, sex, email, province);
				
				user = new User(username,password,sessionId,profileUser);
			}
			else
			{
				
				return null;
			}
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();	
			throw(ex);
		}
		
		
		return user;
	}

}
