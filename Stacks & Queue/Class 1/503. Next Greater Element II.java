class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int NGE[] = new int[n];
        Arrays.fill(NGE , -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < n ; i++) 
        {
            while(stack.empty() == false && nums[stack.peek()] < nums[i])
            {
                int index = stack.pop();
                NGE[index] = nums[i];
                
            }
            stack.push(i);
        }
        
        for(int i = 0 ; i < n ; i++) 
        {
            while(stack.empty() == false && nums[stack.peek()] < nums[i])
            {
                int index = stack.pop();
                NGE[index] = nums[i];
            }
        }
        
        return NGE;
    }
}
