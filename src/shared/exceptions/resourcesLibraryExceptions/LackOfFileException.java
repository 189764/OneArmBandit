package shared.exceptions.resourcesLibraryExceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.Main;

public class LackOfFileException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static final Logger LOGGER = LogManager.getLogger( Main.class );

  public LackOfFileException( ) {
    super( );
  }

  public LackOfFileException( String msg ) {
    super( msg );
    LOGGER.fatal( msg );
  }

  public LackOfFileException( String msg, Throwable cause ) {
    super( msg, cause );
    LOGGER.fatal( msg );
  }

  public LackOfFileException( Throwable cause ) {
    super( cause );
  }

}
