package server;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.networkServer.ClientSendReceive;
import shared.data.User;
import shared.packet.Data;
import shared.packet.Instruction;
import shared.packet.Package;
import shared.resourcesLibrary.AbstractResourcesLibrary;
import shared.resourcesLibrary.SerializationLibrary;

public class UserThread implements Runnable {

  private static final Logger LOGGER = LogManager.getLogger( UserThread.class );

  private int id;
  private ClientSendReceive clientSendReceive;
  private AbstractResourcesLibrary resource = new SerializationLibrary( "Server" );

  public UserThread( ClientSendReceive clientSendReceive ) {
    this.id = Server.getThreadsMap( ).size( );
    this.clientSendReceive = clientSendReceive;
    Server.addThreadsMap( this.id, this );
    LOGGER.info( "Created thread id: " + this.id );
  }

  public void run( ) {
    LOGGER.info( "UserThread id: " + this.id + " run" );
    while ( true ) {
      this.clientSendReceive.listenFromClient( );
    }
  }

  public void collectData( Package packet ) {
    Data data = (Data) packet;
    LOGGER.info( "data collected" );
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
      replay
        .setInstruction( this.register( data.getLogin( ), data.getPassword( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.RESET_PASSWORD ) {
      replay.setInstruction( this.resetPassword( data.getLogin( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD ) {
      replay.setInstruction(
          this.changePassword( data.getLogin( ), data.getPassword( ) ) );
      this.sendData( replay );
    }
    if ( data.getInstruction( ) == Instruction.PLAY ) {
      this.play( data.getLogin( ), data.getPoints( ) );
    }
    if ( data.getInstruction( ) == Instruction.ASK_RANKING ) {
      this.sendRanking( );
    }
    if ( data.getInstruction( ) == Instruction.ASK_POINTS ) {
      this.sendPoints( data.getLogin( ) );
    }
    if ( data.getInstruction( ) == Instruction.TRANSFER ) {
      this.transfer( data.getPoints( ) );
    }
    if ( data.getInstruction( ) == Instruction.SET_OF_SYMBOL_VALUES ) {
      this.setOfSymbolValues( data.getListOfSymbolValues( ) );
    }

  }

  private void setOfSymbolValues( ArrayList<Integer> listOfSymbolValues ) {
    Server.getBandit( ).setSymbolOne( listOfSymbolValues.get( 0 ) );
    Server.getBandit( ).setSymbolTwo( listOfSymbolValues.get( 1 ) );
    Server.getBandit( ).setSymbolThree( listOfSymbolValues.get( 2 ) );
    Server.getBandit( ).setSymbolFour( listOfSymbolValues.get( 3 ) );
    Server.getBandit( ).setSymbolFive( listOfSymbolValues.get( 4 ) );
    Server.getBandit( ).setSymbolSix( listOfSymbolValues.get( 5 ) );
    Server.getBandit( ).setSymbolSeven( listOfSymbolValues.get( 6 ) );
    Server.getBandit( ).setSymbolEight( listOfSymbolValues.get( 7 ) );
    Server.getBandit( ).setSymbolNine( listOfSymbolValues.get( 8 ) );

  }

  private void transfer( Integer points ) {
    Server.getCentralBank( ).transferMoney( Server.getBandit( ), points );
  }

  private void sendPoints( String login ) {
    Data replay = new Data( );
    replay.setInstruction( Instruction.SEND_POINTS );
    Integer points = 0;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
        points = Server.getUsersAll( ).get( i ).getPoints( );
      }
    }
    replay.setPoints( points );
    this.sendData( replay );
  }

  private void sendRanking( ) {
    int counter = 0;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      if ( !Server.getUsersAll( ).get( i ).getIsAdmin( ) ) {
        counter++;
      }
    }
    Object [ ] [ ] ranking = new Object [ counter ] [ 2 ];
    for ( int i = 1; i < Server.getUsersAll( ).size( ); i++ ) {
      ranking[ i - 1 ][ 0 ] = Server.getUsersAll( ).get( i ).getLogin( );
      ranking[ i - 1 ][ 1 ] = Server.getUsersAll( ).get( i ).getPoints( );
    }
    int i = 0;
    String tempString;
    Integer tempInt = 0;
    while ( i < ranking.length - 1 ) {
      if ( (Integer) ranking[ i ][ 1 ] < (Integer) ranking[ i + 1 ][ 1 ] ) {
        tempString = (String) ranking[ i ][ 0 ];
        tempInt = (Integer) ranking[ i ][ 1 ];
        ranking[ i ][ 0 ] = ranking[ i + 1 ][ 0 ];
        ranking[ i ][ 1 ] = ranking[ i + 1 ][ 1 ];
        ranking[ i + 1 ][ 0 ] = tempString;
        ranking[ i + 1 ][ 1 ] = tempInt;
      }
      i++;
    }

    Data replay = new Data( );
    replay.setInstruction( Instruction.SEND_RANKING );
    replay.setRanking( ranking );
    this.sendData( replay );
  }

  private void play( String login, Integer stake ) {

    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
        Server.getUsersAll( ).get( i ).setStake( stake );
        User user = Server.getUsersAll( ).get( i );
        Data replay = new Data( );
        Integer prize = Server.getUsersAll( ).get( i ).getPoints( );
        replay.setInstruction( Instruction.SEND_RESULT );
        replay.setRanking( Server.getBandit( ).bet( user ) );
        prize = Server.getUsersAll( ).get( i ).getPoints( ) - prize + stake;
        this.sendData( replay );
        Data replay2 = new Data( );
        replay2.setInstruction( Instruction.WON );
        replay2.setPoints( prize );
        this.sendData( replay2 );
        this.resource.saveObject( Server.getCentralBank( ), "server:centralBank" );
        this.resource.saveObject( Server.getUsersAll( ), "server:users" );
        this.resource.saveObject( Server.getBandit( ), "server:bandit" );
      }
    }
  }

