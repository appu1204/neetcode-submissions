class Solution {
    public int maxProfit(int[] prices) {
        int curr_buyPrice = prices[0];
        int profit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (curr_buyPrice > prices[i]) {
                curr_buyPrice = prices[i];
                profit = 0;
            } else {
                profit = prices[i] - curr_buyPrice;
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
