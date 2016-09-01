package client.networkClient;

import shared.packet.Instruction;

public interface IDataListener {

  void handleData( Instruction instruction );

}