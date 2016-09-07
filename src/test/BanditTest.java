package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import server.Bandit;
import server.exceptions.NotEnoughMoneyInBanditException;
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

		assertEquals(1, bandit.getSymbolOne());
		assertEquals(2, bandit.getSymbolTwo());
		assertEquals(3, bandit.getSymbolThree());
		assertEquals(4, bandit.getSymbolFour());
		assertEquals(5, bandit.getSymbolFive());
		assertEquals(6, bandit.getSymbolSix());
		assertEquals(7, bandit.getSymbolSeven());
		assertEquals(8, bandit.getSymbolEight());
		assertEquals(9, bandit.getSymbolNine());
	}
	
	@Test
	public void setSymboleOneTest() {
		
		bandit.setSymbolOne(10);
		assertEquals(10, bandit.getSymbolOne());
	}
	
	
	@Test
	public void setSymbolTwoTest() {
		
		bandit.setSymbolTwo(10);
		assertEquals(10, bandit.getSymbolTwo());
	}
	
	
	@Test
	public void setSymbolThreeTest() {
		
		bandit.setSymbolThree(10);
		assertEquals(10, bandit.getSymbolThree());
	}
	
	
	@Test
	public void setSymbolFourTest() {
		
		bandit.setSymbolFour(10);
		assertEquals(10, bandit.getSymbolFour());
	}
	
	
	@Test
	public void setSymbolFiveTest() {
		
		bandit.setSymbolFive(10);
		assertEquals(10, bandit.getSymbolFive());
	}
	
	
	@Test
	public void setSymbolSixTest() {
		
		bandit.setSymbolSix(10);
		assertEquals(10, bandit.getSymbolSix());
	}
	
	
	@Test
	public void setSymbolSevenTest() {
		
		bandit.setSymbolSeven(10);
		assertEquals(10, bandit.getSymbolSeven());
	}
	
	
	@Test
	public void setSymbolEightTest() {
		
		bandit.setSymbolEight(10);
		assertEquals(10, bandit.getSymbolEight());
	}
	
	
	@Test
	public void setSymbolNineTest() {
		
		bandit.setSymbolNine(10);
		assertEquals(10, bandit.getSymbolNine());
	}
	
	
	@Test
	public void whatPrizeTest() {
		
		assertEquals(3, bandit.whatPrize(3));
	}
	
	
	@Test 
	public void addPointsTest() {
		
		bandit = mock(Bandit.class);
		bandit.addPoints(10);
		when(bandit.getBank()).thenReturn(10);
		assertEquals(10, bandit.getBank());
	}

	
	@Test
	public void cashOutTest() {
		
		bandit.addPoints(10);
		User user = mock(User.class);
		bandit.cashOut(5, user);
		when(user.getPoints()).thenReturn(12);		
	}
	
	
	@Test
	public void getBangTest() {
		
		Bandit b = new Bandit();
		b.setBank(11);
		assertEquals(11, b.getBank());
	}
	
	
	@Test
	public void increaseBankLevelTest() {
		
		bandit = mock(Bandit.class);
		bandit.increaseBankLevel(5);
		when(bandit.getBank()).thenReturn(5);
		assertEquals(5, bandit.getBank());
	}
	
	
	@Test
	public void decreaseBankLevelTest() {
		
		bandit = mock(Bandit.class);
		bandit.decreaseBankLevel(5);
		when(bandit.getBank()).thenReturn(5);
		assertEquals(5, bandit.getBank());
	}
	
	
	@Test
	public void exceptionsTest() throws NotEnoughMoneyInBanditException {
		
		bandit = mock(Bandit.class);
		doThrow(new NotEnoughMoneyInBanditException()).when(bandit).getBank();
	}
	
	
	@Test
	public void randomSymbolsTest() {
		//bandit = mock(Bandit.class);
		//Mockito.doNothing().when(bandit).randomSymbols();
		
		//Bandit b = new Bandit();
		//b.randomSymbols();
	}
	
	
	@Test
	public void betTest() {
//		bandit = mock(Bandit.class);
//		//User user = mock(User.class);
//		User user = new User(null, null, null, false);
//		Integer[][] table = new Integer[2][2];
//		table = new Integer[][]{{2,2}, {3,3}};
//		bandit.bet(user);
//		when(bandit.bet(user)).thenReturn(table);
//		assertEquals(table, bandit.bet(user));
//		////
//		User b = mock(User.class);
//		bandit.bet(b);
//		when(bandit.bet(b)).thenReturn(table);
	}
	
}