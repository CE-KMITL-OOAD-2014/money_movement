package connect_database;

import java.sql.Connection;
import java.sql.Statement;

import member_system.User;

public class SQL_UpdateUserSessionId implements UpdateUser {

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = ManageConnection.getConnection(user.getUsername().hashCode());
		Statement statement = connection.createStatement();
		
		
		
		
		
		return false;
	}

}
