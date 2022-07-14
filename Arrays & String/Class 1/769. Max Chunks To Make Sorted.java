class Solution {
    public int maxChunksToSorted(int[] arr) {
// valid chunk = > Maximum element inside the chunk should be equal to partition index value.
        // chaining concept 
        int chunks = 0;
        int maxElementSoFar = -1;
        for(int i = 0 ; i < arr.length ; i++) // N 
        {
            maxElementSoFar = Math.max(arr[i] , maxElementSoFar);
            if(maxElementSoFar == i)
                chunks++;
        }
        
        return chunks;
        
    }
}
// TC : O(N)
// SC : O(1)
