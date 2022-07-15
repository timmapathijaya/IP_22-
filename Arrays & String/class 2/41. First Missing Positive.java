class Solution {
    public void swap(int[] nums , int currentPos , int desiredPos)
    {
        int temp = nums[currentPos];
        nums[currentPos] = nums[desiredPos];
        nums[desiredPos] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        // claim 1 : ans range = {1 , nums.length + 1}
        // search range = {1 , nums.length}
// Linearly iterate through the array & try to place the elements which are in the search range at its correct position.
        int i = 0;
        int n = nums.length;
        while(i < n) // N
        {
            // check whether element is in search range 
            if(nums[i] >= 1 && nums[i] <= n)
            {
                if(nums[i] - 1 == i) // check if it is already present at its desired location 
                    i++;
                else{
                // try to place at its desired location 
                int currentPos = i;
                int desiredPos = nums[i] - 1;
                if(nums[currentPos] == nums[desiredPos]) // duplicacy 
                    i++;
                else 
                    swap(nums , currentPos , desiredPos);
                }  
            }
            else // not in search area 
                i++; // skip the ith element 
        }
        // Linearly  iterate again & find the missing number 
        for(i = 0 ; i < n ; i++) // N
        {
            if(nums[i] - 1 != i)
                return (i + 1);
        }
        return (n + 1);
    }
}
// TC : N + N => O(2N) 
// SC : O(1)
