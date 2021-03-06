package client.frames;

import client.networkClient.PickUpFromServer;
import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationLogic implements IDataListener {

  private static final Logger LOGGER = LogManager
    .getLogger( RegistrationLogic.class );

  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private RegistrationFrame registrationFrame;

  /**
   * @param serverConnector - ServerConnector
   * @param pickUpFromServer - PickUpFromServer
   */
  public RegistrationLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    registrationFrame = new RegistrationFrame( this );
  }

  /**
   * @param login - String
   * @param password - String - first inserted password
   * @param password1 - String - second inserted password
   * passwords have to be the same
   */
  public void register( String login, String password, String password1 ) {
    if ( !password.equals( password1 ) ) {
      JOptionPane.showMessageDialog( null, "Passwords are different" );
    }
    deliverToServer.register( login, password );
  }

  /**
   * new login window
   */
  public void logIn( ) {
    new LoginLogic( this.serverConnector, this.pickUpFromServer );
    registrationFrame.dispose( );
  }

  /* (non-Javadoc)
   * @see client.networkClient.IDataListener#handleData(shared.packet.Data)
   */
  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.REGISTER_SUCCES ) {
      LOGGER.info( "register" );
      registrationFrame.dispose( );
      new MainUserLogic( serverConnector, pickUpFromServer, data.getLogin( ) );
    } else if ( data.getInstruction( ) == Instruction.REGISTER_ERROR ) {
      JOptionPane.showMessageDialog( null,
          "Wrong username - probably already exists" );
    }
  }

}
