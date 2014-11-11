package sql_connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;
import connect_database.CreateConnection;
import connect_database.CreateDistributeCon;
import connect_database.ManageConnection;
import connect_database.SelectIncomeOutlay;
import connect_database.SelectUser;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;

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
			///////////// INCOME  ///////////////////////////
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

	@Override
	public ArrayList<IncomeOutlay> selectIncomeOutlayWithJob(String jobName,
			Date startDate, Date stopDate) throws Exception {
		// TODO Auto-generated method stub
		
		int numDb = 2;
		ArrayList< ArrayList<IncomeOutlay>> listAll  = new ArrayList<ArrayList<IncomeOutlay>>();
		
		for(int i=0;i<2;i++)
		{
			ArrayList<IncomeOutlay> temList = this.getIncomeOutlayWithJob(jobName, startDate, stopDate, i);
			listAll.add(temList);
		}
		ArrayList<IncomeOutlay> returnList = new ArrayList<IncomeOutlay>();
		
		for(int i=0;i<numDb;i++)
		{
			ArrayList<IncomeOutlay> temList = listAll.get(i);
			returnList.addAll(temList);
		}
		
		return returnList;
	}
	
	
	private ArrayList<IncomeOutlay> getIncomeOutlayWithJob(String jobName,
			Date startDate, Date stopDate,int selectDB) throws Exception
			{

		Connection conn = new CreateDistributeCon().createConnection(selectDB);
		Statement statement = conn.createStatement();
		
		String stringStartDate = ChangeForSQL.changeDateToString(startDate);
		String stringStopDate = ChangeForSQL.changeDateToString(stopDate);
		String jobId = ConvertNameId.getObject().nameToId("job", jobName);
		ArrayList<IncomeOutlay> list = new ArrayList<IncomeOutlay>();
		
		String sql_select = "select * from incomeoutlay ";
		String sql_join = 
				" inner join user_data "
				+ " on incomeoutlay.userId = user_data.userId "
				+"inner join type_incomeoutlay"
				+ " on incomeoutlay.typeName = type_incomeoutlay.typeName and incomeoutlay.userId = type_incomeoutlay.userId "
				+ "inner join priority "
				+ " on type_incomeoutlay.priorityId = priority.priorityId ";
		String where = String.format("where saveDate <= %s and saveDate >= %s and jobId =%s ", 
				ChangeForSQL.changeString(stringStopDate),
				ChangeForSQL.changeString(stringStartDate),
				ChangeForSQL.changeString(jobId)
				);
		
		String sql_command = sql_select+sql_join+where;
		
	//	System.out.println(sql_command);
		
		ResultSet resultSet = statement.executeQuery(sql_command);
		
		while(resultSet.next())
		{
			///////////// INCOME  ///////////////////////////
			String owner = resultSet.getString("username");
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
		
		return list;		
	}
	
}
