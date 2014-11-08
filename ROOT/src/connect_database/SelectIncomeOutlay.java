package connect_database;

import java.util.ArrayList;
import java.util.Date;

import manage_incomeoutlay.IncomeOutlay;
import member_system.User;

public interface SelectIncomeOutlay {
	public ArrayList<IncomeOutlay> selectIncomeOutlay(User user,Date startDate,Date stopDate) throws Exception;
	public ArrayList<IncomeOutlay> selectIncomeOutlayWithJob(String jobName,Date startDate,Date stopDate) throws Exception;
	
}
