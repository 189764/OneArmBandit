package server;

import server.Bandit;
import server.exceptions.NotEnoughMoneyException;

/**
 * represents bank
 */
public class CentralBank {

  private int points;

  public CentralBank( ) {

  }

  public CentralBank( int points ) {
    this.points = points;
  }

  public int getPoints( ) {
    return points;
  }

  public void setPoints( int points ) {
    this.points = points;
  }

  /**
   * @param bandit - bandit to transfer money
   * @param quantity - the amount of money to transfer
   */
  public void transferMoney( Bandit bandit, int quantity ) {

    if ( points < quantity ) {
      throw new NotEnoughMoneyException( );
    }
    bandit.addPoints( quantity );
  }

  public void addPoints( int quantity ) {
    points += quantity;
  }

}
