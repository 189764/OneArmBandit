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

/**
 * class represents logic of changing password
 */
public class ChangingPasswordLogic implements IDataListener {

  private static final Logger LOGGER = LogManager
    .getLogger( ChangingPasswordLogic.class );

  private DeliverToServer deliverToServer;
  private ChangingPasswordFrame changingPasswordFrame;
  private String login;

  /**
   * @param serverConnector - serverConnector
   * @param pickUpFromServer - PickUpFromServer
   * @param login - String
   */
  public ChangingPasswordLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer, String login ) {
    this.login = login;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    changingPasswordFrame = new ChangingPasswordFrame( this );
  }

  /**
   * @param password - first inserted password
   * @param password1 - second inserted password
   * they have to be the same
   */
  public void changePassword( String password, String password1 ) {
    if ( !password.equals( password1 ) ) {
      JOptionPane.showMessageDialog( null, "Passwords are different" );
    }
    deliverToServer.changePassword( login, password );
  }

  /* (non-Javadoc)
   * @see client.networkClient.IDataListener#handleData(shared.packet.Data)
   */
  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD_SUCCESS ) {
      LOGGER.info( "Password has been changed" );
      changingPasswordFrame.dispose( );
    } else if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD_ERROR ) {
      JOptionPane.showMessageDialog( null, "Wrong passwords" );
      LOGGER.error( "Password has not beed changed" );
    }
  }

}
