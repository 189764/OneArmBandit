package server.exceptions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class NotEnoughMoneyInBanditExceptionTest {

	@Test
	public void test() {
		
		NotEnoughMoneyInBanditException ex = new NotEnoughMoneyInBanditException();
		ex = mock(NotEnoughMoneyInBanditException.class);
		doThrow(new NotEnoughMoneyInBanditException()).when(ex).getSuppressed();
	}

}
