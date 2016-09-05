package server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class BanditTest {

	@Test
	public void getSymbolOneTest() {
		Bandit b = mock(Bandit.class);
		when(b.getSymbolOne()).thenReturn(10);
		verify(b).getSymbolOne();
		verify(b).setSymbolOne(10);
	}

}
