class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        // Will store the prefix product in ans array 
        ans[0] = nums[0];
        for(int i = 1 ; i < n ; i++) // N
            ans[i] = ans[i - 1] * nums[i];
        int suffixProduct = 1;
        for(int i = n - 1 ; i > 0 ; i--) // N
        {                         
            ans[i] = suffixProduct * ans[i - 1];
            suffixProduct *= nums[i]; 
        }
        ans[0] = suffixProduct;
        return ans;
    }
}
// TC : N + N = > O(2N)
// SC : O(1)
