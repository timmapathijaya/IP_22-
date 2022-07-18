public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
       int ans[] = new int[length];
       for(int i = 0 ; i < updates.length ; i++) // q
       {
           int startIndex = updates[i][0];
           int endIndex = updates[i][1];
           int value = updates[i][2];
           ans[startIndex] += value;
           if(endIndex + 1 < length)
           ans[endIndex + 1] -= value; 
       }
       // Prefix Sum 
       for(int i = 1 ; i < length ; i++) // n
       ans[i] = ans[i - 1] + ans[i];
       return ans;
    }
}
// TC : O(Q + N)
// SC : O(1)
