package unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import connect_database.InsertUser;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class TestRegisterManager {

	public InsertUser insertUser;
	
	
	
	
	
	@Before
	public void createMockInsertUser()
	{
		insertUser = mock(InsertUser.class);
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
