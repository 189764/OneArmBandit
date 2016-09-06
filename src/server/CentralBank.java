package server;

import server.Bandit;
import server.exceptions.NotEnoughMoneyException;

public class CentralBank {

	private int points;
	
	public CentralBank() {

	}
	
	public CentralBank(int points) {
		this.points = points;
	}

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
		bandit.addPoints(quantity);
	}
	
	public void addPoints(int quantity) {
		points += quantity;
	}
	

	
	
}