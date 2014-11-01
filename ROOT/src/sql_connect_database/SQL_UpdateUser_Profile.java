package sql_connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect_database.ManageConnection;
import connect_database.UpdateUser;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;
import member_system.Profile;
import member_system.User;

public class SQL_UpdateUser_Profile implements UpdateUser  {

	@Override
	public boolean updateUser(User user) throws Exception  {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		int check=0;
		String sqlCommand;
		
		sqlCommand = this.changeUserToUpdateSQL(user);
		try
		{
			connection = ManageConnection.getConnection(user.getUsername().hashCode());
			statement = connection.createStatement();
			check = statement.executeUpdate(sqlCommand);
		}
		catch(Exception ex)
		{
			throw(ex);
		}
		finally
		{
			connection.close();
		}	
		return check>0;
	}
	
	private String changeUserToUpdateSQL(User user) throws Exception
	{
		Profile profile = user.getProfile();
		ConvertNameId  convertNameId =  ConvertNameId.getObject();
	
		
		String birthDateString = ChangeForSQL.changeDateToString(user.getProfile().getBirthdate());
		String sexId =  convertNameId.nameToId("sex",profile.getSex());
		String jobId =  convertNameId.nameToId("job",profile.getJob());
		String provinceId =  convertNameId.nameToId("province",profile.getJob());
		String name = profile.getName();
		String email = profile.getEmail();
		
		String sqlCommand = String.format("update user_data set birthdate=%s,sexId=%s,jobId=%s,provinceId=%s,name=%s,email=%s " 
				,ChangeForSQL.changeString(birthDateString) 
				,ChangeForSQL.changeString(sexId) 
				,ChangeForSQL.changeString(jobId) 
				,ChangeForSQL.changeString(provinceId) 
				,ChangeForSQL.changeString(name) 
				,ChangeForSQL.changeString(email) 
				);
		String sqlWhere = String.format(" where userId=%d",user.getUsername().hashCode());
		
		return sqlCommand+sqlWhere;
	}

}
