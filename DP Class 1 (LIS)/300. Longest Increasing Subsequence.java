class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int LIS_length = 0;
        
        for(int value : nums) // N
        {
           int low = 0 , high = LIS_length;
           //this will give the position were we can place the current value in dp array.
            while(low < high) // log N
            {
                int mid = low + (high - low)/2;
                if(dp[mid] < value)
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = value;
            if(low == LIS_length) // LIS length is getting increase. 
                LIS_length += 1;
        }
        return LIS_length;
    }
}
// TC : O(NlogN)
// SC : O(N)
/*
* Scope Increase hoga. 
        or 
* LIS length will increase.
*/
