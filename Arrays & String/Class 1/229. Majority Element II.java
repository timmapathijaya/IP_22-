class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyer Moore Voting Algorithm 
        // At max we can have 2 Majority Element 
        // Distinct element ka  triplets 
        int n = nums.length;
        List<Integer> majorityElements = new ArrayList<>();
        int value_1 = nums[0] , freq_1 = 1, value_2 = nums[0] , freq_2 = 0;
        for(int i = 1 ; i < n ; i++) // N
        {
            if(nums[i] == value_1)
                freq_1++;
            else if(nums[i] == value_2)
                freq_2++;
            else // distinct element 
            {
                // check for forming the triplets 
                if(freq_1 == 0)
                {
                    value_1 = nums[i];
                    freq_1 = 1;
                }
                else if(freq_2 == 0)
                {
                    value_2 = nums[i];
                    freq_2 = 1;
                }
                else // distinct elements triplets
                {
                    freq_1--;
                    freq_2--;
                }
            }
        }
        freq_1 = 0;
        freq_2 = 0;
        for(int i = 0 ; i < n; i++) // N
        {
            if(nums[i] == value_1)
                freq_1++;
            else if(nums[i] == value_2)
                freq_2++;
        }
        if(freq_1 > n / 3)
             majorityElements.add(value_1);
        if(freq_2 > n / 3)
             majorityElements.add(value_2);
        
        return  majorityElements;
    }
}
// TC : O(2N)
// SC : O(1)
