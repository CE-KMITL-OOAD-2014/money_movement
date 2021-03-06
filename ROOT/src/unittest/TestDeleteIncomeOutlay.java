package unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import manage_incomeoutlay.AddIncomeOutlayManager;
import manage_incomeoutlay.DeleteIncomeOutlayManager;
import manage_incomeoutlay.IncomeOutlay;
import member_system.User;
import member_system.VerifyAble;

import org.junit.Before;
import org.junit.Test;

import connect_database.DeleteIncomeOutlay;
import connect_database.InsertIncomeOutlay;
import framework_azure.Pair;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TestDeleteIncomeOutlay {

	public DeleteIncomeOutlayManager deleteIncomeOutlayManager;
	public VerifyAble mockVerify;
	public DeleteIncomeOutlay mockDeleteIncomeOutlay;
	
	public ArrayList<Pair<Pair<User,IncomeOutlay>,Boolean>> listTest = new ArrayList<Pair<Pair<User,IncomeOutlay>,Boolean>>();
	public User userCase1 = new User("correct",null,"correct",null);
	public User userCase2 = new User("correct",null, "incorrect",null); 
	public User userCase3 = new User("incorrect",null, "correct",null); 
	public User userCase4 = new User("correct",null, null,null); 
	public User userCase5 = new User("incorrect",null, null,null); 
		
	// case 1 income have in database
		public IncomeOutlay incomeOutlayCase1= new IncomeOutlay("correct", null, 100.0, null, null, null); 
		
	// case 2 income don't have in database
		public IncomeOutlay incomeOutlayCase2 =new  IncomeOutlay("incorrect", null, 1001.0, null, null, null); ;
	
		Pair<User,IncomeOutlay> pair1 = new Pair<User, IncomeOutlay>(userCase1, incomeOutlayCase1);
		Pair<User,IncomeOutlay> pair2 = new Pair<User, IncomeOutlay>(userCase1, incomeOutlayCase2);
		Pair<User,IncomeOutlay> pair3 = new Pair<User, IncomeOutlay>(userCase2, incomeOutlayCase1);
		Pair<User,IncomeOutlay> pair4 = new Pair<User, IncomeOutlay>(userCase2, incomeOutlayCase2);
		Pair<User,IncomeOutlay> pair5 = new Pair<User, IncomeOutlay>(userCase3, incomeOutlayCase1);
		Pair<User,IncomeOutlay> pair6 = new Pair<User, IncomeOutlay>(userCase3, incomeOutlayCase2);
		Pair<User,IncomeOutlay> pair7 = new Pair<User, IncomeOutlay>(userCase4, incomeOutlayCase1);
		Pair<User,IncomeOutlay> pair8 = new Pair<User, IncomeOutlay>(userCase4, incomeOutlayCase2);
		Pair<User,IncomeOutlay> pair9 = new Pair<User, IncomeOutlay>(userCase5, incomeOutlayCase1);
		Pair<User,IncomeOutlay> pair10 = new Pair<User, IncomeOutlay>(userCase5, incomeOutlayCase2);
			
		@Before
		public void createMockVerify() throws Exception
		{
			mockVerify = mock(VerifyAble.class);
			when(mockVerify.verify(userCase1)).thenReturn(true);
			when(mockVerify.verify(userCase2)).thenReturn(false);
			when(mockVerify.verify(userCase3)).thenReturn(false);
			when(mockVerify.verify(userCase4)).thenReturn(false);
			when(mockVerify.verify(userCase5)).thenReturn(false);
			
		}
	
		@Before
		public void createMockInsertIncomeOutlay() throws Exception
		{
			mockDeleteIncomeOutlay = mock(DeleteIncomeOutlay.class);
			
			when(mockDeleteIncomeOutlay.deleteIncomeOutlay(incomeOutlayCase1)).thenReturn(true);
			when(mockDeleteIncomeOutlay.deleteIncomeOutlay(incomeOutlayCase2)).thenReturn(false);
		}
		
		
		
	@Test
	public void test() throws Exception {
		
		deleteIncomeOutlayManager = new DeleteIncomeOutlayManager(mockVerify, mockDeleteIncomeOutlay) ;
		
		for(int i=0;i<listTest.size();i++)
		{
			User temUser = listTest.get(i).getFirst().getFirst();
			IncomeOutlay temIncomeOutlay = listTest.get(i).getFirst().getSecound();
			boolean correctData = listTest.get(i).getSecound();
			
			boolean check = deleteIncomeOutlayManager.deleteIncomeOutlay(temUser, temIncomeOutlay);
			
			assertEquals(correctData, check);
		}
		
		
	}

}
