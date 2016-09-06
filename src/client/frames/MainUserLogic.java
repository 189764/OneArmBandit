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
  
  public MainUserLogic( ServerConnector serverConnector, 
      PickUpFromServer pickUpFromServer, String login ) {
    this.pickUpFromServer = pickUpFromServer;
    this.serverConnector = serverConnector;
    this.login = login;
    deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    mainUserFrame = new MainUserFrame ( this );
  }
  
  
  public void showRanking( ) {
    deliverToServer.askRanking( "" );
  }
  
  public void play( ) {
    new GameLogic( serverConnector, pickUpFromServer, login );
  }
  
  public void changePassword( ) {
    new ChangingPasswordLogic( serverConnector, pickUpFromServer,
        login );
  }


  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.SEND_RANKING ) {
      System.out.println( "ranking" );
      new RankingLogic( data.getRanking( ) );
      }
    if ( data.getInstruction( ) == Instruction.SEND_POINTS ) {
      JOptionPane.showMessageDialog( null, "Your points: " + data.getPoints( ) );
    }
    }


  public void showPoints( ) {
    deliverToServer.askPoints( login );
  }


  public void logOut( ) {
    deliverToServer.logOut( login );
    mainUserFrame.dispose( );
    new LoginLogic( serverConnector, pickUpFromServer );
  }

}
