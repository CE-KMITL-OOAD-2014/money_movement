package sql_connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import connect_database.ManageConnection;
import connect_database.SelectIncomeOutlay;
import framework_azure.ChangeForSQL;

public class SQL_SelectIncomeOutlay implements SelectIncomeOutlay {

	@Override
	public ArrayList<IncomeOutlay> selectIncomeOutlay(User user,
			Date startDate, Date stopDate) throws Exception {
		
		// TODO Auto-generated method stub
		
		String stringStartDate = null;
		String stringStopDate = null;
		ArrayList<IncomeOutlay> list = new ArrayList<IncomeOutlay>();
		
		Connection connection = ManageConnection.getConnection(user.getUsername().hashCode());  
		Statement statement = connection.createStatement();
		
		String select = String.format("select * from incomeoutlay inner join type_incomeoutlay inner join priority ");
		String join = "on incomeoutlay.typeName = type_incomeoutlay.typeName and incomeoutlay.userId = type_incomeoutlay.userId "
				+ "and type_incomeoutlay.priorityId = priority.priorityId ";
		String where = String.format("where saveDate <= %s and saveDate >= %s and userId = %s", 
				ChangeForSQL.changeString(stringStopDate),
				ChangeForSQL.changeString(stringStartDate),
				ChangeForSQL.changeString(String.valueOf(user.getUsername().hashCode()))
				);
		String sqlCommand = select+join+where;
		
		ResultSet resultSet = statement.executeQuery(sqlCommand);
		
		while(resultSet.next())
		{
			String owner = resultSet.getString("");
			
		}
		
		
		
		return null;
	}
	
	

}
