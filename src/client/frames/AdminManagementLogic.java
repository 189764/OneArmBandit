package client.frames;

import java.util.ArrayList;
import java.util.List;

import client.networkClient.DeliverToServer;
import client.networkClient.IDataListener;
import client.networkClient.PickUpFromServer;
import client.networkClient.ServerConnector;
import server.Bandit;
import server.CentralBank;
import shared.packet.Data;

public class AdminManagementLogic implements IDataListener {

	private AdminManagementFrame adminManagementFrame;
	private DeliverToServer deliverToServer;
	private PickUpFromServer pickUpFromServer;
	private ServerConnector serverConnector;
	private String login;

	public AdminManagementLogic(ServerConnector serverConnector, PickUpFromServer pickUpFromServer ) {
		this.pickUpFromServer = pickUpFromServer;
		this.serverConnector = serverConnector;
		this.login = login;
		this.deliverToServer = new DeliverToServer(serverConnector);
		pickUpFromServer.addDataListener(this);
		adminManagementFrame = new AdminManagementFrame(this);
	}

	List<Integer> listOfSymbolValues = new ArrayList<Integer>();

	public void setSymbolValues( ArrayList<Integer> listOfSymbolValues) {
		deliverToServer.setSymbols( listOfSymbolValues );
	}

	@Override
	public void handleData(Data data) {
		// TODO Auto-generated method stub

	}
	
	public void sendPointsToBandit( Integer points ) {
		deliverToServer.transferPoints(points);
	}

	public void logOut() {
		deliverToServer.logOut(login);
		adminManagementFrame.dispose();
		new LoginLogic(serverConnector, pickUpFromServer);
	}

}
