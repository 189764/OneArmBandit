package server.networkServer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class ClientConnectorTest {

	@Test
	public void listenForClientsTest() throws IOException {
		
		//ClientConnector cc = mock(ClientConnector.class);
		//doReturn("accepted").when(cc).listenForClients();
		//verify(cc).listenForClients();
		
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		//doThrow(new IOException()).when(mock).close();
		osw.close();
		verify(mock).close();
	}

}
