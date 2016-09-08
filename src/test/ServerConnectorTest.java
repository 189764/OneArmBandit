package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;

import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.junit.Before;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
 
 
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