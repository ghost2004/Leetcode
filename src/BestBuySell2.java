/*
 * Say you have an array for which the ith element is
 *  the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 *
 * However, you may not engage in multiple transactions at the same time
 *  (ie, you must sell the stock before you buy again).
 */

public class BestBuySell2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int profit = 0;
        int curMin = prices[0];
        int i = 0;

        for (i = 1; i < prices.length; i++) {
            if (prices[i]  < prices[i-1]) {
                profit += prices[i-1] - curMin;
                curMin = prices[i];
            }

        }
        
        if (prices[i-1] > curMin)
            profit += prices[i-1] - curMin;
        return profit;
        
    }


}
