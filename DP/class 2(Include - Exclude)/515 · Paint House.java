public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0)
        return 0;
        for(int i = 1 ; i < n ; i++) // N 
        {
          costs[i][0] += Math.min(costs[i-1][1] , costs[i-1][2]); 
          costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
          costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[n-1][0] , Math.min(costs[n-1][1],costs[n-1][2]));
    }
}
// TC : O(N)
// SC : O(1)
