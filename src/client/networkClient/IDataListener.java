package client.networkClient;

import shared.packet.Data;
import shared.packet.Instruction;

public interface IDataListener {

  void handleData( Data data );

}