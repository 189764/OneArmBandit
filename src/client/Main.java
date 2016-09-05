package client;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import client.frames.LoginLogic;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

public class Main {

  public static void main( String [ ] args ) throws ConnectException, UnknownHostException, IOException {
    // TODO Auto-generated method stub
    PickUpFromServer pickUpFromServer = new PickUpFromServer( );
    ServerConnector serverConnector = new ServerConnector( pickUpFromServer );
    serverConnector.connect( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
