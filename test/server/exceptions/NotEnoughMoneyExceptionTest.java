package server.exceptions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class NotEnoughMoneyExceptionTest {

	@Test
	public void test() {
		
		NotEnoughMoneyException ex = new NotEnoughMoneyException();
		ex = mock(NotEnoughMoneyException.class);
		doThrow(new NotEnoughMoneyException()).when(ex).getSuppressed();
	}

}
