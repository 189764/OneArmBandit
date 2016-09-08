package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import shared.resourcesLibrary.SerializationLibrary;

public class SerializationLibraryTest {
	
	@Test
	public void createSavingPathToDirsTest() {
		SerializationLibrary a = mock(SerializationLibrary.class);
		List<String> result = new ArrayList<String>();
		result.add("M");
		result.add("K");
		when(a.createSavingPathToDirs(result)).thenReturn("M", "K");
	}
	@Test
	public void isSavingStructureProperTest() {
		SerializationLibrary a = new SerializationLibrary(null);
		//SerializationLibrary a = mock(SerializationLibrary.class);
		assertEquals(true, a.isSavingStructureProper("::"));
	}
	
	@Test
	public void isSavingStructureProperTestNotOk() {
		SerializationLibrary a = new SerializationLibrary(null);
		//SerializationLibrary a = mock(SerializationLibrary.class);
		assertEquals(false, a.isSavingStructureProper(":"));
	}
	
	@Test
	public void isDownloadStructureProperTest() {
		SerializationLibrary a = new SerializationLibrary(null);//= mock(SerializationLibrary.class);
		a.isDownloadStructureProper("::");
		assertEquals(true,a.isDownloadStructureProper("karolina::test:test3"));
	}
	@Test
	public void isDownloadStructureProperTestFalse() {
		SerializationLibrary a = new SerializationLibrary(null);//= mock(SerializationLibrary.class);
		a.isDownloadStructureProper("karolina:test:test3");
		assertEquals(false,a.isDownloadStructureProper("karolina:test:test3"));
	}

}
