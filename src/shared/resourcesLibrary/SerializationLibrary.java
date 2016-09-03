package shared.resourcesLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import shared.exceptions.resourcesLibraryExceptions.BadStructureException;
import shared.exceptions.resourcesLibraryExceptions.LackOfFileException;


public class SerializationLibrary extends AbstractResourcesLibrary {

  private XStream xstream = new XStream( new DomDriver( ) );
  
  
  /**
   * Constructor, which set active user and load directories from memory.
   * @param activeUser
   */
  public SerializationLibrary( String activeUser ) {     
  super( activeUser );
  this.xstream.autodetectAnnotations( true );
  this.loadMe();
}


/**
 * This method save object under given structure.
 */
@Override
public void saveObject( Object object, String structure ) throws BadStructureException {
  if ( this.isSavingStructureProper( structure ) ) {
   throw new BadStructureException(); 
  }
  String editStructure =  addProfileToStructure( structure );   
  Directory dir = new Directory( editStructure );
  this.createXMLFile ( object, this.createSavingPathToDirs( dir.getDirs( ) ),
      this.createSavingPathToResource( dir.getContent( ) ) );    
  
  addToDirectories( dir );   
}



/**
 * This method is used to create object from xml files.
 */
@Override
public List<Object> getObjects( String structure )
throws LackOfFileException, BadStructureException {
  Object  obj;
  List<Object> list = new ArrayList<Object>();
  if ( this.isDownloadStructureProper( structure ) ) {
    throw new BadStructureException(); 
   }
  
  String editStructure =  addProfileToStructure( structure );  
  Directory dir = new Directory( editStructure );

  if ( isRepresentsMoreThanOne( dir ) ) {
    list = this.createObjectsFromXMLFile( 
        this.createSavingPathToDirs( dir.getDirs( ) ), editStructure );
  
  } else {
   obj = this.createObjectFromXMLFile( 
        this.createSavingPathToDirs( dir.getDirs( ) ), 
        this.createSavingPathToResource( dir.getContent( ) ) );

   
   list.add( obj );
  }
  
  return list;
}
/**
* This method checks if structure path to saving files contains proper signs.
*/ 
@Override
protected boolean isSavingStructureProper( String str ) {
  if ( str.contains( "::" ) || str.contains( "//" ) ||
      str.contains( "\\" ) || str.contains( "*" ) ) {
    return true;
  }
  return false;
}

/**
*  This method checks if structure path to download files contains proper signs.
*/

@Override
protected boolean isDownloadStructureProper( String str ) {
  if ( str.contains( "::" ) || str.contains( "//" ) ||
      str.contains( "\\" ) ) {
    return true;
  }
  return false;
}

/**
 * This method will save directories. 
 * Directories are some kind of memory of library.
 */

@Override
protected void saveMe( ) {
  try {
    String path = activeUser + "/directories.xml";
    File file = new File( path );
    if ( !file.isFile( ) ) {
      file.getParentFile( ).mkdirs( );
      file.createNewFile( );
    }
    
    FileWriter writer = new FileWriter( path );
    this.xstream.toXML( this.directories, writer );
  } catch ( IOException e ) {
    System.out.println( "plik bedzie utworzony" );
    e.printStackTrace( );
  }   
   
}

/**
* This method will load directories from disk.
* It has supress warning because we have to convert object to List
*/
@SuppressWarnings( "unchecked" )
@Override
protected void loadMe( ) {
  FileReader reader;
  try {
    reader = new FileReader( activeUser + "/directories.xml" );
    
    this.directories = (CopyOnWriteArrayList<Directory>) this.xstream.fromXML( reader );
  } catch ( FileNotFoundException e ) {
   System.out.println( "pierwsze uruchomienie biblioteki " +
  " spowodowalo rzucenie wyj¹tku i struktura folderow zostanie utworzona" );
   this.saveMe( );
  }    
}

/**
* This method creates path, predicted to saving many files.
* It changes dirs from List<String> into string with slashes.
* @param dirs List of dirs, which is returned by Directory object.
* @return path - it returns path (String) - only dirs
*/

private String createSavingPathToDirs( List<String> dirs ) {
  String path;
  String[] tab = new String[dirs.size( )];
  int i = 0;
  for ( String x : dirs ) {
  tab[i] = x;
  i++;
  }
  path = tab[0] + "/";
  int tmp = tab.length;
  tmp--;
  for ( int j = 1; j < tab.length; j++ ) {
  if ( j == tmp ) {
    path += tab[j];
  } else { 
    path += tab[j];
  path += "/"; 
  }
  }
  return path;
}

/**
 * This method creates saving path, predicted to saving one file.
 * It changes dirs and files from list into path.
 * @param list - list of dirs and file.
 * @return - it returns path to file (String)
 */

