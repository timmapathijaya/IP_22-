class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0 , j = n - 1 ;
        int ans[] = new int[n];
        for(int k = n - 1 ; k >= 0 ; k--)
        {
            int sq_i = nums[i] * nums[i];
            int sq_j = nums[j] * nums[j];
            if(sq_i >= sq_j)
            {
                ans[k] = sq_i;
                i++;
            }
            else
            {
                ans[k] = sq_j;
                j--;
            }
        }
        return ans;
    }
}
// TC : O(N)
// SC : O(1)
