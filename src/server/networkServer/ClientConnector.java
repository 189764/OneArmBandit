package server.networkServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shared.ConnectionConfiguration;

/**
 * allow server to connect to client
 */
public class ClientConnector {

  private static final Logger LOGGER = LogManager.getLogger( ClientConnector.class );

  /**
   * listen for new client and connect them 
   */
  public void listenForClients( ) {

    ServerSocket serverSocket;

    ConnectionConfiguration conf = ConnectionConfiguration.getConfiguration( );

    try {
      serverSocket = new ServerSocket( conf.getPort( ) );
      while ( true ) {
        Socket clientSocket = serverSocket.accept( );
        LOGGER.info( "accepted" );

        new ClientSendReceive( clientSocket );
      }
    } catch ( IOException e ) {
      JOptionPane.showMessageDialog( null, "Cannot open socket. Probably port is "
          + "in use or server is already running" );
      LOGGER.fatal( " cannot open socket" );
      e.printStackTrace( );
    }
  }

}
