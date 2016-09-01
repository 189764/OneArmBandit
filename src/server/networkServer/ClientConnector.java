package server.networkServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import shared.ConnectionConfiguration;

public class ClientConnector {

  public void listenForClients( ) {

    ServerSocket serverSocket;

    ConnectionConfiguration conf = 
        ConnectionConfiguration.getConfiguration( );

    try {
      serverSocket = new ServerSocket( conf.getPort( ) );
      while ( true ) {
        Socket clientSocket = serverSocket.accept( );
        System.out.println( "accepted" );

        new ClientSendReceive( clientSocket );
      }
    } catch ( IOException e ) {
      JOptionPane.showMessageDialog( null, "Cannot open socket. Probably port is " + 
          "in use or server is already running" );
      System.out.println(
          ">>>>> ClinetConnector.listenForClients(): cannot open socket" );
      e.printStackTrace( );
    }
  }

}
