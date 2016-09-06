package server.networkServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.UserThread;
import shared.packet.Package;

public class ClientSendReceive {

  private static final Logger LOGGER = LogManager
    .getLogger( ClientSendReceive.class );

  private UserThread userThread;
  private Socket clientSocket;
  private ObjectInputStream serverInputStream;
  private ObjectOutputStream serverOutputStream;
  private boolean ifConnected = true;

  public ClientSendReceive( Socket socket ) throws IOException {
    this.clientSocket = socket;
    this.serverInputStream = new ObjectInputStream(
        this.clientSocket.getInputStream( ) );
    this.serverOutputStream = new ObjectOutputStream(
        this.clientSocket.getOutputStream( ) );
    this.userThread = new UserThread( this );
    Thread thread = new Thread( this.userThread );
    thread.start( );
  }

  public void sendToClient( Package packet ) {

    try {
      this.serverOutputStream.writeObject( packet );
    } catch ( IOException e ) {
      LOGGER.fatal( "cannot write to socket" );
      e.printStackTrace( );
    }
  }

  public void listenFromClient( ) {

    Package packet = null;
    while ( ifConnected ) {
      try {
        packet = (Package) this.serverInputStream.readObject( );
        LOGGER.info( "recieved " + packet.toString( ) );
        this.userThread.collectData( packet );
      } catch ( ClassNotFoundException e ) {
        LOGGER.fatal( "cannot cast to Package class" );
        e.printStackTrace( );
      } catch ( IOException e ) {
        LOGGER.fatal( "IOException while reading from socket" );
        e.printStackTrace( );
        ifConnected = false;

      }
    }
  }

  public boolean isIfConnected( ) {
    return ifConnected;
  }

  public void setIfConnected( boolean ifConnected ) {
    this.ifConnected = ifConnected;
  }

}
