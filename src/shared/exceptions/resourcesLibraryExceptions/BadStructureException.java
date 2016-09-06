package shared.exceptions.resourcesLibraryExceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BadStructureException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static final Logger LOGGER = LogManager
    .getLogger( BadStructureException.class );

  public BadStructureException( ) {
    super( );
  }

  public BadStructureException( String msg ) {
    super( msg );
    LOGGER.fatal( msg );
  }

  public BadStructureException( String msg, Throwable cause ) {
    super( msg, cause );
    LOGGER.fatal( msg );
  }

  public BadStructureException( Throwable cause ) {
    super( cause );
  }

}
