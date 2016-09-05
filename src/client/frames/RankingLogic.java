package client.frames;


public class RankingLogic {

  private RankingFrame loginFrame;

  public RankingLogic( Object ranking[][] ) {
    loginFrame = new RankingFrame ( this, ranking );
  }

}
