package server;

import java.util.HashMap;

import server.networkServer.ClientConnector;

public class Server {
  
  private static HashMap<String, Integer> clients = new HashMap<String, Integer>();
  private static HashMap<Integer, UserThread> threads = 
      new HashMap<Integer, UserThread>();
  private ClientConnector clientConnector = new ClientConnector();

  public Server () {
    this.clientConnector.listenForClients( );
  }
  
  
  public static HashMap<String, Integer> getClientsMap ( ) {
    return Server.clients;
  }
  
  public static void removeClientsMap ( String login ) {
    Server.clients.remove( login );
  }
  
  public static void addClientsMap ( String login, Integer id ) {
    Server.clients.put( login, id );
  }
  
  public static HashMap<Integer, UserThread> getThreadsMap ( ) {
    return Server.threads;
  }
  
  public static void removeThreadsMap ( Integer id ) {
    Server.threads.remove( id );
  }
  
  public static void addThreadsMap ( Integer id, UserThread userThread ) {
    Server.threads.put( id, userThread );
  }
  
}