  private Instruction logIn( String login, String password ) {
    Instruction instruction = Instruction.LOG_IN_ERROR;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      LOGGER.info( Server.getUsersAll( ).get( i ) );
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login )
          && Server.getUsersAll( ).get( i ).getPassword( ).equals( password ) ) {
        Server.addClientsMap( login, this.id );
        LOGGER.info( "User " + login + " logged" );
        if ( Server.getUsersAll( ).get( i ).getIsAdmin( ) ) {
          instruction = Instruction.LOG_IN_SUCCESS_ADMIN;
        } else {
          instruction = Instruction.LOG_IN_SUCCESS_USER;
        }
      }
    }
    return instruction;
  }

  private void logOut( String login ) {
    if ( Server.getClientsMap( ).containsKey( login ) ) {
      Server.removeClientsMap( login );
      LOGGER.info( "User " + login + " logged off" );
    }
  }

  private void sendData( Package packet ) {
    LOGGER.info( "Send package on thread id: " + this.id );
    this.clientSendReceive.sendToClient( packet );
  }

  private Instruction register( String login, String password ) {

    boolean exists = false;
    for ( User x : Server.getUsersAll( ) ) {
      if ( x.getLogin( ).equals( login ) ) {
        exists = true;
      }
    }
    if ( exists ) {
      return Instruction.REGISTER_ERROR;
    } else {
      Server.addUserList( new User( login, password, 100, false ) );
      LOGGER.info( "User " + login + " added" );
      this.resource.saveObject( Server.getUsersAll( ), "server:users" );
      return Instruction.REGISTER_SUCCES;
    }
  }

  private Instruction changePassword( String login, String newPassword ) {
    Instruction status = Instruction.CHANGE_PASSWORD_ERROR;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
        Server.getUsersAll( ).get( i ).setPassword( newPassword );
        LOGGER.info( "Password for user " + login + " changed" );
        this.resource.saveObject( Server.getUsersAll( ), "server:users" );
        status = Instruction.CHANGE_PASSWORD_SUCCESS;
      }
    }
    return status;
  }

  private Instruction resetPassword( String login ) {
    Instruction status = Instruction.RESET_PASSWORD_ERROR;
    for ( int i = 0; i < Server.getUsersAll( ).size( ); i++ ) {
      if ( Server.getUsersAll( ).get( i ).getLogin( ).equals( login ) ) {
        Server.getUsersAll( ).get( i ).setPassword( login );
        LOGGER.info( "Password for user " + login + " was reset" );
        this.resource.saveObject( Server.getUsersAll( ), "server:users" );
        status = Instruction.RESET_PASSWORD_SUCCESS;
      }
    }
    return status;
  }

}
