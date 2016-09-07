package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import shared.resourcesLibrary.Directory;

public class DirectoryTest {
	
	@Mock
	Directory dir;
	
	@Before
	public void setUp() {
		//abstractLocalization =new AbstractLocalization();
		dir = mock(Directory.class);
	}
	
	@Test
	public void getFilesTest() {
		
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("file1");
		lists.add("file2");
		when(dir.getFiles()).thenReturn(lists);
		assertEquals(lists, dir.getFiles());
		
	}
	
	@Test
	public void getContentTest() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("content1");
		list.add("content2");
		when(dir.getContent()).thenReturn(list);
		assertEquals(list, dir.getContent());
	}
	
	@Test
	public void getDirsTest() {
		
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("dir1");
		lists.add("dir2");
		when(dir.getDirs()).thenReturn(lists);
		assertEquals(lists, dir.getDirs());
	}
	

	

}
