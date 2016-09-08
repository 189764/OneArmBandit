package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import shared.data.User;

public class UserTest {

	
	@Mock
	User user;
	
	
	@Before
	public void setUp() {
		
		user = mock(User.class);
	}
	
	
	@Test
	public void getStakeTest() {
		
		User u = new User(null, null, null, false);
		u.setStake(10);
		assertEquals(10, u.getStake());
	}
	
	
	@Test
	public void getLoginTest() {
		
		User u = new User(null, null, null, false);
		u.setLogin("example");
		assertEquals("example", u.getLogin());
	}
	
	
	@Test
	public void getPasswordTest() {
		
		User u = new User(null, null, null, false);
		u.setPassword("password");
		assertEquals("password", u.getPassword());
	}
	
	
	@Test
	public void getPointsTest() {
		
		User u = new User(null, null, null, false);
		u.setPoints(100);
		assertEquals(100, u.getPoints());
	}
	
	
	@Test
	public void getIsAdnimTest() {
		
		User u = new User(null, null, null, false);
		u.setIsAdmin(true);
		assertEquals(true, u.getIsAdmin());
	}
	
	
	@Test
	public void setAdnimTest() {
		
		User u = new User(null, null, null, false);
		u.setAdmin(true);
		assertEquals(true, u.getIsAdmin());
	}
	
//	@Test
//	public void addPointsTest() {
//
//		User a = new User(null, null, null, false);
//		a.addPoints(10);
//		when(a.addPoints(10)).thenReturn(10);
//	}

}
