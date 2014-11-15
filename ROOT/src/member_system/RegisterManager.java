package member_system;

import java.util.ArrayList;

import sql_connect_database.SQL_InsertTypeIncomeOutlay;
import manage_incomeoutlay.NomalTypeOfUser;
import manage_incomeoutlay.TypeOfUse;
import connect_database.InsertIncomeOutlay;
import connect_database.InsertTypeIncomeOutlay;
import connect_database.InsertUser;



public class RegisterManager implements RegisterAble {

	private InsertUser insertUser;
	
	
	public RegisterManager(InsertUser insertUser) {
		// TODO Auto-generated constructor stub
		this.insertUser = insertUser;
	}
	
	@Override
	public User register(User user) throws Exception {
	
		boolean check;
		
		try
		{
			check = insertUser.insertUser(user);
			
			if(check)
			{
				this.addTypeIncomeOutlay(user);
				return user;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			throw(ex);
		}
	}

	private void addTypeIncomeOutlay(User user) throws Exception
	{
		String income = "income";
		String outcome = "outcome";
		String low = "low";
		String avg = "avg";
		String height = "height";
		
		InsertTypeIncomeOutlay insertTypeIncomeOutlay = new SQL_InsertTypeIncomeOutlay();
		
		ArrayList<TypeOfUse> allType = new ArrayList<TypeOfUse>();
		
		allType.add( new NomalTypeOfUser("ค่าอาหาร",outcome, height));
		allType.add( new NomalTypeOfUser("ค่าที่พักอาศัย",outcome, height));
		allType.add( new NomalTypeOfUser("ค่าสารณูปโภคที่สำคัญ",outcome, height));
		allType.add( new NomalTypeOfUser("ค่าเดินทางที่สำคัญ",outcome, height));
		allType.add( new NomalTypeOfUser("ค่าใช้จ่ายภายในบ้าน",outcome, avg));
		allType.add( new NomalTypeOfUser("ค่าเสื้อผ้า",outcome, avg));
		allType.add( new NomalTypeOfUser("ค่ารักษาพยาบาลเมื่อเจ็บป่วย",outcome, avg));
		allType.add( new NomalTypeOfUser("ค่าพักผ่อนสังสรรค์",outcome, low));
		allType.add( new NomalTypeOfUser("ค่าของขวัญในงานมงคลต่างๆ",outcome, low));
		
		allType.add( new NomalTypeOfUser("เงินเดือน",income, height));
		allType.add( new NomalTypeOfUser("ดอกเบี้ย",income, height));
		allType.add( new NomalTypeOfUser("เงินปันผล",income, height));
		allType.add( new NomalTypeOfUser("รายได้เสริม",income, height));
		
		for(int i=0;i<allType.size();i++)
		{
			TypeOfUse typeOfuse = allType.get(i);
			insertTypeIncomeOutlay.insertTypeIncomeOutlay(user, typeOfuse);
		}	
	}

}
