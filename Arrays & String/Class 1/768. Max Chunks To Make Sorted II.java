class Solution {
    public int maxChunksToSorted(int[] arr) {
     // Optimised Approach
 // valid chunk : Partition left side maximum  value  <= Partition right side minimum value 
        int n = arr.length;
        int prefixMax = -1;
        int suffixMin[] = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--) // N
         suffixMin[i] = Math.min(arr[i] , suffixMin[i + 1]);
        int chunks = 1;
        for(int i = 0 ; i < n - 1 ; i++) // N
        {
            prefixMax = Math.max(prefixMax , arr[i]);
            // valid chunk condition
            if(prefixMax <= suffixMin[i + 1])
                chunks++;
        }
       return chunks;
    }
}
// TC : N + N = > O(2N)
// SC : O(N)

     // Brute Force 
    // try to find out the desired index for every element in the sorted part 
        //1) Sort the array & get the desired position for every element , and store it in map 
        //2) Replace element with their desired index & apply same chaining concept
// TC : NlogN + N + N => O(NlogN)
// SC : O(2N)
