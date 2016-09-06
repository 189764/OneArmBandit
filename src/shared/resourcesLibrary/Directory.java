package shared.resourcesLibrary;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractLocalization {

  private List<AbstractLocalization> next = new ArrayList<>( );

  /**
   * Constructor creates reccurent directories and file from structure.
   * 
   * @param structure
   */
  public Directory( String structure ) {
    String editStructure = structure;
    String [ ] tab = structure.split( ":" );

    if ( tab.length > 2 ) {
      this.name = tab[ 0 ];
      editStructure = tab[ 1 ];
      for ( int i = 2; i < tab.length; i++ ) {
        editStructure = editStructure + ":" + tab[ i ];
      }
      this.next.add( new Directory( editStructure ) );
    } else {
      this.name = tab[ 0 ];
      editStructure = tab[ 1 ];
      for ( int i = 2; i < tab.length; i++ ) {
        editStructure = editStructure + ":" + tab[ i ];
      }
      this.next.add( new Resource( editStructure ) );
    }
  }

  /**
   * Constructor creates directories and file from structure.
   * 
   * @param dirs
   * @param files
   */
  public Directory( String dirs, List<String> files ) {
    String end = "end";
    String dirsEdit = dirs;
    String [ ] tab = dirs.split( ":" );

    if ( tab.length > 1 ) {
      this.name = tab[ 0 ];
      dirsEdit = tab[ 1 ];
      for ( int i = 2; i < tab.length; i++ ) {
        dirsEdit = dirsEdit + ":" + tab[ i ];
      }
      this.next.add( new Directory( dirsEdit, files ) );
    } else if ( tab.length == 1 && !dirs.equals( end ) ) {
      this.name = dirsEdit;
      for ( String x : files ) {
        this.next.add( new Resource( x ) );
      }
    }
  }

  /**
   * Constructor creates directory with files.
   * 
   * @param files
   */
  public Directory( List<String> files ) {
    for ( String x : files ) {
      this.next.add( new Resource( x + ":" ) );
    }
  }

  /**
   * This methods returns files.
   */

  public List<String> getFiles( ) {
    List<String> result = new ArrayList<String>( );
    for ( AbstractLocalization x : this.next ) {
      List<String> resultTemp = x.getFiles( );
      for ( String y : resultTemp ) {
        result.add( y );
      }
    }
    return result;
  }

  /**
   * This method returns contents.
   */
  public List<String> getContent( ) {
    List<String> result = new ArrayList<String>( );

    for ( AbstractLocalization x : this.next ) {
      List<String> resultTemp = x.getContent( );
      for ( String y : resultTemp ) {
        result.add( y );
      }
    }
    result.add( 0, this.name );
    return result;
  }

  /**
   * @return It returns all dirs as a structure.
   */

  public String getDirsAsStructure( ) {
    List<String> list = this.getDirs( );
    String [ ] tab = new String [ list.size( ) ];
    int i = 0;
    for ( String x : list ) {
      tab[ i ] = x;
      i++;
    }
    String str;
    str = tab[ 0 ] + ":";
    for ( int j = 1; j < tab.length; j++ ) {
      str = str + tab[ j ] + ":";
    }
    return str;
  }

  /**
   * It returns all dirs as a list of String.
   */
  public List<String> getDirs( ) {
    List<String> result = new ArrayList<String>( );

    for ( AbstractLocalization x : this.next ) {
      List<String> resulttemp = x.getDirs( );
      for ( String y : resulttemp ) {
        result.add( y );
      }
    }
    result.add( 0, name );
    return result;
  }

}
