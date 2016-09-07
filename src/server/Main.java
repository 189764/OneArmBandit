package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class
 */
public final class Main {

  private static final Logger LOGGER = LogManager.getLogger( Main.class );

  
  private Main( ) {

  }

  /**
   * main- creates server object
   * 
   * @param args
   */
  public static void main( String [ ] args ) {

    LOGGER.info( "Server on" );
    new Server( );
  }
}
