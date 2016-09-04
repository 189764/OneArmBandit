package server;

import server.networkServer.ClientSendReceive;
import shared.data.User;
import shared.packet.Data;
import shared.packet.Instruction;
import shared.packet.Package;
import shared.resourcesLibrary.AbstractResourcesLibrary;
import shared.resourcesLibrary.SerializationLibrary;

public class UserThread implements Runnable {

  private int id;
  private ClientSendReceive clientSendReceive;
  private AbstractResourcesLibrary resource = new SerializationLibrary( "Server" );

  public UserThread( ClientSendReceive clientSendReceive ) {
    this.id = Server.getThreadsMap( ).size( );
    this.clientSendReceive = clientSendReceive;
    Server.addThreadsMap( this.id, this );
    System.out.println( "Created thread id: " + this.id );
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
    Data replay = new Data( );
    replay.setInstruction( data.getInstruction( ) );
    replay.setLogin( data.getLogin( ) );
    if ( data.getInstruction( ) == Instruction.LOG_IN ) {
      replay.setInstruction( this.logIn( data.getLogin( ), data.getPassword( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.LOG_OUT ) {
      this.logOut( data.getLogin( ) );
    }
    if ( data.getInstruction( ) == Instruction.REGISTER ) {
      replay.setInstruction( this.register( data.getLogin( ), data.getPassword( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.RESET_PASSWORD ) {
      replay.setInstruction( this.resetPassword( data.getLogin( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD ) {
      replay.setInstruction( this.changePassword( data.getLogin( ), data.getPassword( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.PLAY ) {
      replay.setInstruction( this.play( data.getLogin( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.ASK_RANKING ) {
      replay.setInstruction( this.sendRanking( data.getLogin( ) ) );
      this.sendData( replay );
    }
    
  }

  private Instruction sendRanking( String login ) {
    // TODO Auto-generated method stub
    return null;
  }

  private Instruction play( String login ) {
    // TODO Auto-generated method stub
    return null;
  }

  private Instruction logIn( String login, String password ) {
    Instruction instruction = Instruction.LOG_IN_ERROR;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      System.out.println( Server.getUsersAll( ).get( i ) );
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login )
          && Server.getUsersAll( ).get( i ).getPassword( ).equals( password ) ) {
        Server.addClientsMap( login, this.id );
        System.out.println( "User " + login + " logged" );
        if ( Server.getUsersAll( ).get( i ).getIsAdmin( ) ) {
        instruction = Instruction.LOG_IN_SUCCESS_ADMIN;
        } else {
          instruction = Instruction.LOG_IN_SUCCESS_USER;
        }
        this.sendInformation( );
      }
    }
    return instruction;
  }

  private void logOut( String login ) {
    if ( Server.getClientsMap( ).containsKey( login ) ) {
      Server.removeClientsMap( login );
      System.out.println( "User " + login + " logged off" );
    }
  }

  private void sendData( Package packet ) {
    System.out.println( "Send package on thread id: " + this.id );
    this.clientSendReceive.sendToClient( packet );
  }

  private void sendInformation( ) {
    Data data = new Data( );
    this.sendData( data );
  }
  
 private Instruction register( String login, String password ) {
    
    boolean exists = false;
    for ( User x: Server.getUsersAll( ) ) {
      if ( x.getLogin( ).equals( login ) ) {
        exists = true;
      } 
      }
    if ( exists ) {
      return Instruction.REGISTER_ERROR;
    } else {
      Server.addUserList( new User ( login, password, 0, false ) ); 
      System.out.println( "User " + login + " added" );
      this.resource.saveObject( Server.getUsersAll( ), "server:users" );
      return Instruction.REGISTER_SUCCES;
    }
  }
 
 private Instruction changePassword ( String login, String newPassword ) {
   Instruction status = Instruction.CHANGE_PASSWORD_ERROR;
   for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
   if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
     Server.getUsersAll( ).get( i ).setPassword( newPassword );
     System.out.println( "Password for user " + login + " changed" );
     this.resource.saveObject( Server.getUsersAll( ), "server:users" );
     status = Instruction.CHANGE_PASSWORD_SUCCESS;
   } 
   }
   return status;
 }
 
 private Instruction resetPassword ( String login ) {
   Instruction status = Instruction.RESET_PASSWORD_ERROR;
   for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
   if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
     Server.getUsersAll( ).get( i ).setPassword( login );
     System.out.println( "Password for user " + login + " was reset" );
     this.resource.saveObject( Server.getUsersAll( ), "server:users" );
     status = Instruction.RESET_PASSWORD_SUCCESS;
   } 
   }
   return status;
 }
 
}
