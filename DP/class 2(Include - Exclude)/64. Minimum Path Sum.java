class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
// Every dp cell will store the minimum cost required to reach destination from that point 
        for(int i = m - 1 ; i >= 0 ; i--) // M * N
        {
            for(int j = n - 1 ; j >= 0 ; j--)
            {
                if(i == m - 1 && j == n - 1) // destination 
                    dp[i][j] = grid[i][j];
                else if(i == m - 1 && j != n - 1) // can move only in right direction
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(j == n - 1 && i != m - 1) // can move only in downward direction 
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else 
                   dp[i][j] = Math.min(dp[i+1][j] , dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
// TC : O(M * N)
// SC : O(M * N)
