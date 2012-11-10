
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
