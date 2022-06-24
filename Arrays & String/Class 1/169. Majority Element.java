class Solution {
    public int majorityElement(int[] nums) {
        // Boyer Moore Voting Algorithm 
        // Pairing Distinct Element 
        int value = nums[0] , count = 1;
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] == value)
                count++;
            else // distinct element 
            {
                // check for pairing 
                if(count == 0) // No unpaired element
                {
                    value = nums[i];
                    count = 1;
                }
                else // pairing
                    count--;
            }
        }
        return value;
    }
}
// TC : O(N)
// SC : O(1)
