class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
       // NGE on left concept     
       int stockSpan[] = new int[n];
       Stack<Integer> stack = new Stack<>();
       
       for(int i = n - 1 ; i >= 0 ; i--)
       {
           while(stack.empty() == false && price[stack.peek()] < price[i])
           {
               stockSpan[stack.peek()] = stack.pop() - i;
           }
           stack.push(i);
       }
       
       while(stack.empty() == false)
       {
           stockSpan[stack.peek()] = stack.pop() + 1;
       }
       
       return stockSpan;
    }
    
}
// TC : O(2N)
// SC : O(N)
