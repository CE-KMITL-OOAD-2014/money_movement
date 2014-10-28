package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;

import connect_database.InsertTypeIncomeOutlay;
import connect_database.ManageConnection;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public class SQL_InsertTypeIncomeOutlay implements InsertTypeIncomeOutlay {

	@Override
	public boolean insertTypeIncomeOutlay(User user, TypeOfUse typeOfuse) throws Exception {
		// TODO Auto-generated method stub
		
		int check = 0;
		ConvertNameId convert = ConvertNameId.getObject();
		
		
		int userId = user.getUsername().hashCode();
		String typeName = typeOfuse.getTypeName();
		String priority = typeOfuse.getPriority();
		String type =typeOfuse.getType(); 
		String priorityId = convert.nameToId("priority",priority);
		
		Connection conection = ManageConnection.getConnection(userId);
		Statement statement = conection.createStatement();
		
		 
		String sqlCommand = String.format("Insert into type_incomeoutlay (typeName,userId,priorityId,type) values(%s,%s,%s,%s)", 
					ChangeForSQL.changeString(typeName),
					ChangeForSQL.changeString(String.valueOf(userId)),
					ChangeForSQL.changeString(priorityId),
					ChangeForSQL.changeString(type)
				);
		
		check=statement.executeUpdate(sqlCommand);
		
		return check > 0;
	}
}
