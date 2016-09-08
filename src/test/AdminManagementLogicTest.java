package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import client.frames.AdminManagementLogic;
import client.networkClient.DeliverToServer;
import server.Bandit;
import shared.data.User;

public class AdminManagementLogicTest {

	@Mock
	AdminManagementLogic adminManagementLogic;
	
	
	@Before
	public void setUp() {
		adminManagementLogic = new AdminManagementLogic(null, null);
	}
	
	@Test
	public void setSymbolValuesTest() {
		
//		AdminManagementLogic a = new AdminManagementLogic(null, null);
//		a = mock(AdminManagementLogic.class);
//		Mockito.doNothing().when(a).setSymbolValues(Matchers.anyObject());
		
		///
//		ArrayList<Integer> listOfSymbolValues = new ArrayList<Integer>();
//		listOfSymbolValues.add(2);
//		adminManagementLogic.setSymbolValues(listOfSymbolValues);
		//DeliverToServer deliverToServer = mock(DeliverToServer.class);
		//adminManagementLogic.setSymbolValues(null);
		//when(?).thenReturn(2);	
//		Mockito.doNothing().when(adminManagementLogic).setSymbolValues(Matchers.anyObject());
		
	}

}
