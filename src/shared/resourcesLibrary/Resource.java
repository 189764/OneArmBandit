package shared.resourcesLibrary;

import java.util.ArrayList;
import java.util.List;

public class Resource extends AbstractLocalization {

  /**
   * It creates resource from this structure
   * @param structure
   */
  public Resource( String structure ) {
    String[] tab = structure.split( ":" );
    name = tab[0];
  }
  
  /**
   * It returns content(name) of this file.
   */
  public List <String> getContent() {
    List<String> result = new ArrayList<String>();
    result.add( name );     
    return result;
  }
/**
 * It returns empty list. It is needed from recursive causes.
 */
  @Override
  public List<String> getDirs( ) {
    List<String> result = new ArrayList<String>();
    return result;
  }
  /**
   * It returns file name.
   */
  @Override
  public List<String> getFiles( ) {
    List<String> result = new ArrayList<String>();
    result.add( name );     
    return result;
  }

  
}
