package client.frames;

import javax.swing.JOptionPane;

import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;

/**
 * class represents logic of main game
 */
public class GameLogic implements IDataListener {

  private GameFrame gameFrame;
  private DeliverToServer deliverToServer;
  private String login;

  /**
   * @param serverConnector - serverConnector
   * @param pickUpFromServer - PickUpFromServer
   * @param login - String
   */
  public GameLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer, String login ) {
    this.login = login;
    this.deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    gameFrame = new GameFrame( this );
  }

  /**
   * @param stake - Integer - stake of play inserted by player
   */
  public void play( Integer stake ) {
    deliverToServer.play( this.login, stake );
  }

  /**
   * asks server for player account
   */
  public void showPoints( ) {
    this.deliverToServer.askPoints( login );
  }

  /**
   * @param result - result on player screen
   */
  public void showResult( Object [ ] [ ] result ) {

    gameFrame.getLabel1( ).setText( ( result[ 0 ][ 0 ] ).toString( ) );
    gameFrame.getLabel2( ).setText( ( result[ 0 ][ 1 ] ).toString( ) );
    gameFrame.getLabel3( ).setText( ( result[ 0 ][ 2 ] ).toString( ) );
    gameFrame.getLabel4( ).setText( ( result[ 1 ][ 0 ] ).toString( ) );
    gameFrame.getLabel5( ).setText( ( result[ 1 ][ 1 ] ).toString( ) );
    gameFrame.getLabel6( ).setText( ( result[ 1 ][ 2 ] ).toString( ) );
    gameFrame.getLabel7( ).setText( ( result[ 2 ][ 0 ] ).toString( ) );
    gameFrame.getLabel8( ).setText( ( result[ 2 ][ 1 ] ).toString( ) );
    gameFrame.getLabel9( ).setText( ( result[ 2 ][ 2 ] ).toString( ) );
    gameFrame.repaint( );
  }

  /* (non-Javadoc)
   * @see client.networkClient.IDataListener#handleData(shared.packet.Data)
   */
  @Override
  public void handleData( Data data ) {
    if ( data.getInstruction( ) == Instruction.SEND_RESULT ) {
      showResult( (Integer [ ] [ ]) data.getRanking( ) );
    }
    if ( data.getInstruction( ) == Instruction.WON ) {
      JOptionPane.showMessageDialog( null, "Prize: " + data.getPoints( ) );
    }
  }
}
