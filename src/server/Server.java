package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import server.networkServer.ClientConnector;
import shared.data.User;
import shared.exceptions.resourcesLibraryExceptions.LackOfFileException;
import shared.resourcesLibrary.AbstractResourcesLibrary;
import shared.resourcesLibrary.SerializationLibrary;

public class Server {

  private static HashMap<String, Integer> clients = new HashMap<String, Integer>( );
  private static HashMap<Integer, UserThread> threads = new HashMap<Integer, UserThread>( );
  private static List<User> usersAll = new ArrayList<User>( );
  private ClientConnector clientConnector = new ClientConnector( );
  private AbstractResourcesLibrary resource = new SerializationLibrary( "Server" );

  public Server( ) {
    Server.usersAll = this.loadUserList( );
    this.clientConnector.listenForClients( );
  }

  @SuppressWarnings( "unchecked" )
  public List<User> loadUserList( ) {
    List<User> users = new ArrayList<User>( );
    try {
      System.out.println( "Reading users from file" );
      List<Object> objects = this.resource.getObjects( "server:users" );
      users = (List<User>) objects.get( 0 );
    } catch ( LackOfFileException e ) {
      System.out.println( "Creating empty file for users" );
      this.resource.saveObject( Server.usersAll, "server:users" );
    }
    for ( User x : users ) {
      System.out.println( "Read user: " + x.getLogin( ) );
    }
    return users;
  }

  public static HashMap<String, Integer> getClientsMap( ) {
    return Server.clients;
  }

  public static void removeClientsMap( String login ) {
    Server.clients.remove( login );
  }

  public static void addClientsMap( String login, Integer id ) {
    Server.clients.put( login, id );
  }

  public static HashMap<Integer, UserThread> getThreadsMap( ) {
    return Server.threads;
  }

  public static void removeThreadsMap( Integer id ) {
    Server.threads.remove( id );
  }

  public static void addThreadsMap( Integer id, UserThread userThread ) {
    Server.threads.put( id, userThread );
  }
  
  public static List<User> getUsersAll( ) {
    return Server.usersAll;
  }

  public static void setUsersAll( ArrayList<User> usersAll ) {
    Server.usersAll = usersAll;
  }
  
  public static void addUserList ( User user ) {
    Server.usersAll.add( user );
  }
  
  public static void removeUserList ( int i ) {
    Server.usersAll.remove( i );
  }

}
