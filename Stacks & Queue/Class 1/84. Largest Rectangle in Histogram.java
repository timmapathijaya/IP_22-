class Solution {
    public int largestRectangleArea(int[] heights) {
       // for every bar find the NSBH on left & right
        
       int areaOfRectangle = 0;
       Stack<Integer> stack = new Stack<>();
        
       for(int i = 0 ; i < heights.length ; i++)
       {
           while(stack.empty() == false && heights[stack.peek()] > heights[i])
           {
              int index = stack.pop();
              int NSR = i;
              int NSL = (stack.empty() == false ? stack.peek() : -1);
              int width =  NSR - NSL - 1;
              areaOfRectangle = Math.max(areaOfRectangle , heights[index] * width); 
           }
           stack.push(i);
       }
        
       while(stack.empty() == false)
       {
           int index = stack.pop();
           int NSR = heights.length;
           int NSL = (stack.empty() == false ? stack.peek() : -1);
           int width = NSR - NSL - 1;
           areaOfRectangle = Math.max(areaOfRectangle , heights[index] * width);
       }
        
       return areaOfRectangle; 
    }
}
// TC : O(2N)
// SC : O(N)

