package server;

import server.networkServer.ClientSendReceive;
import shared.packet.Data;
import shared.packet.Instruction;
import shared.packet.Package;

public class UserThread implements Runnable {

  private int id;
  private ClientSendReceive clientSendReceive;
  
  public UserThread ( ClientSendReceive clientSendReceive ) {
    this.id = Server.getThreadsMap( ).size();
    this.clientSendReceive = clientSendReceive;
    Server.addThreadsMap( this.id, this );
    System.out.println( "Created thread id: "  +  this.id );
  }

  public void run( ) {
    System.out.println( "UserThread id: " + this.id + " run" );
    while ( true ) {
          this.clientSendReceive.listenFromClient( );
     }
    }   
   
  public void collectData( Package packet ) {
    Data data = (Data) packet;
    System.out.println( "data collected" ); 
    }
  
  private Instruction logIn ( String login, String password ) {
    Instruction instruction = Instruction.LOG_IN_ERROR;
      instruction = Instruction.LOG_IN_SUCCESS;
      this.sendInformation( );
    return instruction;
  }
  
  private void sendData ( Package packet ) {
    System.out.println( "Send package on thread id: " + this.id );
    this.clientSendReceive.sendToClient( packet );
  }
  
  
  private void sendInformation ( ) {
    Data data = new Data ();
    this.sendData( data );
  }
}
