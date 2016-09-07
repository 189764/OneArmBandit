package shared.data;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class UserTest {

	
	@Mock
	User user;
	
	
	@Before
	public void setUp() {
		user = mock(User.class);
	}
	
	
	@Test
	public void getStakeTest() {
		
		user.setStake(10);
		when(user.getStake()).thenReturn(10);
		assertEquals(10, user.getStake());
	}
	
	
	@Test
	public void getLoginTest() {
		
		user.setLogin("example");
		when(user.getLogin()).thenReturn("example");
		assertEquals("example", user.getLogin());
	}
	
	
	@Test
	public void getPasswordTest() {
		
		user.setPassword("password");
		when(user.getPassword()).thenReturn("password");
		assertEquals("password", user.getPassword());
	}
	
	
	@Test
	public void getPointsTest() {
		
		user.setPoints(100);
		when(user.getPoints()).thenReturn(100);
		assertEquals(100, user.getPoints());
	}
	
	
	@Test
	public void getIsAdnimTest() {
		user.setIsAdmin(true);
		when(user.getIsAdmin()).thenReturn(true);
		assertEquals(true, user.getIsAdmin());
	}

}
