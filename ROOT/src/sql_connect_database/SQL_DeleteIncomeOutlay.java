package sql_connect_database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import connect_database.DeleteIncomeOutlay;
import connect_database.ManageConnection;
import framework_azure.ChangeForSQL;
import manage_incomeoutlay.IncomeOutlay;

public class SQL_DeleteIncomeOutlay implements DeleteIncomeOutlay {

	@Override
	public boolean deleteIncomeOutlay(IncomeOutlay incomeOutlay) throws Exception {
		// TODO Auto-generated method stub
		int check = 0;
		int userId = incomeOutlay.getOwner().hashCode();
		String nameIncome = incomeOutlay.getNameIncomeOutlay();
		Date saveDate = incomeOutlay.getSaveDate();
		String stringSaveDate = ChangeForSQL.changeDateToString(saveDate);
		
		
		String sqlCommand = String.format("Delete incomeoutlay where userId=%s and saveDate=%s and name=%s", 
				ChangeForSQL.changeString(String.valueOf(userId)),
				ChangeForSQL.changeString(stringSaveDate),
				ChangeForSQL.changeString(nameIncome)
				) ;
		
//		System.out.println(sqlCommand);
		
		Connection conection = ManageConnection.getConnection(userId);
		Statement statement = conection.createStatement();
		check = statement.executeUpdate(sqlCommand);
		
		return check > 0;
	}

}
