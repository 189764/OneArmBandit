package shared.exceptions.resourcesLibraryExceptions;

public class BadStructureException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public BadStructureException( ) {
    super( );
  }

  public BadStructureException( String msg ) {
    super( msg );
  }

  public BadStructureException( String msg, Throwable cause ) {
    super( msg, cause );
  }

  public BadStructureException( Throwable cause ) {
    super( cause );
  }
  
}
