package client.networkClient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;

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
   
    // Teraz testy - i w sumie teraz nie wiem jak to jest wszystko zbuodwane ale
    // powinny byc takie testy
    // 1. Wszystko przechodzi poprawnie
    // 2. Rzuca UnknownHostException
    // 3. Rzuca ConnectException
    // 4. Rzuca IOException
     @Test
    public void Test1() throws ConnectException, UnknownHostException, IOException
    {
        // Powinno zwracac jakies prawidlowe wartosci - ale tego nie wiem jak zrobic bo
        // w connect jest wywolywana kolejna metoda
        //when(socket.getOutputStream()).thenReturn(/*Tu powinna byc prawidlowa wartosc*/);
        //when(socket.getInputStream()).thenReturn(/*Tu powinna byc prawidlowa wartosc*/);
    	 Mockito.doNothing().when(socket).getOutputStream();
    	//Mockito.doNothing().when(emailService).sendEmail(Matchers.anyObject(), Matchers.anyObject()));
       
        serverConnector.connect();
        // Asercja na pole isConnected (powinno byc true)
    }
    // Tutaj wypisujecie ze oczekujecie wyjatku
    @Test(expected = IOException.class)
    public void TestWyjatki() throws IOException
    {
        // Tutaj w zalenosci ktora metoda rzuca wyjatkiem mozna zrobic pare testow
        // Nie wiem jak to u was jest wiec przeklejam przykladowe
       
        doThrow(new ConnectException()).when(socket).getInputStream();
        doThrow(new IOException()).when(socket).getInputStream();
        doThrow(new UnknownHostException()).when(socket).getInputStream();
        serverConnector.connect();
    }
}