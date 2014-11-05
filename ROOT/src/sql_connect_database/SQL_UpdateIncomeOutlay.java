package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import connect_database.InsertTypeIncomeOutlay;
import connect_database.ManageConnection;
import connect_database.SelectIncomeOutlay;
import connect_database.SelectTypeIncomeOutlay;
import connect_database.UpdateIncomeOutlay;
import framework_azure.ChangeForSQL;
import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public class SQL_UpdateIncomeOutlay implements UpdateIncomeOutlay{

	private SelectTypeIncomeOutlay selectTypeIncomeOutlay;
	private InsertTypeIncomeOutlay insertTypeIncomeOutlay;
	
	public SQL_UpdateIncomeOutlay(SelectTypeIncomeOutlay selectTypeIncomeOutlay,InsertTypeIncomeOutlay insertTypeIncomeOutlay) {
		// TODO Auto-generated constructor stub
		
		this.selectTypeIncomeOutlay = selectTypeIncomeOutlay;
		this.insertTypeIncomeOutlay = insertTypeIncomeOutlay;
	}
	
	@Override
	public boolean updateIncomeOutlay(IncomeOutlay oldIncomeOutlay,IncomeOutlay newIncomeOutlay) throws Exception {
		// TODO Auto-generated method stub
		int check = 0;
		Connection connection = ManageConnection.getConnection(oldIncomeOutlay.getOwner().hashCode());
		Statement statement = connection.createStatement();
		
		TypeOfUse temTypeOfUse = newIncomeOutlay.getTypeOfUse();
		User temUser = new User(newIncomeOutlay.getOwner(), null);
		
		if(selectTypeIncomeOutlay.selectTypeIncomeOutlay(temUser,temTypeOfUse)==null)
		{
			insertTypeIncomeOutlay.insertTypeIncomeOutlay(temUser,temTypeOfUse);
		}
		
		String sqlCommand = this.changeToSQL(oldIncomeOutlay, newIncomeOutlay);
		
		System.out.println(sqlCommand);
		
		check = statement.executeUpdate(sqlCommand);
		
		return check > 0;
	}
	
	private String changeToSQL(IncomeOutlay oldIncomeOutlay,IncomeOutlay newIncomeOutlay)
	{
		 int userId = newIncomeOutlay.getOwner().hashCode();
		 double amount = newIncomeOutlay.getAmount() ;
		 String nameIncomeOutlay = newIncomeOutlay.getNameIncomeOutlay();
		 Date saveDate = newIncomeOutlay.getSaveDate() ;
		 String saveDateString = ChangeForSQL.changeDateToString(saveDate);
		 String comment = newIncomeOutlay.getComment() ;
		 TypeOfUse typeOfUse = newIncomeOutlay.getTypeOfUse() ;
		 String typeName = typeOfUse.getTypeName();
		 String type = typeOfUse.getType();
		 String priority = typeOfUse.getPriority();
		 
		 String oldSaveDate = ChangeForSQL.changeDateToString(oldIncomeOutlay.getSaveDate());  
		 String oldName = oldIncomeOutlay.getNameIncomeOutlay();
		 
		 String updateHead = " Update incomeoutlay ";
		 String value = String.format(" SET userId=%s,name=%s,saveDate=%s,amount=%s,commentDetail=%s,typeName=%s",
				 ChangeForSQL.changeString(String.valueOf(userId)),
				 ChangeForSQL.changeString(nameIncomeOutlay),
				 ChangeForSQL.changeString(saveDateString),
				 ChangeForSQL.changeString(String.valueOf(amount)),
				 ChangeForSQL.changeString(comment),
				 ChangeForSQL.changeString(typeName)
				 );
		 String where = String.format(" where userId=%s and name=%s and saveDate=%s ",
				 ChangeForSQL.changeString(String.valueOf(userId)),
				 ChangeForSQL.changeString(oldName),
				 ChangeForSQL.changeString(oldSaveDate)
				 );
		return updateHead+value+where;
		
	}
	

}
