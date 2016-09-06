package shared.resourcesLibrary;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shared.exceptions.resourcesLibraryExceptions.BadStructureException;
import shared.exceptions.resourcesLibraryExceptions.LackOfFileException;

public abstract class AbstractResourcesLibrary {

  private static final Logger LOGGER = LogManager
    .getLogger( AbstractResourcesLibrary.class );

  protected CopyOnWriteArrayList<Directory> directories = new CopyOnWriteArrayList<Directory>( );
  protected String activeUser;

  /**
   * It sets activeUser variable.
   * 
   * @param activeUser
   */
  public AbstractResourcesLibrary( String activeUser ) {
    this.activeUser = activeUser;
  }

  /**
   * This method will save object.
   * 
   * @param object - object to save
   * @param structure - String with format xx:xx:xx where last xx means name of
   *          ile
   * @throws BadStructureException - exception where structur is not proper
   */
  public abstract void saveObject( Object object, String structure )
      throws BadStructureException;

  /**
   * This method will allow you to get your objects from saved data.
   * 
   * @param structure - adress of object in data
   * @return list of objects - list with objects which you want get
   * @throws LackOfFileException - exception throws when file doesn't exist
   * @throws BadStructureException - exception throws when structure is not
   *           proper
   */
  public abstract List<Object> getObjects( String structure )
      throws LackOfFileException, BadStructureException;

  protected abstract void saveMe( );

  protected abstract void loadMe( );

  protected abstract boolean isSavingStructureProper( String str );

  protected abstract boolean isDownloadStructureProper( String str );

  /**
   * This methods show all directories in library's memory.
   */
  public void displayDirectories( ) {
    for ( Directory x : this.directories ) {
      LOGGER.info( x.getDirsAsStructure( ) );
      LOGGER.info( x.getFiles( ) );
    }
  }

  /**
   * This method check if Directory created from structure represents more than
   * one file.
   * 
   * @param dir
   * @return true if it represents many files, if not, then return false
   */
  protected boolean isRepresentsMoreThanOne( Directory dir ) {
    List<String> list = dir.getContent( );
    int lastElement = list.size( ) - 1;
    String check = list.get( lastElement );
    String parameter = "*";
    return check.equals( parameter );
  }

  /**
   * This method connects profile with his structure.
   * 
   * @param structure
   * @return string which represents structure and name of active user
   */
  protected String addProfileToStructure( String structure ) {
    String tmp;
    tmp = this.activeUser + ":" + structure;
    return tmp;
  }

  /**
   * This method creates structure of dirs. For many objects.
   * 
   * @param structure
   * @return
   */
  protected String structureForMany( String structure ) {
    String [ ] tab = structure.split( ":" );
    int tmp = tab.length;
    tmp = tmp - 1;
    String str = tab[ 0 ] + ":";
    for ( int z = 1; z < tab.length; z++ ) {
      if ( z != tmp ) {
        str = str + tab[ z ] + ":";
      }
    }
    return str;
  }

  /**
   * This method adds directory to memory.
   * 
   * @param dir - Directory object which can be added to directories list.
   */
  protected void addToDirectories( Directory dir ) {
    boolean found = false;
    String str = dir.getDirsAsStructure( );
    for ( Directory nextDir : this.directories ) {
      if ( nextDir.getDirsAsStructure( ).equals( str ) ) {

        List<String> files = nextDir.getFiles( );

        // files.addAll( dir.getFiles( ) );
        List<String> filesTemp = dir.getFiles( );
        for ( String y : filesTemp ) {
          if ( !files.contains( y ) ) {
            files.add( y );
          }
        }
        this.directories.remove( nextDir );
        this.directories.add( new Directory( dir.getDirsAsStructure( ), files ) );
        found = true;
      }
    }
    if ( !found ) {
      this.directories.add( dir );
    }
    this.saveMe( );
  }

  /**
   * @return directories saved in library
   */
  public CopyOnWriteArrayList<Directory> getDirectories( ) {
    return this.directories;
  }

  /**
   * It returns name of user.
   * 
   * @return
   */
  public String getUser( ) {
    return this.activeUser;
  }

}
