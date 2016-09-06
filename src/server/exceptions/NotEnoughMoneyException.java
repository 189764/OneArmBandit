package server.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotEnoughMoneyException extends RuntimeException {

  /**
  * 
  */
  private static final long serialVersionUID = 9000195850664794846L;

  private static final Logger LOGGER = LogManager
    .getLogger( NotEnoughMoneyException.class );

  public NotEnoughMoneyException( ) {
    super( );
  }

  public NotEnoughMoneyException( String msg ) {
    super( msg );
    LOGGER.fatal( msg );
  }

  public NotEnoughMoneyException( String msg, Throwable cause ) {
    super( msg, cause );
    LOGGER.fatal( msg );
  }

  public NotEnoughMoneyException( Throwable cause ) {
    super( cause );
  }

}
