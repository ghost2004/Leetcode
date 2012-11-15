/*
 * Say you have an array for which the ith element 
 * is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the 
 * same time (ie, you must sell the stock before you buy again).
 */
public class BestBuySell3 {

    public int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        int size = prices.length;
        if (size <= 1)
            return 0;
        /*
         * To solve this problem, we can split the array into 2 subset ,
         * one for each trade
         */
        // The profit of left side trade
        int[] profit1 = new int[size];
        // The profit of right side trade
        int[] profit2 = new int[size];
        
        int curMin = prices[0];
        int curMax = prices[size-1];
        
        // The profit for first day on the left side is always 0
        // Because there is only one value there
        profit1[0] = 0;
        // The profit for last day on the right side is always 0
        // Because there is only one value there
        profit2[size-1] = 0;
        
        int i;
        
        // Scan from left to right
        for (i = 1; i < size; i++) {
            // keep the minimal value of left side
            curMin = Math.min(curMin, prices[i]);
            // the max profit of left side is the larger number of 
            // previous and current profit 
            profit1[i] = Math.max(profit1[i-1], prices[i] - curMin);
        }
        
        // Scan from right to left
        for (i = size-2; i >= 0; i--) {
            // Keep the maximal value of right side
            curMax = Math.max(curMax, prices[i]);
            // the max profit of right side is the larger number of 
            // previous and current profit 
            profit2[i] = Math.max(profit2[i+1] , curMax - prices[i]);
            
        }
        
        // Scan the two array to get the max profit
        // etc max of profit1 plus profit2
        int profit = 0;
        for (i = 0; i < size - 1; i++)
            profit = Math.max(profit, profit1[i] + profit2[i]);
        
        return profit;
    }
}
