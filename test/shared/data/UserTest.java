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

}
