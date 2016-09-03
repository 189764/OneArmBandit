package shared.resourcesLibrary;

import java.util.List;

public abstract class AbstractLocalization {

  protected String name;
  /**
   * Constructor sets name.
   * @return
   */
  protected String getName() {
    return this.name;
  }
  /**
   * This method returns content of AbstractLocalization.
   * @return
   */
  public abstract List<String> getContent( );
  /**
   * This method returns dirs of AbstractLocalization.
   * @return
   */
  public abstract List<String> getDirs( );
  /**
   * This method returns files of AbstractLocalization.
   * @return
   */
  public abstract List<String> getFiles();
  
}
