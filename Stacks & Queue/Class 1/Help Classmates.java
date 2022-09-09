class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	   // Next Smaller on right
	   int NSR[] = new int[n];
	   // for every element we have to find the nearest smaller element on right
	   Stack<Integer> stack = new Stack<>();
	   
	   for(int i = 0 ; i < n ; i++)
	   {
	       while(stack.empty() == false && arr[stack.peek()] > arr[i])
	       {
	           int index = stack.pop();
	           NSR[index] = arr[i];
	       }
	       
	       stack.push(i);
	   }
	   
	   while(stack.empty() == false)
	   {
	       int index = stack.pop();
	       NSR[index] = -1;
	   }
	   return NSR;
	} 
}
// TC : O(2N)
// SC : O(N)

