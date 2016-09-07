package client.networkClient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DeliverToServerTest {
	
	@Mock
	private ServerConnector serverConnector;
	
	@Before
	public void setUp() {
		serverConnector = mock(ServerConnector.class);
	}

	@Test
	public void test() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.askPoints("login");
	}
	
	@Test
	public void test2() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.transferPoints(10);
		//Mockito.doNothing().when(serverConnector);
		//when(dts.transferPoints(10)).thenReturn(10);
		//assertEquals(10, dts.transferPoints(10));
	}
	
	@Test
	public void test3() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.askRanking("admin");
	}
	
	@Test
	public void test4() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.play("admin", 1);
	}
	
	@Test
	public void test5() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.logOut("admin");
	}
	
	@Test
	public void test7() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.changePassword("admin","admin");
	}
	
	@Test
	public void test8() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.register("admin","admin");
	}
	
	@Test
	public void test9() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		dts.logIn("admin","admin");
	}
	
	@Test
	public void test10() {
		DeliverToServer dts = new DeliverToServer(serverConnector);
		ArrayList<Integer> listOfSymbolValues = new ArrayList<Integer>();
		listOfSymbolValues.add(3);
		listOfSymbolValues.add(4);
		dts.setSymbols(listOfSymbolValues);
	}
}
