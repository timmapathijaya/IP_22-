class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buying_day = 0 , selling_day = 0;
 // Consider every upstroke as a potential transaction       
        for(int i = 1 ; i < prices.length ; i++)
        {
            if(prices[i] > prices[selling_day])
                selling_day = i;
            else  // dip 
            {
               profit += prices[selling_day] - prices[buying_day];
               selling_day = i;
               buying_day = i; 
            }
        }
        profit += prices[selling_day] - prices[buying_day];
        return profit;
    }
}
// TC : O(N)
// SC : O(1)
