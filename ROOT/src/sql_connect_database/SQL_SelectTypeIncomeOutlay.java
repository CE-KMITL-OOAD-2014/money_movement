package sql_connect_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect_database.ManageConnection;
import connect_database.SelectTypeIncomeOutlay;
import framework_azure.ChangeForSQL;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public class SQL_SelectTypeIncomeOutlay implements SelectTypeIncomeOutlay {

	@Override
	public ArrayList<TypeOfUse> selectTypeIncomeOutlay(User user) throws Exception {
		// TODO Auto-generated method stub
		
		int userId = user.getUsername().hashCode();
		ArrayList<TypeOfUse> list = new ArrayList<TypeOfUse>();
		
		Connection connection = ManageConnection.getConnection(userId); 
		Statement statement = connection.createStatement();
		String sqlCommand = String.format("select * from type_incomeoutlay inner join priority on priority.priorityId=type_incomeoutlay.priorityId where userId=%s",
				ChangeForSQL.changeString(String.valueOf(userId))); 
		
		
	
		ResultSet resultSet = statement.executeQuery(sqlCommand);
			
		while(resultSet.next())
		{
			String typeName = resultSet.getString("typeName");
			String priorityName = resultSet.getString("priorityName");
			String type = resultSet.getString("type");
					
			TypeOfUse tem = new NomalTypeOfUser(typeName, type, priorityName);
			list.add(tem);
		}
		
		
			return list;
		
		
	}

	@Override
	public TypeOfUse selectTypeIncomeOutlay(User user, TypeOfUse typeOfUse) throws Exception {
		// TODO Auto-generated method stub
		
		int userId = user.getUsername().hashCode();
		String typeName = typeOfUse.getTypeName();  
		
		Connection connection = ManageConnection.getConnection(userId); 
		Statement statement = connection.createStatement();
		String sqlCommand = String.format("select * from type_incomeoutlay inner join priority on priority.priorityId=type_incomeoutlay.priorityId where userId=%s and typeName=%s",
				ChangeForSQL.changeString(String.valueOf(userId)),
				ChangeForSQL.changeString(String.valueOf(typeName))
				); 
		ResultSet resultSet = statement.executeQuery(sqlCommand);
			
		while(resultSet.next())
		{
			String priorityName = resultSet.getString("priorityName");
			String type = resultSet.getString("type");
					
			TypeOfUse tem = new NomalTypeOfUser(typeName, type, priorityName);
			return tem;
		}
		
		return null;
	}

}
