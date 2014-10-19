package unittest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import member_system.LoginAble;
import member_system.LoginManager;
import member_system.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import connect_database.SelectUser;
import framework_azure.Pair;

public class TestLoginManager {

@Mock public SelectUser mockSelectUser;
		
	public LoginManager loginManager;
	public ArrayList<Pair<User,User>> listTest ;
	
	@Before
	public void createUser()
	{
		User userCase1=new User("correct","correct");
		User userCase2=new User("correct","incorrect");
		User userCase3=new User("incorrect","correct");
		User userCase4=new User("incorrect","incorrect");
		User userCase5=new User(null,"correct");
		User userCase6=new User(null,"incorrect");
		User userCase7=new User("correct",null);
		User userCase8=new User("incorrect",null);
		User userCase9=new User(null,null);
		
		listTest = new ArrayList<Pair<User,User>>();
		listTest.add(new Pair(userCase1,userCase1));
		listTest.add(new Pair(userCase2,null));
		listTest.add(new Pair(userCase3,null));
		listTest.add(new Pair(userCase4,null));
		listTest.add(new Pair(userCase5,null));
		listTest.add(new Pair(userCase6,null));
		listTest.add(new Pair(userCase7,null));
		listTest.add(new Pair(userCase8,null));
		listTest.add(new Pair(userCase9,null));
		
		
	}
	@Before
	public void createMockSelectUser() throws SQLException, Exception
	{
		mockSelectUser = mock(SelectUser.class);
		/*
		when(mockSelectUser.selectUser(correctUser )).thenReturn(correctUser);
		when(mockSelectUser.selectUser(new User("correct","incorrect"))).thenReturn(null);
		when(mockSelectUser.selectUser(new User("incorrect","correct"))).thenReturn(null);
		when(mockSelectUser.selectUser(new User("incorrect","incorrect"))).thenReturn(null);
		when(mockSelectUser.selectUser(new User(null,"correct"))).thenReturn(null);
		when(mockSelectUser.selectUser(new User(null,"incorrect"))).thenReturn(null);
		when(mockSelectUser.selectUser(new User("correct",null))).thenReturn(null);
		when(mockSelectUser.selectUser(new User("incorrect",null))).thenReturn(null);
		when(mockSelectUser.selectUser(new User(null,null))).thenReturn(null);
		*/
		for(int i=0;i<listTest.size();i++)
		{
			Pair<User,User> temPair = listTest.get(i);
			when(mockSelectUser.selectUser(temPair.getFirst())).thenReturn(temPair.getSecound());
		}
		
		
	}
	@Before
	public void createLoginManager()
	{
		
	}
	
	


	@Test
	public void testLoginManager() {
		User outputUser;
		
		
		
		
		try 
		{
			loginManager = new LoginManager(mockSelectUser);
			
			for(int i=0;i<listTest.size();i++)
			{
				Pair<User,User> temPair = listTest.get(i);
				outputUser=loginManager.login(temPair.getFirst());
				assertEquals(temPair.getSecound(),outputUser);
			}
			
			
			//assertEquals("correct case",correctUser,loginManager.login((new User("correct","correct"))));
			/*
			assertEquals("correct incorrect",null,loginManager.login((new User("correct","incorrect"))));
			assertEquals("incorrect correct",null,loginManager.login((new User("incorrect","correct"))));
			assertEquals("incorrect incorrect",null,loginManager.login((new User("incorrect","incorrect"))));
			assertEquals("correct null",null,loginManager.login((new User("correct",null))));
			assertEquals("null correct",null,loginManager.login((new User(null,"correct"))));
			assertEquals("incorrect null",null,loginManager.login((new User("incorrect",null))));
			assertEquals("null incorrect",null,loginManager.login((new User(null,"incorrect"))));
			assertEquals("null null",null,loginManager.login((new User(null,null))));
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
