package shared.resourcesLibrary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SerializationLibraryTest {

	@Test
	public void test() {
		SerializationLibrary a = mock(SerializationLibrary.class);
		SerializationLibrary b = mock(SerializationLibrary.class);
		//when(a.saveMe()).thenReturn(b.loadMe());
		//verify(a).saveMe();
	}
	
	@Test
	public void createSavingPathToDirsTest() {
		SerializationLibrary a = mock(SerializationLibrary.class);
		List<String> result = new ArrayList<String>();
		result.add("M");
		result.add("K");
		when(a.createSavingPathToDirs(result)).thenReturn("M", "K");
	}

}
