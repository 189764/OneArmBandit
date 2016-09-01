package client.networkClient;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import shared.packet.Data;



public class PickUpFromServer {

  private List<IDataListener> dataListeners = 
      new CopyOnWriteArrayList<IDataListener>( );
  
  public void addDataListener( IDataListener listener ) {
    this.dataListeners.add( listener );
  }
  
  public void handleDataListeners( Data data ) {
    for ( IDataListener listener : this.dataListeners ) {
      listener.handleData( data.getInstruction( ) );
    }
  }
}