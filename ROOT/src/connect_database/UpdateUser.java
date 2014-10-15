package connect_database;

import java.sql.SQLException;

import member_system.User;

public interface UpdateUser {
	
	public boolean updateUser(User user) throws Exception ;

}
