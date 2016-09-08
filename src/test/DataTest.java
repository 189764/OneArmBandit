package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import shared.packet.Data;
import shared.packet.Instruction;


public class DataTest {
	
	private static final Object[][] Object = null;
	@Mock
	Data data;
	
	@Before
	public void setUp() {
		data =new Data();
		//data = mock(Data.class);
	}
	
	@Test
	public void getPointsTest() {

		data.setPoints(50);
		assertEquals(50, data.getPoints());
	}
	
	@Test
	public void isAdminTest() {
		
		data.setIsAdmin(true);
		//when(data.getIsAdmin()).thenReturn(true);
		assertEquals(true, data.getIsAdmin());
		
	}
	
	@Test
	public void getLoginTest() {
		
		data.setLogin("admin");
		//when(data.getLogin()).thenReturn("admin");
		assertEquals("admin", data.getLogin());
	}
	
	@Test
	public void getPasswordTest() {
		
		data.setPassword("admin");
		//when(data.getPassword()).thenReturn("admin");
		assertEquals("admin", data.getPassword());
	}
	
	@Test
	public void getInstructionTest() {
		
		Instruction instruction = Instruction.LOG_IN;
		data.setInstruction(instruction);
		//when(data.getInstruction()).thenReturn(instruction);
		assertEquals(instruction, data.getInstruction());
	}
	
	@Test
	public void getListOfSymbolValuesTest() {
		
		ArrayList<Integer> listOfSymbolValues = new ArrayList<Integer>();
		listOfSymbolValues.add(4);
		listOfSymbolValues.add(5);
		listOfSymbolValues.add(6);
		
		data.setListOfSymbolValues(listOfSymbolValues);
		//when(data.getListOfSymbolValues()).thenReturn(listOfSymbolValues);
		assertEquals(listOfSymbolValues, data.getListOfSymbolValues());
		
	}
	
	/*@Test
	public void getRankingTest() {
		Object[][] ob = null;
		data.setRanking(ob);
		//when(data.getPassword()).thenReturn("admin");
		assertEquals("admin", data.getRanking());
	}*/


}
