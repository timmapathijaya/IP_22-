public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if(n == 1)
        return k;
        int lastTwoSame = k;
        int lastTwoDifferent = k * (k-1);
        for(int i = 3 ; i <= n ; i++)
        {
          int total = lastTwoSame + lastTwoDifferent;
          lastTwoSame = lastTwoDifferent;
          lastTwoDifferent = total * (k - 1);
        }
        return (lastTwoSame + lastTwoDifferent);
    }
}
// TC : O(N)
// SC : O(1)
