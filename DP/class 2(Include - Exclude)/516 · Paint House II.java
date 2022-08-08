public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        int minimumCost = Integer.MAX_VALUE;
        int secondMinimumCost = Integer.MAX_VALUE;
        for(int i = 0 ; i < k ; i++) // K
        {
            if(costs[0][i] < minimumCost)
            {
                secondMinimumCost = minimumCost;
                minimumCost = costs[0][i];
            }
            else if(costs[0][i] < secondMinimumCost)
            secondMinimumCost = costs[0][i];
        }
        for(int i = 1 ; i < n ; i++) // N * K
        {
           int nextMinimumCost = Integer.MAX_VALUE;
           int nextSecondMinimumCost = Integer.MAX_VALUE;
           for(int j = 0 ; j < k ; j++) // K
           {
               costs[i][j] += (costs[i-1][j] == minimumCost ? secondMinimumCost : minimumCost);
               if(costs[i][j] < nextMinimumCost)
               {
                   nextSecondMinimumCost = nextMinimumCost;
                   nextMinimumCost = costs[i][j];
               }
               else if(costs[i][j] < nextSecondMinimumCost)
               nextSecondMinimumCost = costs[i][j];
           }
           minimumCost = nextMinimumCost;
           secondMinimumCost = nextSecondMinimumCost;
        }
        return minimumCost;
    }
}
// TC : K + N * K => O(N * K)
// SC : O(1)
