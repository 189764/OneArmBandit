package client.networkClient;

import java.util.ArrayList;
import client.networkClient.ServerConnector;
import shared.packet.Instruction;
import shared.packet.Package;
import shared.packet.Data;

public class DeliverToServer {

  private ServerConnector serverConnector;

  public DeliverToServer( ServerConnector serverConnector ) {
    this.serverConnector = serverConnector;
  }

  public void logIn( String login, String password ) {
    Package userData = new Data( login, password, Instruction.LOG_IN );
    this.serverConnector.sendToServer( userData );
  }

  public void register( String login, String password ) {
    Package userData = new Data( login, password, Instruction.REGISTER );
    this.serverConnector.sendToServer( userData );
  }

  public void changePassword( String login, String password ) {
    Package userData = new Data( login, password, Instruction.CHANGE_PASSWORD );
    this.serverConnector.sendToServer( userData );
  }

  public void resetPassword( String login ) {
    Package userData = new Data( login, "", Instruction.RESET_PASSWORD );
    this.serverConnector.sendToServer( userData );
  }

  public void logOut( String login ) {
    Package userData = new Data( login, "", Instruction.LOG_OUT );
    this.serverConnector.sendToServer( userData );
  }

  public void play( String login, Integer stake ) {
    Data userData = new Data( login, "", Instruction.PLAY );
    userData.setPoints( stake );
    this.serverConnector.sendToServer( userData );
  }

  public void askRanking( String login ) {
    Package userData = new Data( login, "", Instruction.ASK_RANKING );
    this.serverConnector.sendToServer( userData );
  }

  public void askPoints( String login ) {
    Package userData = new Data( login, "", Instruction.ASK_POINTS );
    this.serverConnector.sendToServer( userData );
  }

  public void transferPoints( Integer points ) {
    Data userData = new Data( "", "", Instruction.TRANSFER );
    userData.setPoints( points );
    this.serverConnector.sendToServer( userData );
  }

  public void setSymbols( ArrayList<Integer> listOfSymbolValues ) {
    Data userData = new Data( "", "", Instruction.SET_OF_SYMBOL_VALUES );
    userData.setListOfSymbolValues( listOfSymbolValues );
    this.serverConnector.sendToServer( userData );
  }

}
