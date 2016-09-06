package client.networkClient;

import shared.packet.Data;

public interface IDataListener {

  void handleData( Data data );

}
