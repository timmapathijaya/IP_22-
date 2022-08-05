class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
// Every dp cell will store the length of LIS that ends with that ith cell element 
        int LIS_length = 1;
        for(int i = 0 ; i < n ; i++)
        {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
            }
            LIS_length = Math.max(LIS_length , dp[i]);
        }
        return LIS_length;
        
    }
}
// TC : O(N^2)
// SC : O(N)

To get only the length we can use Binary Search Approach 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        int low , high , ans = 1 , mid;
        for(int i = 1 ; i < n ; i++ ){ // N
             low = 0;
             high = ans;
            while(low < high) // log N
            {
                mid = low + (high - low)/2;
                if(dp[mid] < nums[i])
                    low = mid + 1;
                else 
                    high = mid; 
            }
            dp[low] = nums[i];
            if(low == ans) // scope increase 
                ans++;
        }
        return ans;
    }
}
// TC : O(N log N)
// SC  : O(N)



