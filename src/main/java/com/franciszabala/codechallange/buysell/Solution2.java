package com.franciszabala.codechallange.buysell;

public class Solution2 implements SolutionInterface {
    
    private int buyDay = 0;
    private int sellDay = 0;
    
    public Solution2() {
        // You can initiate and calculate things here
        int numOfDays = API.getNumDays();
        int max_diff = API.getPriceOnDay(1) - API.getPriceOnDay(0);
        
        int curr_sum = max_diff;  
        int max_sum = curr_sum;  
      
        //https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
        for(int i = 1; i < numOfDays - 1; i++)  
        { 
            // Calculate current diff  
        	max_diff = API.getPriceOnDay(i + 1) - API.getPriceOnDay(i);  
      
            // Calculate current sum  
            if (curr_sum > 0)  
            curr_sum += max_diff;  
            else
            curr_sum = max_diff;  
      
            // Update max sum, if needed  
            if (curr_sum > max_sum) {
            	max_sum = curr_sum;
            	buyDay = i;
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