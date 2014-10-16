package connect_database;

import java.sql.SQLException;

import member_system.User;

public interface SelectUser {
	
	public User selectUser(User user) throws SQLException, Exception;
	
	

}
