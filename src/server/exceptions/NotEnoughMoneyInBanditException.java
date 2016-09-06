package server.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotEnoughMoneyInBanditException extends RuntimeException {

  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  private static final Logger LOGGER = LogManager
    .getLogger( NotEnoughMoneyInBanditException.class );

  public NotEnoughMoneyInBanditException( ) {
    super( );
  }

  public NotEnoughMoneyInBanditException( String msg ) {
    super( msg );
    LOGGER.fatal( msg );
  }

  public NotEnoughMoneyInBanditException( String msg, Throwable cause ) {
    super( msg, cause );
    LOGGER.fatal( msg );
  }

  public NotEnoughMoneyInBanditException( Throwable cause ) {
    super( cause );
  }

}
