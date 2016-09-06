package shared.data;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class UserTest {

	@Test
	public void getStakeTest() {
		User user = mock(User.class);
		int u = 10;
		when(user.getStake()).thenReturn(u);
	}
	@Test
	public void getLoginTest() {
		User user = mock(User.class);
		String u = "ania";
		when(user.getLogin()).thenReturn(u);
	}
	@Test
	public void getPasswordTest() {
		User user = mock(User.class);
		String u = "haslo";
		when(user.getPassword()).thenReturn(u);
	}
	@Test
	public void getPointsTest() {
		User user = mock(User.class);
		int u = 100;
		when(user.getPoints()).thenReturn(u);
	}

}
