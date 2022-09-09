class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
     // Next Greater Element on Right 
        int n = temperatures.length;
        int ans[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < n ; i++)
        {
            while(stack.empty() == false && temperatures[stack.peek()] < temperatures[i])
            {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        
        return ans;
    }
}
// TC : O(2N)
// SC : O(N)
