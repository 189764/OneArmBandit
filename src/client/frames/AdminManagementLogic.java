package client.frames;

import java.util.ArrayList;
import java.util.List;

import server.Bandit;
import server.CentralBank;

public class AdminManagementLogic {

	private CentralBank bank;
	private Bandit bandit;
	
	public AdminManagementLogic(CentralBank bank, Bandit bandit) {
		super();
		this.bank = bank;
		this.bandit = bandit;
	}

	List<Integer> listOfSymbolValues = new ArrayList<Integer>();
	
	public void setSymbolValues(List<Integer> listOfSymbolValues) {
		Bandit.setSymbolOne(listOfSymbolValues.get(0));
		Bandit.setSymbolTwo(listOfSymbolValues.get(1));
		Bandit.setSymbolThree(listOfSymbolValues.get(2));
		Bandit.setSymbolFour(listOfSymbolValues.get(3));
		Bandit.setSymbolFive(listOfSymbolValues.get(4));
		Bandit.setSymbolSix(listOfSymbolValues.get(5));
		Bandit.setSymbolSeven(listOfSymbolValues.get(6));
		Bandit.setSymbolEight(listOfSymbolValues.get(7));
		Bandit.setSymbolNine(listOfSymbolValues.get(8));
	}
	
	public void transferPoints(int quantity) {
		bank.transferMoney(bandit, quantity);
	}
	
}
