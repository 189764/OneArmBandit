package shared.data.userExceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutOfRangeStakeException extends RuntimeException {

  /**
  * 
  */
  private static final long serialVersionUID = 8596596511919810970L;

  private static final Logger LOGGER = LogManager
    .getLogger( OutOfRangeStakeException.class );

  public OutOfRangeStakeException( ) {
    super( );
  }

  public OutOfRangeStakeException( String msg ) {
    super( msg );
    LOGGER.fatal( msg );
  }

  public OutOfRangeStakeException( String msg, Throwable cause ) {
    super( msg, cause );
    LOGGER.fatal( msg );
  }

  public OutOfRangeStakeException( Throwable cause ) {
    super( cause );
  }

}
