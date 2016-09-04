package shared.resourcesLibrary;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResourceTest {

	@Test
	public void getContentTest() {
		Resource r = mock(Resource.class);
		//List<String> result = new ArrayList<String>();
		when(r.getContent()).thenReturn(anyObject());
	}
	
	@Test
	public void getDirsTest() {
		Resource r = mock(Resource.class);
		List<String> result = new ArrayList<String>();
		when(r.getDirs()).thenReturn(result);
	}

	
	
}
