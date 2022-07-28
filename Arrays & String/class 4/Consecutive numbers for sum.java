class Solution {
    static String isSumOfConsecutive(int N) {
       // Sliding Window Concept (acquire &  release)
       int i = 1 , j = 2 , sum = i + j;
       while(j < N)
       {
         if(sum == N)
         return "Yes";
         else if(sum < N) // acquire
         sum = sum +  ++j;
         else // release
         sum = sum - i++;
       }
       return "No";
    }
};
// TC : O(N)
// SC : O(1)
