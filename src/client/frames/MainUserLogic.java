package client.frames;

import javax.swing.JOptionPane;

import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;

public class MainUserLogic implements IDataListener {

  private MainUserFrame mainUserFrame;
  private DeliverToServer deliverToServer;
  private PickUpFromServer pickUpFromServer;
  private ServerConnector serverConnector;
  private String login;

  /**
   * @param serverConnector - serverConnector
   * @param pickUpFromServer - PickUpFromServer
   * @param login - String
   */
  public MainUserLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer, String login ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    this.login = login;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    mainUserFrame = new MainUserFrame( this );
  }

  /**
   * asks server to send a ranking
   */
  public void showRanking( ) {
    deliverToServer.askRanking( "" );
  }

  /**
   * plays the game
   */
  public void play( ) {
    new GameLogic( serverConnector, pickUpFromServer, login );
  }

  /**
   * new password change window
   */
  public void changePassword( ) {
    new ChangingPasswordLogic( serverConnector, pickUpFromServer, login );
  }

  /* (non-Javadoc)
   * @see client.networkClient.IDataListener#handleData(shared.packet.Data)
   */
  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.SEND_RANKING ) {
      new RankingLogic( data.getRanking( ) );
    }
    if ( data.getInstruction( ) == Instruction.SEND_POINTS ) {
      JOptionPane.showMessageDialog( null, "Your points: " + data.getPoints( ) );
    }
  }

  /**
   * asks server to show how many points user has
   */
  public void showPoints( ) {
    deliverToServer.askPoints( login );
  }

  /**
   * log out and run new login window
   */
  public void logOut( ) {
    deliverToServer.logOut( login );
    mainUserFrame.dispose( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
