class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            else
                map.put(nums[i] , i);
        }
        return ans;
    }
}
// TC : O(N)
// SC : O(N)

// Space Optimisation
class Solution {
    boolean hasArrayTwoCandidates(int nums[], int n, int x) {
       // 2 - pointer
       Arrays.sort(nums); // n * log(n)
       int i = 0 , j = n - 1;
       while(i < j) // n
       {
           int sum = nums[i] + nums[j];
           if(sum == x)
           return true;
           else if(sum > x)
           j--;
           else if(sum < x)
           i++;
       }
       return false;
    }
}
// TC : O(N log N)
// SC : O(1)
