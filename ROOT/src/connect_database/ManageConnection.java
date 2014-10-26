package connect_database;

import java.sql.Connection;

public class ManageConnection {
	
	public static Connection getConnection(long selectData) throws Exception
	{
		Connection tem =null ;
		CreateConnection myConnection = new CreateDistributeCon();
		tem = myConnection.createConnection( selectData  );
		
		return tem ;
	}
	
	public static boolean closeConnection(Connection conn) throws Exception 
	{
			// TODO Auto-generated method stub
			
			try
			{
				conn.close();
				return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw(ex);
			}
	}
}
