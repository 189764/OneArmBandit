package server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import shared.packet.Data;

public class CentralBankTest {
	
	@Mock
	CentralBank cb;
	
	@Before
	public void setUp() {
		cb =new CentralBank();
	}

	@Test
	public void test() {
		cb.setPoints(40);
		assertEquals(40, cb.getPoints());
	}

}
