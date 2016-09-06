package server;

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

import shared.data.User;


@RunWith(MockitoJUnitRunner.class)
public class BanditTest {

	
		@Mock
		Random generator;
		
		
		
		Bandit bandit;
		
		@Before
		public void setUp() {
			bandit = new Bandit();
		}
	
	@Test
	public void getSymbolsTest() {

	//	verify(Bandit.getSymbolOne(),1);
		
		assertEquals(8, bandit.getSymbolEight());
		
		
	}
	
	@Test
	public void setValuesTest() {
		bandit.setSymbolOne(7);
		assertEquals(7, bandit.getSymbolOne());
	}
	
	@Test
	public void whatPrizeTest() {
		assertEquals(3, bandit.whatPrize(3));
			}
	
	@Test 
	public void addPointsTest() {
		bandit.addPoints(10);
		assertEquals(10, bandit.getBank());
	}

	@Test
	public void cashOutTest() {
		bandit.addPoints(10);
		User user = mock(User.class);
		bandit.cashOut(5, user);
		//when(bandit.cashOut(10, user)).thenReturn();
		when(user.getPoints()).thenReturn(12);
	//	assertEquals(5, bandit.getBank());
		
	}
	
}