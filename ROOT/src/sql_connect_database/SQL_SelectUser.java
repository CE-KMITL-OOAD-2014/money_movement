package sql_connect_database;

import member_system.Profile;
import member_system.User;

import java.sql.*;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.*;

import connect_database.ManageConnection;
import connect_database.SelectUser;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;


public class SQL_SelectUser implements SelectUser {

	@Override
	public User selectUser(User user) throws Exception {
		
		// return null when don't have match
		
		Statement statement = null;
		ResultSet resultSet = null;
		String sqlCommand = null;
		User returnUser=null;
		Profile profileUser = null;
		Connection connection = null;
		
		
		String username = user.getUsername();
		
		int userId = username.hashCode();
		
		sqlCommand = String.format("select * from user_data where userId='%d'",userId );
				
		try
		{
			connection = ManageConnection.getConnection(username.hashCode());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.next())
			{	
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String sessionId = resultSet.getString("sessionId");
				
				String birthDateString = resultSet.getString("birthdate");
				String name = resultSet.getString("name");	
				String email = resultSet.getString("email");
				String sex =    ConvertNameId.getObject().idToName("sex",String.valueOf(resultSet.getInt("sexId")));
				String province = ConvertNameId.getObject().idToName("province",String.valueOf(resultSet.getInt("provinceId")));
				String job = ConvertNameId.getObject().idToName("job",String.valueOf(resultSet.getInt("jobId")));
				
				
				Date birthdate = ChangeForSQL.changeStringToDate(birthDateString);
				
				profileUser = new Profile(name, birthdate, job, sex, email, province);
				
				returnUser = new User(username,password,sessionId,profileUser);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	
			throw(ex);
		}
		finally
		{
			ManageConnection.closeConnection(connection);
			return returnUser;
		}
		
	}

}
