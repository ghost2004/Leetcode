
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
