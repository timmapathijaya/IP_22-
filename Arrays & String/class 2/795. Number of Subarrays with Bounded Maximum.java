class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    // case 1 : ith element < left => subarrays = last valid subarray count
  // case 2 : ith element > right = > split 
  // case 3 : left <= ith element <= right (in range) [ j - i + 1]
        int subarrayCount = 0 , prevValidSubarrayCount = 0 , j = 0 , i = 0;
        while(j < nums.length) // N
        {
            if(left <= nums[j] && nums[j] <= right) // in range
            {
                subarrayCount += (j - i + 1);
                prevValidSubarrayCount = (j - i + 1); 
            }
            else if(nums[j] < left) 
            subarrayCount += prevValidSubarrayCount;
            else if(nums[j] > right) // split
            {
             i = j + 1;
             prevValidSubarrayCount = 0;   
            }
            j++;
        }
        return subarrayCount;
    }
}
// TC : O(N)
// SC : O(1)
