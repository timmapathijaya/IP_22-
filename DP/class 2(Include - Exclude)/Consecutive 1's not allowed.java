class Solution {
    long countStrings(int n) {
        long endWithZero = 1, endWithOne = 1;
        long m = 1000000007;
        for(int i = 2 ; i <= n ; i++) // N
        {
            long total = ( endWithZero % m + endWithOne % m ) % m;
            endWithOne = endWithZero;
            endWithZero = total;
        }
        return ((endWithZero % m + endWithOne % m ) % m);
    }
    
}
// TC : O(N)
// SC : O(1) 
