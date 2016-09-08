package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Before;
import org.junit.Test;

import server.networkServer.ClientSendReceive;

public class ClientSendReceiveTest {
	
    @Before
    public void setUp() throws IOException {
        // tego connect nie uzywa wiec moze byc tez zmockowane
        //hfs=mock(PickUpFromServer.class);
        // To raczej najwazniejsze w tescie do connect
        //socket= mock(Socket.class);
        //clientSendReceive= new clientSendReceive(hfs);
        // wrzucilem mocka do obiektu
        //clientSendReceive.setSocket(socket);
    }

	@Test
	public void sendToClientTest() throws IOException {
		
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		osw.close();
		verify(mock).close();
	}
	
	@Test
	public void isIfConnectedTestNotOk() throws IOException {
		
		ClientSendReceive u = mock( ClientSendReceive.class);
		assertEquals(false, u.isIfConnected());
	}

}
