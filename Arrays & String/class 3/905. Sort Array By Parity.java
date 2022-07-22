class Solution {
    public void swap(int[] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
       int low = 0 , high = nums.length - 1 , i = 0;
       while(i <= high)
       {
           if(nums[i] % 2 == 0) // even value
           {
               swap(nums , i , low);
               low++;
               i++;
           }
           else // odd value
           {
               swap(nums , i , high);
               high--;
           }
       }
       return nums; 
    }
}
// TC : O(N)
// SC : O(1)

 /*
        [0 , low - 1] ->  even values
        [high + 1 , n] ->  odd values 
        [i , high] -> unexplored region 
*/
        
