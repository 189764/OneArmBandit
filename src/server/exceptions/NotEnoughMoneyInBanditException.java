package server.exceptions;

public class NotEnoughMoneyInBanditException extends RuntimeException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyInBanditException() {
		    super( );
		  }

		  public NotEnoughMoneyInBanditException( String msg ) {
		    super( msg );
		  }

		  public NotEnoughMoneyInBanditException( String msg, Throwable cause ) {
		    super( msg, cause );
		  }

		  public NotEnoughMoneyInBanditException( Throwable cause ) {
		    super( cause );
		  }
	
}