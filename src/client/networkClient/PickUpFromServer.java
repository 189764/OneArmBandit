package client.networkClient;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import shared.packet.Data;

public class PickUpFromServer {

  private List<IDataListener> dataListeners = new CopyOnWriteArrayList<IDataListener>( );

  /**
   * @param listener - IDataListener
   * add data listener to the list of listeners
   */
  public void addDataListener( IDataListener listener ) {
    this.dataListeners.add( listener );
  }

  /**
   * @param data - data containing package from server
   */
  public void handleDataListeners( Data data ) {
    for ( IDataListener listener : this.dataListeners ) {
      listener.handleData( data );
    }
  }
}
