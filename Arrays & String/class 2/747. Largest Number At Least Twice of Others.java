class Solution {
    public int dominantIndex(int[] nums) {
        // find second max & largest element 
        int second_max = -1 , largestElement = nums[0] , largestElementIndex = 0;
        for(int i = 1 ; i < nums.length ; i++) // N
        {
            if(largestElement < nums[i])
            {
                second_max = largestElement;
                largestElement = nums[i];
                largestElementIndex = i;
            }
            else if(second_max < nums[i])
                second_max = nums[i];
        }
        return (largestElement >= second_max * 2 ? largestElementIndex : -1);
    }
}
// TC : O(N)
// SC : O(1)
