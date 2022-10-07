class Solution {
    static int findMaxLen(String S) {
        int validSubstringLength = 0;
        Stack<Integer> stack = new Stack<>();
       
        for(int i = 0 ; i < S.length() ; i++)
        {
            char c_i = S.charAt(i);
            if(c_i == ')') 
            {
                if(stack.empty() || S.charAt(stack.peek()) == ')')
                stack.push(i);
                else 
                {
                    stack.pop();
                    int lastUnbalancedIndex = stack.empty() == false ? stack.peek() : -1;
                    int lengthOfCurrentValidSubstring = i - lastUnbalancedIndex;
                    validSubstringLength = Math.max(validSubstringLength , lengthOfCurrentValidSubstring);
                }
            }
            else
            stack.push(i);
        }
        return validSubstringLength;
    }
};
// TC : O(N)
// SC : O(N)
