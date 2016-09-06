package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

  private static final Logger LOGGER = LogManager.getLogger( Main.class );

  private Main( ) {

  }

  public static void main( String [ ] args ) {

    LOGGER.info( "Server on" );
    new Server( );
  }
}
