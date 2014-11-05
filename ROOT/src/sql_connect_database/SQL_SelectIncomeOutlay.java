package sql_connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;
import connect_database.ManageConnection;
import connect_database.SelectIncomeOutlay;
import connect_database.SelectUser;
import framework_azure.ChangeForSQL;

public class SQL_SelectIncomeOutlay implements SelectIncomeOutlay {

	
	@Override
	public ArrayList<IncomeOutlay> selectIncomeOutlay(User user,
			Date startDate, Date stopDate) throws Exception {
		
		// TODO Auto-generated method stub
		
		String stringStartDate = ChangeForSQL.changeDateToString(startDate);
		String stringStopDate = ChangeForSQL.changeDateToString(stopDate);
		ArrayList<IncomeOutlay> list = new ArrayList<IncomeOutlay>();
		
		Connection connection = ManageConnection.getConnection(user.getUsername().hashCode());  
		Statement statement = connection.createStatement();
		
		String select = String.format("select * from incomeoutlay ");
		String join = "inner join type_incomeoutlay"
				+ " on incomeoutlay.typeName = type_incomeoutlay.typeName and incomeoutlay.userId = type_incomeoutlay.userId "
				+ "inner join priority "
				+ "on type_incomeoutlay.priorityId = priority.priorityId ";
		String where = String.format("where saveDate <= %s and saveDate >= %s and incomeoutlay.userId = %s", 
				ChangeForSQL.changeString(stringStopDate),
				ChangeForSQL.changeString(stringStartDate),
				ChangeForSQL.changeString(String.valueOf(user.getUsername().hashCode()))
				);
		String sqlCommand = select+join+where;
		
		System.out.println(sqlCommand);
		
		ResultSet resultSet = statement.executeQuery(sqlCommand);
		
		while(resultSet.next())
		{
			///////////// INCOME OUTLY ///////////////////////////
			String owner = user.getUsername();
			String nameIncomeOutlay = resultSet.getString("name");
			double amount = resultSet.getDouble("amount");
			String saveDateString = resultSet.getString("saveDate");
			String comment = resultSet.getString("commentDetail");
			 
			Date saveDate = ChangeForSQL.changeStringToDate(saveDateString);
			
			////////////////////////////////////////////////////
			
			//////////////////// TYPE OF USE ///////////////////////
			
			 String priorityName = resultSet.getString("priorityName");
			 String typeName = resultSet.getString("typeName");
			 String type = resultSet.getString("type");
			 
			//////////////////////////////////////////////////////////////////////////
			 
			 TypeOfUse typeOfUse = new NomalTypeOfUser(typeName, type, priorityName);
			 
			 IncomeOutlay incomeOutlay = new IncomeOutlay(owner, nameIncomeOutlay, amount, saveDate, typeOfUse, comment);
			 
//			 System.out.println(incomeOutlay);
			 
			 list.add(incomeOutlay);
		}
		
		if(list.size()==0)
		{
			return null;
		}
		else
		{
			return list;
		}
	}
}
