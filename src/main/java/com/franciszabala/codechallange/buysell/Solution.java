package com.franciszabala.codechallange.buysell;

public class Solution implements SolutionInterface {
    
    private int buyDay = 0;
    private int sellDay = 0;
    
    public Solution() {
        // You can initiate and calculate things here
        int numOfDays = API.getNumDays();
        int buyPrice = 0;
        int max_diff = API.getPriceOnDay(1) - API.getPriceOnDay(0);

        for (int i = 0; i < numOfDays;i++) {
        	buyPrice = API.getPriceOnDay(i);
        	for (int j = i+1; j < numOfDays; j++) {
        		//stocks is actually lower than when we bought it. Don't sell
        		if (buyPrice < API.getPriceOnDay(j)) {
        			int currentDiff = API.getPriceOnDay(j) - buyPrice;
        			//System.out.println("currentDiff: " +currentDiff);
        			if (currentDiff > max_diff || 
        					/* If price is the same, choose the lowest buy price */
        					((currentDiff == max_diff) && (buyPrice < API.getPriceOnDay(buyDay)) )) {
        				max_diff = currentDiff;
        				buyDay = i;
        			}
        		} else {
        			continue;
        		}
        		
        	}
        	
        }
        
        //time to get selling point
        
        int sellPrice = 0;
        int max_differ = 0;
        for (int i = buyDay + 1 ; i < numOfDays; i++) {
        	sellPrice = API.getPriceOnDay(i);
        	
        			int currentDiff = sellPrice - max_diff;
        			if (currentDiff >= max_differ) {
        				max_differ = currentDiff;
        				sellDay = i;
        			}

  
        }
    }

    /**
     * Return the day which you buy gold. The first day has number zero. This method is
     * called first, and only once.
     */
    public int getBuyDay() {
        // Write your code here
        return buyDay;
    }

    /**
     * Return the day to sell gold on. This day has to be after (greater than) the buy
     * day. The first day has number zero (although this is not a valid sell day). This
     * method is called second, and only once.
     */
    public int getSellDay() {
        // Write your code here
        return sellDay;
    }
}	