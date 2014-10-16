package connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import framework_azure.ChangeStringForSQL;
import framework_azure.ConvertNameId;
import framework_azure.ManangeConnection;
import member_system.Profile;
import member_system.User;

public class SQL_UpdateUser_Profile implements UpdateUser  {

	@Override
	public boolean updateUser(User user) throws Exception  {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		int check;
		String sqlCommand;
		
		sqlCommand = this.changeUserToUpdateSQL(user);
		connection = ManangeConnection.getConnection();
		
		statement = connection.createStatement();
		check = statement.executeUpdate(sqlCommand);
		
		
		return check>0;
	}
	
	private String changeUserToUpdateSQL(User user) throws Exception
	{
		Profile profile = user.getProfile();
		ConvertNameId  convertNameId =  ConvertNameId.getObject();
	
		
		String age = String.valueOf(profile.getAge());
		String sexId =  convertNameId.nameToId("sex",profile.getSex());
		String jobId =  convertNameId.nameToId("job",profile.getJob());
		String provinceId =  convertNameId.nameToId("province",profile.getJob());
		String name = profile.getName();
		String email = profile.getEmail();
		
		String sqlCommand = String.format("update user_data set age=%s,sexId=%s,jobId=%s,provinceId=%s,name=%s,email=%s " 
				,ChangeStringForSQL.changeString(age) 
				,ChangeStringForSQL.changeString(sexId) 
				,ChangeStringForSQL.changeString(jobId) 
				,ChangeStringForSQL.changeString(provinceId) 
				,ChangeStringForSQL.changeString(name) 
				,ChangeStringForSQL.changeString(email) 
				);
		String sqlWhere = String.format(" where userId=%d",user.getUsername().hashCode());
		
		return sqlCommand+sqlWhere;
	}

}
