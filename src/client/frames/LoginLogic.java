package client.frames;

import client.Main;
import client.frames.LoginFrame;
import client.networkClient.PickUpFromServer;
import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginLogic implements IDataListener {

  private static final Logger LOGGER = LogManager.getLogger( Main.class );

  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private LoginFrame loginFrame;

  /**
   * @param serverConnector - ServerConnector
   * @param pickUpFromServer - PickUpFromServer
   */
  public LoginLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    loginFrame = new LoginFrame( this );
  }

  /**
   * @param login - String
   * @param password - String
   */
  public void logIn( String login, String password ) {
    LOGGER.info( "login " + login + " haslo " + password );
    deliverToServer.logIn( login, password );
  }

  /**
   * new registration window
   */
  public void register( ) {
    new RegistrationLogic( this.serverConnector, this.pickUpFromServer );
    loginFrame.dispose( );
  }

  /* (non-Javadoc)
   * @see client.networkClient.IDataListener#handleData(shared.packet.Data)
   */
  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.LOG_IN_SUCCESS_USER ) {
      loginFrame.dispose( );
      new MainUserLogic( serverConnector, pickUpFromServer, data.getLogin( ) );
    } else if ( data.getInstruction( ) == Instruction.LOG_IN_SUCCESS_ADMIN ) {
      loginFrame.dispose( );
      new AdminManagementLogic( serverConnector, pickUpFromServer );
    } else if ( data.getInstruction( ) == Instruction.LOG_IN_ERROR ) {
      JOptionPane.showMessageDialog( null, "Wrong username or password" );
    }
  }

}
