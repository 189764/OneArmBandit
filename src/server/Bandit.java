package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.Bandit;
import server.exceptions.NotEnoughMoneyException;
import server.exceptions.NotEnoughMoneyInBanditException;
import shared.data.User;
public class Bandit {

	private Random generator;
	private int bank;

	private Integer[][] tab;

	private int symbolOne = 1;
	private int symbolTwo = 2;
	private int symbolThree = 3;
	private int symbolFour = 4;
	private int symbolFive = 5;
	private int symbolSix = 6;
	private int symbolSeven = 7;
	private int symbolEight = 8;
	private int symbolNine = 9;
	
	
	
	public Bandit() {
		bank = 5000;
		generator = new Random();
		tab = new Integer[3][3];
	}

	public void addPoints(int points) {
		bank += points;
	}
	
	public int maxSymbol() {
		List<Integer> symbols = new ArrayList<Integer>();
		symbols.add(symbolOne);
		symbols.add(symbolTwo);
		symbols.add(symbolThree);
		symbols.add(symbolFour);
		symbols.add(symbolFive);
		symbols.add(symbolSix);
		symbols.add(symbolSeven);
		symbols.add(symbolEight);
		symbols.add(symbolNine);
		int max = symbolNine;
		for(int x : symbols) {
		 if(x > max){
			 max = x;
		 }
		}
		return max;
	}
	
	public int whatPrize(int symbol) {
		if(symbol == 1) {
			return symbolOne;
		} else if (symbol == 2) {
			return symbolTwo;
		} else if (symbol == 3) {
			return symbolThree;
		} else if (symbol == 4) {
			return symbolFour;
		} else if (symbol == 5) {
			return symbolFive;
		} else if (symbol == 6) {
			return symbolSix;
		} else if (symbol == 7) {
			return symbolSeven;
		} else if (symbol == 8) {
			return symbolEight;
		} else if (symbol == 9) {
			return symbolNine;
		} else {
			return 0;
		}
	}
	
	
	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}
	
	public void increaseBankLevel(int money) {
		bank += money;
	}
	
	public void decreaseBankLevel(int money) {
		
		if(bank < money) {
			throw new NotEnoughMoneyInBanditException();
		} else {
			bank -= money;
		}
	}
	
	public void cashOut(int prize, User user) {
		
		user.addPoints(prize);
		bank -= prize;
	
	}
	
	public void randomSymbols() {
		
		for(int i = 0 ; i<3 ; i++)
		{
			for(int j = 0 ; j < 3 ; j++ ) {
				tab[i][j] = generator.nextInt(9)+1;
			}
		}
	
	}
	
	public Integer[][] bet(User user) {
		if(bank < maxSymbol()*user.getStake()){
			throw new NotEnoughMoneyInBanditException();
		} else if(user.getPoints()<user.getStake()) {
			
				throw new NotEnoughMoneyException();
			
		}		
		
		else {
		user.minusPoints(user.getStake());
		bank += user.getStake();
		int prize = 0;
		randomSymbols();
		
		for(int i = 0 ; i<3 ; i++)
		{
			int counter = 0;
			for(int j = 0 ; j < 3 ; j++ ) {
				
			  if( j > 0) {
				 if(tab[i][j]==tab[i][j-1]) 
				 {
					 counter++;
					 if(counter == 2) {
						 
						prize += whatPrize(tab[i][j])*user.getStake();
					 }
				 }
			  } 
			  
			}
		}
		if(prize>0){
			cashOut(prize, user);
		}
		
		}
		return tab;
	}
	

	
	public int getSymbolOne() {
		return symbolOne;
	}


	public void setSymbolOne(int symbolOne) {
		this.symbolOne = symbolOne;
	}


	public  int getSymbolTwo() {
		return symbolTwo;
	}


	public  void setSymbolTwo(int symbolTwo) {
		this.symbolTwo = symbolTwo;
	}


	public  int getSymbolThree() {
		return symbolThree;
	}


	public  void setSymbolThree(int symbolThree) {
		this.symbolThree = symbolThree;
	}


	public  int getSymbolFour() {
		return symbolFour;
	}


	public  void setSymbolFour(int symbolFour) {
		this.symbolFour = symbolFour;
	}


	public  int getSymbolFive() {
		return symbolFive;
	}


	public  void setSymbolFive(int symbolFive) {
		this.symbolFive = symbolFive;
	}


	public  int getSymbolSix() {
		return symbolSix;
	}


	public  void setSymbolSix(int symbolSix) {
		this.symbolSix = symbolSix;
	}


	public  int getSymbolSeven() {
		return symbolSeven;
	}


	public  void setSymbolSeven(int symbolSeven) {
		this.symbolSeven = symbolSeven;
	}


	public  int getSymbolEight() {
		return symbolEight;
	}


	public  void setSymbolEight(int symbolEight) {
		this.symbolEight = symbolEight;
	}


	public  int getSymbolNine() {
		return symbolNine;
	}


	public  void setSymbolNine(int symbolNine) {
		this.symbolNine = symbolNine;
	}


	
}
