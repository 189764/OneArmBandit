package test;

import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

import java.io.IOException;
import java.net.Socket;
import org.junit.Before;
import static org.mockito.Mockito.mock;
 
 
public class ServerConnectorTest {
   
    private PickUpFromServer hfs;
    private Socket socket;
    private ServerConnector serverConnector;
 
     @Before
    public void setUp() throws IOException {
        // tego connect nie uzywa wiec moze byc tez zmockowane
        hfs=mock(PickUpFromServer.class);
        // To raczej najwazniejsze w tescie do connect
        socket= mock(Socket.class);
        serverConnector= new ServerConnector(hfs);
        // wrzucilem mocka do obiektu
        serverConnector.setSocket(socket);
    }
    

}