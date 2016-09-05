package shared;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;

import org.junit.Test;


public class ConnectionConfigurationTest {

	/*@Test(expected=FileNotFoundException.class)
	public void test() {
		ConnectionConfiguration object= mock(ConnectionConfiguration.class);
		when(object.buildConfiguration()).thenThrow(new FileNotFoundException());
	}*/
	@Test
	public void test2() {
		ConnectionConfiguration object= mock(ConnectionConfiguration.class);
		//String s = "Successfuly loaded values from config.properties file";
		//when(object.buildConfiguration()).thenReturn(s);
		verify(object).buildConfiguration();
	}

}
