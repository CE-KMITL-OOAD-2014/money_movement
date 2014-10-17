package member_system;

import java.sql.SQLException;

public interface LoginAble {
	public User login(User user) throws SQLException, Exception;
	
}
