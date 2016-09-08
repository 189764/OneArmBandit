package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import server.Bandit;
import server.CentralBank;




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
 