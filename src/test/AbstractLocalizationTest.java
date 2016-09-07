package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import shared.packet.Data;
import shared.resourcesLibrary.AbstractLocalization;

public class AbstractLocalizationTest {
	
	@Mock
	AbstractLocalization abstractLocalization;
	
	@Before
	public void setUp() {
		//abstractLocalization =new AbstractLocalization();
		abstractLocalization = mock(AbstractLocalization.class);
	}

	@Test
	public void getNameTest() {
		String zmienna = "piotr";
		when(abstractLocalization.getName()).thenReturn(zmienna);
		assertEquals(zmienna, abstractLocalization.getName());
	}
	
	
}
