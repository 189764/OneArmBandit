package client;

import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

public class Main {

  public static void main( String [ ] args ) {
    // TODO Auto-generated method stub
    PickUpFromServer pickUpFromServer = new PickUpFromServer( );
    ServerConnector serverConnector = new ServerConnector( pickUpFromServer );
    serverConnector.connect( );
  }

}
