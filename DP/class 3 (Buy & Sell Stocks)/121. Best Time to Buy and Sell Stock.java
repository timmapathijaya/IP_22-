class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int leastPrice = prices[0];
// Consider every ith day as a potential selling day & calculate the profit earned if the stock was sold on the ith day with ith price
        for(int i = 1 ; i < prices.length ; i++)
        {
            leastPrice = Math.min(prices[i] , leastPrice);
            profit = Math.max(profit , prices[i] - leastPrice);
        }
        return profit;
    }
}
// TC : O(N)
// SC : O(1)
