package shared.data.userExceptions;

public class OutOfRangeStakeException extends RuntimeException {

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
