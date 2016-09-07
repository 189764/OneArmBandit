package client.networkClient;

import shared.packet.Data;

public interface IDataListener {

  /**
   * @param data
   */
  void handleData( Data data );

}
