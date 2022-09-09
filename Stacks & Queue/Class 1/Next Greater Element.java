class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long NGE [] = new long[n];
        Stack<Integer> stack = new Stack<>();
        
        // for every element we have to find the nearest greater value on right side of the element
        
        for(int i = 0 ; i < n ; i++)
        {
            while(stack.empty() == false && arr[stack.peek()] < arr[i])
            {
                int index = stack.pop();
                NGE[index] = arr[i];
            }
            
            stack.push(i);
        }
        while(stack.empty() == false)
        {
            int index = stack.pop();
            NGE[index] = -1;
        }
        
        return NGE;
    } 
}
// TC : O(2N)
// SC : O(N)
