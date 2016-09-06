package server.exceptions;

public class NotEnoughMoneyException extends RuntimeException {

	  /**
   * 
   */
  private static final long serialVersionUID = 9000195850664794846L;

    public NotEnoughMoneyException( ) {
		    super( );
		  }

		  public NotEnoughMoneyException( String msg ) {
		    super( msg );
		  }

		  public NotEnoughMoneyException( String msg, Throwable cause ) {
		    super( msg, cause );
		  }

		  public NotEnoughMoneyException( Throwable cause ) {
		    super( cause );
		  }
	
	
}