package connect_database;

import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.IncomeOutlay;

public interface SelectIncomeOutlay {
	public ArrayList<IncomeOutlay> selectIncomeOutlay(int userId,Date startDate,Date stopDate) throws Exception;
}
