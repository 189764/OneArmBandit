package shared.exceptions.resourcesLibraryExceptions;

public class LackOfFileException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public LackOfFileException( ) {
    super( );
  }

  public LackOfFileException( String msg ) {
    super( msg );
  }

  public LackOfFileException( String msg, Throwable cause ) {
    super( msg, cause );
  }

  public LackOfFileException( Throwable cause ) {
    super( cause );
  }
  
}
