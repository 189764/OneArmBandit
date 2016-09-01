package server.networkServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.UserThread;
import shared.packet.Package;

public class ClientSendReceive {

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
      System.out.println( 
          ">>>>> ClientConnector.sendToClient(): cannot write to socket!" );
      e.printStackTrace( );
    }
  }

  public void listenFromClient( ) {

    Package packet = null;
    while ( ifConnected ) {
    try {
      packet = (Package) this.serverInputStream.readObject( );
      System.out.println( "recieved " + packet.toString( ) );
      this.userThread.collectData( packet );
    } catch ( ClassNotFoundException e ) {
      System.out.println(
          ">>>>> ClientConnector.listenFromClient(): cannot cast to Package class " );
      e.printStackTrace( );
    } catch ( IOException e ) {
      System.out.println( ">>>>> ClientConnector.listenFromClient(): " +
    "IOException while reading from socket" );
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
