class Solution {
    public void swap(int[] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        // Dutch National Flag Algorithm 
       int low = 0 , high = nums.length - 1 , i = 0;
       while(i <= high)
       {
           if(nums[i] == 0)
           {
               swap(nums , i , low);
               low++;
               i++;
           }
           else if(nums[i] == 1)
               i++;
           else if(nums[i] == 2)
           {
               swap(nums , i , high);
               high--;
           }
       } 
    }
}
// TC : O(N)
// SC : O(1)

 /*
        Define regions with the help of pointers 
        [0 , low - 1] - > 0's
        [low , i - 1] -> 1's
        [high + 1 , last] -> 2's
        [i , high] -> unexplored region 
*/
