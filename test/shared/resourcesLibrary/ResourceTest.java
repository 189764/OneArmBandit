package shared.resourcesLibrary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResourceTest {

	@Test
	public void getContentTest() {
		/*List<String> result = new ArrayList<String>();
		String name = "karolina";
	    result.add( name );
	    assertNotNull(result);*/
		Resource resource = mock(Resource.class);
		when(resource.getContent()).thenReturn(null);
	}
	@Test
	public void getContentTest2() {
		List<String> result = new ArrayList<String>();
		String name = "Karolinka";
		result.add( name );     
	    //assertEquals("karolina", result);
	    assertNotNull("Karolinka", result);
	}

	@Test
	public void getDirsTest() {
		Resource r = mock(Resource.class);
		List<String> result = new ArrayList<String>();
	    //result.add("katalog1");
		when(r.getDirs()).thenReturn(result);
	}	
}

