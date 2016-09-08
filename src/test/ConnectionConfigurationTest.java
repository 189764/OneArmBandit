package test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import shared.ConnectionConfiguration;

@RunWith(MockitoJUnitRunner.class)

public class ConnectionConfigurationTest {

	
	ConnectionConfiguration conf;
	
	@Before
	public void setUp() {
		
	conf = ConnectionConfiguration.buildConfiguration();
		
	}
	
	@Test
	 public void getAddressTest() {
		
	  assertEquals("127.0.0.1",conf.getAddress());
	 }
	 
	 @Test
	 public void getPortTest() {
		 
	  assertEquals(503,conf.getPort());
	 }
	

}
