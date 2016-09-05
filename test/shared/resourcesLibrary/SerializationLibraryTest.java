package shared.resourcesLibrary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SerializationLibraryTest {

	
	@Test
	public void createSavingPathToDirsTest() {
		SerializationLibrary a = mock(SerializationLibrary.class);
		List<String> result = new ArrayList<String>();
		result.add("M");
		result.add("h");
		when(a.createSavingPathToDirs(result)).thenReturn(".xml");
	}

}
