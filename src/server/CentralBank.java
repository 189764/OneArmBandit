package server;

import server.Bandit;
import server.exceptions.NotEnoughMoneyException;

public class CentralBank {

	private int points;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void transferMoney(Bandit bandit, int quantity) {
		
		if(points < quantity){
			throw new NotEnoughMoneyException();
		}
		
	}
	
	
	
	
}