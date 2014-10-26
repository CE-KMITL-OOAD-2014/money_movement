package connect_database;

import java.sql.Connection;

public interface CreateConnection {
	
	public Connection createConnection(long selectValue) throws Exception;

}
