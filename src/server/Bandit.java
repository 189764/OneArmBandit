package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.Bandit;
import server.exceptions.NotEnoughMoneyInBanditException;
import shared.data.User;
public class Bandit {

	private Random generator;
	private int bank;

	private int[][] tab;

	private static int symbolOne = 1;
	private static int symbolTwo = 2;
	private static int symbolThree = 3;
	private static int symbolFour = 4;
	private static int symbolFive = 5;
	private static int symbolSix = 6;
	private static int symbolSeven = 7;
	private static int symbolEight = 8;
	private static int symbolNine = 9;
	
	
	
	public Bandit() {
		super();
		bank = 0;
		generator = new Random();
		tab = new int[3][3];
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
	
	public void bet(User user) {
		if(bank < maxSymbol()*user.getStake()){
			throw new NotEnoughMoneyInBanditException();
		} else {
		
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
	}
	

	
	public static int getSymbolOne() {
		return symbolOne;
	}


	public static void setSymbolOne(int symbolOne) {
		Bandit.symbolOne = symbolOne;
	}


	public static int getSymbolTwo() {
		return symbolTwo;
	}


	public static void setSymbolTwo(int symbolTwo) {
		Bandit.symbolTwo = symbolTwo;
	}


	public static int getSymbolThree() {
		return symbolThree;
	}


	public static void setSymbolThree(int symbolThree) {
		Bandit.symbolThree = symbolThree;
	}


	public static int getSymbolFour() {
		return symbolFour;
	}


	public static void setSymbolFour(int symbolFour) {
		Bandit.symbolFour = symbolFour;
	}


	public static int getSymbolFive() {
		return symbolFive;
	}


	public static void setSymbolFive(int symbolFive) {
		Bandit.symbolFive = symbolFive;
	}


	public static int getSymbolSix() {
		return symbolSix;
	}


	public static void setSymbolSix(int symbolSix) {
		Bandit.symbolSix = symbolSix;
	}


	public static int getSymbolSeven() {
		return symbolSeven;
	}


	public static void setSymbolSeven(int symbolSeven) {
		Bandit.symbolSeven = symbolSeven;
	}


	public static int getSymbolEight() {
		return symbolEight;
	}


	public static void setSymbolEight(int symbolEight) {
		Bandit.symbolEight = symbolEight;
	}


	public static int getSymbolNine() {
		return symbolNine;
	}


	public static void setSymbolNine(int symbolNine) {
		Bandit.symbolNine = symbolNine;
	}


	
}
