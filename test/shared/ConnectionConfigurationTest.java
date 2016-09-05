package shared;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Test;

public class ConnectionConfigurationTest {

	//klasy fina nie testujemy!!!
	@Test
	public void buildConfigurationTest() {
		
		Iterator i = mock(Iterator.class);
		//when(i.next()).thenReturn("Successfuly").thenReturn("loaded").thenReturn("values").thenReturn("from").thenReturn("config.properties").thenReturn("file");
		//doReturn("Successfuly").doReturn("loaded").doReturn("values").doReturn("from").doReturn("config.properties").doReturn("file").when(i).next();
		doReturn("Successfuly").when(i);
		Iterator result = i;
		assertEquals("Successfuly", result);
		
		
	}

}
