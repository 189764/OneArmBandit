package shared.data.userExceptions;

public class OutOfRangeStakeException extends RuntimeException {

	  /**
   * 
   */
  private static final long serialVersionUID = 8596596511919810970L;

    public OutOfRangeStakeException( ) {
		    super( );
		  }

		  public OutOfRangeStakeException( String msg ) {
		    super( msg );
		  }

		  public OutOfRangeStakeException( String msg, Throwable cause ) {
		    super( msg, cause );
		  }

		  public OutOfRangeStakeException( Throwable cause ) {
		    super( cause );
		  }
	
	
}
