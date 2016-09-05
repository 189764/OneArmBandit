package client.frames;

import client.networkClient.PickUpFromServer;
import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;
import javax.swing.JOptionPane;

public class ChangingPasswordLogic implements IDataListener {

  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private ChangingPasswordFrame changingPasswordFrame;
  private String login;
  
  public ChangingPasswordLogic( ServerConnector serverConnector, 
      PickUpFromServer pickUpFromServer, String login ) {
    this.login = login;
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    changingPasswordFrame = new ChangingPasswordFrame ( this );
  }

  public void changePassword( String password, String password1 ) {
    if ( !password.equals( password1 ) ) {
      JOptionPane.showMessageDialog( null, "Passwords are different" );
    }
    deliverToServer.changePassword( login, password );
  }

  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD_SUCCESS) {
      System.out.println( "password changed" );
      changingPasswordFrame.dispose( );
      } else if ( data.getInstruction( ) == Instruction.CHANGE_PASSWORD_ERROR ) {
        JOptionPane.showMessageDialog( null, "Wrong passwords" );
      }
    }

}

