package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;

import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;
import server.networkServer.ClientSendReceive;

public class ClientSendReceiveTest {
	
    private Socket socket;
    private ClientSendReceive clientSendReceive;
 
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

}
