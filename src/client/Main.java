package client;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.frames.LoginLogic;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

/**
 * Main class
 */
public class Main {

  private static final Logger LOGGER = LogManager.getLogger( Main.class );

  /**
   * main- creates server object
   * 
   * @param args
   */
  public static void main( String [ ] args )
      throws ConnectException, UnknownHostException, IOException {
    LOGGER.info( "Application client starting" );
    PickUpFromServer pickUpFromServer = new PickUpFromServer( );
    ServerConnector serverConnector = new ServerConnector( pickUpFromServer );
    serverConnector.connect( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
