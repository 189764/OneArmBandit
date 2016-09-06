package client.networkClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import shared.ConnectionConfiguration;
import shared.packet.Data;
import shared.packet.Package;



public class ServerConnector {

  private Socket socket;
  private InetAddress addr;
  private ObjectOutputStream clientOutputStream;
  private ObjectInputStream clientInputStream;
  private boolean isConnected = false;
  private PickUpFromServer pickUpFromServer;

  public ServerConnector( PickUpFromServer pickUpFromServer ) throws IOException {
    this.pickUpFromServer = pickUpFromServer;
    
    ConnectionConfiguration configuration = ConnectionConfiguration.getConfiguration();
    this.socket = new Socket(configuration.getAddress(), configuration.getPort());
    this.addr = this.socket.getInetAddress();
  }
  
  public void setSocket(Socket socket)
  {
      this.socket=socket;
  }

  public void connect() throws UnknownHostException, ConnectException, IOException {
      if (!this.isConnected) {
          System.out.println(
                  ">>>>> ServerConnector.connect(): Connected with " + this.addr);

          this.clientOutputStream = new ObjectOutputStream(
                  this.socket.getOutputStream());
          this.clientInputStream = new ObjectInputStream(
                  this.socket.getInputStream());

          this.isConnected = true;

          this.listenThread();
      } else {
          JOptionPane.showMessageDialog(null, "You are already connected!");
      }
  }

  public void sendToServer( Package packet ) {
    try {
      this.clientOutputStream.writeObject( packet );
    } catch ( IOException e ) {
      System.out.println(
          ">>>>> ServerConnector.sendToServer(): cannot write to socket!" );
      e.printStackTrace( );
    }
  }

  public void listenFromServer( ) {
    Package packet = null;
    try {
      packet = (Package) this.clientInputStream.readObject( );
      System.out.println( "recieved " + packet.toString( ) );
    } catch ( ClassNotFoundException e ) {
      System.out.println(
          ">>>>> ServerConnector.listenFromServer(): cannot cast to Package class" );
      e.printStackTrace( );
    } catch ( IOException e ) {
      System.out.println( ">>>>> ServerConnector.listenFromServer(): " +
          "IOException while reading from socket" );
      e.printStackTrace( );
    }

    if ( packet instanceof Data ) {
      Data data = (Data) packet;
      this.pickUpFromServer.handleDataListeners( data );
    } 
  }

  public void disconnect( ) {
    try {
      this.socket.close( );
      this.isConnected = false;
      
    } catch ( IOException e ) {
      System.out.println(
          ">>>>> ServerConnector.disconnect(): IOException while closing socket" );
      e.printStackTrace( );
    }
  }

  public boolean isConnected( ) {
    return this.isConnected;
  }

  public void setConnected( boolean isConnected ) {
    this.isConnected = isConnected;
  }
    
  private void listenThread( ) {
    Thread incomingReader = new Thread( new IncomingReader( ) );
    incomingReader.start( );
  }

  public class IncomingReader implements Runnable {
    public void run( ) {
      while ( true ) {
        ServerConnector.this.listenFromServer( );
      }
    }
  }
}