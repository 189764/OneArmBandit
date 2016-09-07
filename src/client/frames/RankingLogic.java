package client.frames;

public class RankingLogic {

  /**
   * @param ranking - table of ranking of players
   */
  public RankingLogic( Object ranking[][] ) {
    new RankingFrame( this, ranking );
  }

}
