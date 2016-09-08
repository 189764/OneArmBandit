package test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import server.Bandit;
import server.CentralBank;
import shared.data.User;




public class CentralBankTests {

	CentralBank bank;
	
	@Mock
	Bandit bandit;
	
	@Before
	public void setUp() {
	 bank = new CentralBank();
	
	}
	
	@Test
	public void getPointsTest() {
		assertEquals(0, bank.getPoints());
		
	}
	
	@Test
	public void setPointsTest() {
		bank.setPoints(5000);
		assertEquals(5000,bank.getPoints());	
	}
	
}
 