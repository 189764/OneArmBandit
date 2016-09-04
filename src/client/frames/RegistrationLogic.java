package client.frames;

import client.networkClient.PickUpFromServer;
import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.ServerConnector;
import shared.packet.Instruction;
import javax.swing.JOptionPane;

public class RegistrationLogic implements IDataListener {

  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private RegistrationFrame registrationFrame;

  public RegistrationLogic( ServerConnector serverConnector, 
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    registrationFrame = new RegistrationFrame ( this );
  }

  public void register( String login, String password, String password1 ) {
    if ( !password.equals( password1 ) ) {
      JOptionPane.showMessageDialog( null, "Passwords are different" );
    }
    deliverToServer.register( login, password );
  }
  
  public void logIn( ) {
    new LoginLogic( this.serverConnector, 
        this.pickUpFromServer );
    registrationFrame.dispose( );
  }

  @Override
  public void handleData( Instruction instruction ) {
    if ( instruction == Instruction.REGISTER_SUCCES ) {
      System.out.println( "register" );
      registrationFrame.dispose( );
      } else if ( instruction == Instruction.REGISTER_ERROR ) {
        JOptionPane.showMessageDialog( null, "Wrong username - probably already exists" );
      }
    }

}

