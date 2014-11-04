package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import connect_database.InsertIncomeOutlay;
import connect_database.InsertTypeIncomeOutlay;
import connect_database.ManageConnection;
import connect_database.SelectTypeIncomeOutlay;
import framework_azure.ChangeForSQL;
import framework_azure.ConvertNameId;
import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import member_system.User;

public class SQL_InsertIncomeOutlay implements InsertIncomeOutlay{

	private SelectTypeIncomeOutlay selectTypeIncomeOutlay;
	private InsertTypeIncomeOutlay insertTypeIncomeOutlay;
	
	
	
	public SQL_InsertIncomeOutlay(SelectTypeIncomeOutlay selectTypeIncomeOutlay,InsertTypeIncomeOutlay insertTypeIncomeOutlay)
	{
		this.selectTypeIncomeOutlay = selectTypeIncomeOutlay;
		this.insertTypeIncomeOutlay = insertTypeIncomeOutlay;
	}
		
	@Override
	public boolean insertIncomeOutlay(IncomeOutlay incomeOutlay) throws Exception {
		// TODO Auto-generated method stub
		int check = 0;
		
		User temUser = new User(incomeOutlay.getOwner(), null);
		int userId = incomeOutlay.getOwner().hashCode();
		String typeName = incomeOutlay.getTypeOfUse().getTypeName();
		
		
		TypeOfUse typeOfUse = incomeOutlay.getTypeOfUse(); 
		TypeOfUse checkTypeOfUse;
		
		checkTypeOfUse = this.selectTypeIncomeOutlay.selectTypeIncomeOutlay(temUser, typeOfUse);
		
		if(checkTypeOfUse==null)
		{
			this.insertTypeIncomeOutlay.insertTypeIncomeOutlay(temUser, typeOfUse);
		}
		
		String sqlCommand = this.changeIncomeOutlayToSQL(incomeOutlay) ;
		
	
		
		Connection conection = ManageConnection.getConnection(incomeOutlay.getOwner().hashCode());
		Statement statement = conection.createStatement();
		check = statement.executeUpdate(sqlCommand);
		
		return check > 0;
	}
	
	private String changeIncomeOutlayToSQL(IncomeOutlay incomeOutlay)
	{
		 int userId = incomeOutlay.getOwner().hashCode();
		 double amount = incomeOutlay.getAmount() ;
		 String nameIncomeOutlay = incomeOutlay.getNameIncomeOutlay();
		 
		 Date saveDate = incomeOutlay.getSaveDate() ;
		 String saveDateString = ChangeForSQL.changeDateToString(saveDate);
		 
		 String comment = incomeOutlay.getComment() ;
		
		 TypeOfUse typeOfUse = incomeOutlay.getTypeOfUse() ;
		 
		 String typeName = typeOfUse.getTypeName();
		 String type = typeOfUse.getType();
		 String priority = typeOfUse.getPriority();
		 
		 String insertHead = "Insert into incomeoutlay(userId,name,saveDate,amount,commentDetail,typeName) ";
		 String value = String.format("values(%s,%s,%s,%s,%s,%s)",
				 ChangeForSQL.changeString(String.valueOf(userId)),
				 ChangeForSQL.changeString(nameIncomeOutlay),
				 ChangeForSQL.changeString(saveDateString),
				 ChangeForSQL.changeString(String.valueOf(amount)),
				 ChangeForSQL.changeString(comment),
				 ChangeForSQL.changeString(typeName)
				 )  ;
		return insertHead+value;
	}
}