 private String createSavingPathToResource( List<String> list ) {
  String path;
  String[] tab = new String[list.size( )];
  int i = 0;
  for ( String x : list ) {
  tab[i] = x;
  i++;
  }
  path = tab[0] + "/";
  int tmp = tab.length;
  tmp--;
  for ( int j = 1; j < tab.length; j++ ) {
    if ( j == tmp ) {
    path += tab[j] + ".xml";
  } else {
    path += tab[j];
  path += "/";
  }
  }
  return path;
}


 /**
  * It's creating XML File from object.
  * @param object - obcject to change into xml file
  * @param dirs - path - only with directories
  * @param newPath - path - directories with file
  */
 private void createXMLFile( Object object, String dirs, String newPath ) {
  File file = new File( dirs );
  if ( file.isDirectory( ) ) {
      try {
     FileWriter writer = new FileWriter( newPath );
      this.xstream.toXML( object, writer );
      } catch ( IOException e ) {
      e.printStackTrace();
    }
    } else if ( !file.exists( ) ) {
      file.mkdirs( );
    try {
     FileWriter writer = new FileWriter( newPath );
      this.xstream.toXML( object, writer );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}


/**
 * This method creates object from xml file.
 * @param dirs - path - only with dirs
 * @param newPath - path - with file too
 * @return Object - returns object from xml file
 */
//newPath sciezka do pliku, a dirs sciezka folderow (bez pliku) 
private Object createObjectFromXMLFile(
    String dirs, String newPath ) { 
Object obj;
File file = new File( dirs );
if ( file.isDirectory( ) ) {
  try {
 FileReader reader = new FileReader( newPath );

 obj = this.xstream.fromXML( reader );
 return obj;
 } catch ( IOException e ) {
   throw new LackOfFileException();   
}
} else {
  throw new LackOfFileException();
}
}

/**
 * This method creates paths to many files. 
 * It connects files from list with path named dir
 * @param files - names of files, which must be connected witdh dir
 * @param dir - path - without files
 * @return list of String represents paths to files (dirs and files)
 */
private List<String> makePaths( List<String> files, String dir ) {
 List<String> list = new ArrayList<String>();
 for ( String x : files ) {
   list.add( dir + "/" + x );
 }
 return list;
}

/**
 * This method creates list of objects from XML files.
 * @param dirs - path - only dirs
 * @param structure - adressing structure - used to equaling
 * it with structure returned by Directory object
 * @return list of objects creates from XML files
 */

private List<Object> createObjectsFromXMLFile( String dirs, String structure ) { 

Object obj;  
String base = structureForMany( structure );
List<Object> list = new ArrayList<Object>();
   try {
   for ( Directory nextDir : directories ) {
   if ( nextDir.getDirsAsStructure( ).equals( base ) ) {
   List<String> paths = this.makePaths( nextDir.getFiles( ), dirs );
   for ( String x : paths ) {
   FileReader reader = new FileReader( x + ".xml" );
   
   obj = this.xstream.fromXML( reader );
   list.add( obj );
   }     
   }
   }
   } catch ( IOException e ) {
  e.printStackTrace();
  return list;
  
} 
return list;
}
  
}
