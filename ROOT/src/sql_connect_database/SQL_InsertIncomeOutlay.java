package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import connect_database.InsertIncomeOutlay;
import connect_database.InsertTypeIncomeOutlay;
import connect_database.ManageConnection;
import connect_database.SelectTypeIncomeOutlay;
import framework_azure.ChangeStringForSQL;
import framework_azure.ConvertNameId;
import manage_incomeoutlay.IncomeOutlay;
import manage_incomeoutlay.TypeOfUse;

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
		
		
		int userId = incomeOutlay.getOwner().hashCode();
		String typeName = incomeOutlay.getTypeOfUse().getTypeName();
		TypeOfUse typeOfUse;
		
		typeOfUse = this.selectTypeIncomeOutlay.selectTypeIncomeOutlay(userId, typeName);
		
		if(typeOfUse==null)
		{
			this.insertTypeIncomeOutlay.insertTypeIncomeOutlay(userId, typeOfUse);
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
		 String saveDateString = null;
		 
		 String comment = incomeOutlay.getComment() ;
		
		 TypeOfUse typeOfUse = incomeOutlay.getTypeOfUse() ;
		 
		 String typeName = typeOfUse.getTypeName();
		 String type = typeOfUse.getType();
		 String priority = typeOfUse.getPriority();
		 
		 String insertHead = "Insert into incomeoutlay(userId,name,saveDate,amount,commentDetail,typeName) ";
		 String value = String.format("%s,%s,%s,%s,%s,%s)",
				 ChangeStringForSQL.changeString(String.valueOf(userId)),
				 ChangeStringForSQL.changeString(nameIncomeOutlay),
				 ChangeStringForSQL.changeString(saveDateString),
				 ChangeStringForSQL.changeString(String.valueOf(amount)),
				 ChangeStringForSQL.changeString(comment),
				 ChangeStringForSQL.changeString(typeName)
				 )  ;
		return insertHead+value;
	}
}