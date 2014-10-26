package connect_database;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateDistributeCon implements CreateConnection  {

	@Override
	public Connection createConnection(long selectValue) throws Exception {
		
		if(selectValue%2==0)
		{
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection conn;
				String conString;
				
				conString = "jdbc:sqlserver://yu80jv1m51.database.windows.net:1433;"
						+ "database=db_moneymovement;"
						+ "user=samander@yu80jv1m51;"
						+ "password=Xzrw8Cjx;"
						+ "encrypt=true;hostNameInCertificate=*.database.windows.net;"
						+ "loginTimeout=30;";
				conn = DriverManager.getConnection(conString);
				return conn;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw(ex);
			}
		}
		else
		{
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection conn;
				String conString;
				
				conString = "jdbc:sqlserver://b0sn48wkw8.database.windows.net:1433;"
						+ "database=db_moneymovement;"
						+ "user=samander2@b0sn48wkw8;"
						+ "password=Xzrw8Cjx;"
						+ "encrypt=true;hostNameInCertificate=*.database.windows.net;"
						+ "loginTimeout=30;";
				conn = DriverManager.getConnection(conString);
				return conn;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw(ex);
			}
		}
	}
}
