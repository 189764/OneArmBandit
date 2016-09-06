package client.frames;

import java.util.ArrayList;
import java.util.List;

import client.networkClient.DeliverToServer;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

public class AdminManagementLogic {

  private AdminManagementFrame adminManagementFrame;
  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private String login;

  public AdminManagementLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    this.deliverToServer = new DeliverToServer( serverConnector );
    adminManagementFrame = new AdminManagementFrame( this );
  }

  List<Integer> listOfSymbolValues = new ArrayList<Integer>( );

  public void setSymbolValues( ArrayList<Integer> listOfSymbolValues ) {
    deliverToServer.setSymbols( listOfSymbolValues );
  }

  public void sendPointsToBandit( Integer points ) {
    deliverToServer.transferPoints( points );
  }

  public void logOut( ) {
    deliverToServer.logOut( login );
    adminManagementFrame.dispose( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
