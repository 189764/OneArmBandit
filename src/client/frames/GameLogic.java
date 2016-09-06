package client.frames;

import javax.swing.JOptionPane;

import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;
import shared.packet.Data;
import shared.packet.Instruction;

public class GameLogic implements IDataListener {

  private GameFrame gameFrame;
  private DeliverToServer deliverToServer;
  private String login;

  public GameLogic( ServerConnector serverConnector,
      PickUpFromServer pickUpFromServer, String login ) {
    this.login = login;
    this.deliverToServer = new DeliverToServer( serverConnector );
    pickUpFromServer.addDataListener( this );
    gameFrame = new GameFrame( this );
  }

  public void play( Integer stake ) {
    deliverToServer.play( this.login, stake );
  }

  public void showPoints( ) {
    this.deliverToServer.askPoints( login );
  }

  public void showResult( Object [ ] [ ] ranking ) {

    gameFrame.getLabel1( ).setText( ( ranking[ 0 ][ 0 ] ).toString( ) );
    gameFrame.getLabel2( ).setText( ( ranking[ 0 ][ 1 ] ).toString( ) );
    gameFrame.getLabel3( ).setText( ( ranking[ 0 ][ 2 ] ).toString( ) );
    gameFrame.getLabel4( ).setText( ( ranking[ 1 ][ 0 ] ).toString( ) );
    gameFrame.getLabel5( ).setText( ( ranking[ 1 ][ 1 ] ).toString( ) );
    gameFrame.getLabel6( ).setText( ( ranking[ 1 ][ 2 ] ).toString( ) );
    gameFrame.getLabel7( ).setText( ( ranking[ 2 ][ 0 ] ).toString( ) );
    gameFrame.getLabel8( ).setText( ( ranking[ 2 ][ 1 ] ).toString( ) );
    gameFrame.getLabel9( ).setText( ( ranking[ 2 ][ 2 ] ).toString( ) );
    gameFrame.repaint( );
  }

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
