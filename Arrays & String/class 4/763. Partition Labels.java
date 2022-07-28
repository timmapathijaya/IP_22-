class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int lastIndex[] = new int[26];
        for(int  i = 0 ; i < 26 ; i++)
            lastIndex[i] = -1;
// Store the last occurrence index of every character present in String s
        for(int i = n - 1 ; i >= 0 ; i--) // N
        {
            int index = s.charAt(i) - 'a';
            if(lastIndex[index] == -1)
                lastIndex[index] = i;
        }
        // Chaining Concept
        int i = 0 , j = 0 , scope = 0;
        while(j < n) // N
        {
            int index = s.charAt(j) - 'a';
            scope = Math.max(scope , lastIndex[index]);
            if(j == scope)
            {
                ans.add(j - i + 1);
                i = j + 1;
            }
            j++;
        }
        return ans;
    }
}
// TC : N + N => O(2N)
// SC : O(26) => O(1)
