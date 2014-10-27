package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import connect_database.DeleteIncomeOutlay;
import connect_database.ManageConnection;
import framework_azure.ChangeStringForSQL;
import manage_incomeoutlay.IncomeOutlay;

public class SQL_DeleteIncomeOutlay implements DeleteIncomeOutlay {

	@Override
	public boolean deleteIncomeOutlay(IncomeOutlay incomeOutlay) throws Exception {
		// TODO Auto-generated method stub
		int check = 0;
		int userId = incomeOutlay.getOwner().hashCode();
		String nameIncome = incomeOutlay.getNameIncomeOutlay();
		Date saveDate = incomeOutlay.getSaveDate();
		String stringSaveDate = null;
		
		
		String sqlCommand = String.format("Delete imcomeoutlay where userId=%s and saveDate=%s and name=%s", 
				ChangeStringForSQL.changeString(String.valueOf(userId)),
				ChangeStringForSQL.changeString(stringSaveDate),
				ChangeStringForSQL.changeString(nameIncome)
				) ;
		
		Connection conection = ManageConnection.getConnection(userId);
		Statement statement = conection.createStatement();
		check = statement.executeUpdate(sqlCommand);
		
		return check > 0;
	}

}