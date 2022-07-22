class Solution {
    public void swap(int[] arr , int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void segregate0and1(int[] arr, int n) {
       // [0, low - 1] -> 0's
       // [high + 1 , n] -> 1's
       int low = 0 , high = n - 1 , i = 0;
       while(i <= high)
       {
           if(arr[i] == 0)
           {
               swap(arr , i , low);
               low++;
               i++;
           }
           else if(arr[i] == 1)
           {
               swap(arr , i , high);
               high--;
           }
       }
       
    }
}
// TC : O(N)
// SC : O(1)

