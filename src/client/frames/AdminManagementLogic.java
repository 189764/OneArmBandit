package client.frames;

import java.util.ArrayList;
import java.util.List;

import client.networkClient.DeliverToServer;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;

/**
 * class represents admin panel logic
 */
public class AdminManagementLogic {

  private AdminManagementFrame adminManagementFrame;
  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private String login;

  /**
   * @param serverConnector - ServerConnector
   * @param pickUpFromServer - PickUpFromServer
   */
  public AdminManagementLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    this.deliverToServer = new DeliverToServer( serverConnector );
    adminManagementFrame = new AdminManagementFrame( this );
  }

  List<Integer> listOfSymbolValues = new ArrayList<Integer>( );

  /**
   * @param listOfSymbolValues - list of symbols got from frame
   */
  public void setSymbolValues( ArrayList<Integer> listOfSymbolValues ) {
    deliverToServer.setSymbols( listOfSymbolValues );
  }

  /**
   * @param money - money transfered from bank to bandit
   */
  public void sendPointsToBandit( Integer money ) {
    deliverToServer.transferPoints( money );
  }

  public void logOut( ) {
    deliverToServer.logOut( login );
    adminManagementFrame.dispose( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
