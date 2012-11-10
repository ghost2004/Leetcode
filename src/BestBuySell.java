/*
 * 
 * Say you have an array for which the ith element is 
 * the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 *  (ie, buy one and sell one share of the stock), 
 *  design an algorithm to find the maximum profit.
 * 
 * 
 */
public class BestBuySell {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        int profit = 0;
        int curProfit = 0;
        int min = prices[0];
        
        int i = 0;
        for (i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                curProfit = prices[i] - min;
                if (curProfit > profit)
                    profit = curProfit;
            }
        }
        
        
        return profit;
        
    }

}
