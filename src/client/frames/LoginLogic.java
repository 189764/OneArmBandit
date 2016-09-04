package client.frames;

import client.frames.LoginFrame;
import client.networkClient.PickUpFromServer;
import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;
import javax.swing.JOptionPane;

public class LoginLogic implements IDataListener {

  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private LoginFrame loginFrame;

  public LoginLogic( ServerConnector serverConnector, 
      PickUpFromServer pickUpFromServer ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    loginFrame = new LoginFrame ( this );
  }

  public void logIn( String login, String password ) {
    System.out.println( "login " + login + " haslo " + password );
    deliverToServer.logIn( login, password );
  }
  
  public void register( ) {
    new RegistrationLogic( this.serverConnector, 
        this.pickUpFromServer );
    loginFrame.dispose( );
  }

  @Override
  public void handleData( Instruction instruction ) {
    if ( instruction == Instruction.LOG_IN_SUCCESS ) {
            loginFrame.dispose( );
      } else if ( instruction == Instruction.LOG_IN_ERROR ) {
        JOptionPane.showMessageDialog( null, "Wrong username or password" );
      }
    }

}

