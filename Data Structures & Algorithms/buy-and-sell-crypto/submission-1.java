class Solution {
    public int maxProfit(int[] prices) {
        // max profit = sell - buy
        // sell to always have the largest value 
        // sell index > buy index
        if(prices.length == 1) {
            return 0;
        } 
        int max_profit = 0;
        int sell = prices.length - 1;
        int buy = sell - 1;
        while(buy > -1) {
            int current_profit = prices[sell] - prices[buy];
            if(current_profit < 0) {
                sell = buy;
                buy = sell - 1;
            }
            else {
                max_profit = Math.max(max_profit, current_profit);
                buy--;
            }
        }
        return max_profit;
    }
}
