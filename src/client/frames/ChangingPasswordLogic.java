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

public class ChangingPasswordLogic implements IDataListener {

  private static final Logger LOGGER = LogManager
    .getLogger( ChangingPasswordLogic.class );

  private DeliverToServer deliverToServer;
  private ChangingPasswordFrame changingPasswordFrame;
  private String login;

  public ChangingPasswordLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer, String login ) {
    this.login = login;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    changingPasswordFrame = new ChangingPasswordFrame( this );
  }

  public void changePassword( String password, String password1 ) {
    if ( !password.equals( password1 ) ) {
      JOptionPane.showMessageDialog( null, "Passwords are different" );
    }
    deliverToServer.changePassword( login, password );
  }

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
