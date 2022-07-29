class Solution {
    public int partitionDisjoint(int[] nums) {
        // left max <= right min
        int n = nums.length;
        int prefixMax[] = new int[n];
        int suffixMin[] = new int[n];
        prefixMax[0] = nums[0];
        suffixMin[n - 1] = nums[n - 1];
        
        for(int i = 1 ; i < n ; i++) // N
        prefixMax[i] = Math.max(nums[i] , prefixMax[i - 1]);
        
        for(int i = n - 2 ; i >= 0 ;i--) // N
        suffixMin[i] = Math.min(nums[i] , suffixMin[i+1]);
        
        // Partition Index
        int leftSubarrayLength = 0;
        for(int i = 0 ; i < n - 1 ; i++) // N
        {
            if(prefixMax[i] <= suffixMin[i+1])
            {
                leftSubarrayLength = i + 1;
                break;
            }
        }
        return leftSubarrayLength;
    }
}
// TC : N + N + N => O(3N)
// SC : O(2N)

 Space Optimisation 
 class Solution {
    public int partitionDisjoint(int[] nums) {
        // Chaining Concept 
        int partitionIndex = 0 , presentMax = nums[0] , nextMax = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] < presentMax)
            {
                presentMax = nextMax;
                partitionIndex = i;
            }
            else
                nextMax = Math.max(nums[i] , nextMax);
        }
        return partitionIndex + 1;
    }
}
// TC : O(N)
// SC : O(1)



