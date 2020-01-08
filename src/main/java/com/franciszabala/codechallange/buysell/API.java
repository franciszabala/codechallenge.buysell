package com.franciszabala.codechallange.buysell;


public class API {
	
	
	public static int[] prices;
	
	public static int getNumDays() {
		return prices.length;
	}

	public static int getPriceOnDay(int i) {
		return prices[i];
	}
			
}
