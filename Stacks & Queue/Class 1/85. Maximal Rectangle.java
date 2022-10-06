class Solution {
    public int findHistogramMaxArea(int[] heights)
    {
       int maximumArea = 0;
       Stack<Integer> stack = new Stack<>();
        
       for(int i = 0 ; i < heights.length ; i++)
       {
           while(stack.empty() == false && heights[stack.peek()] > heights[i])
           {
               int index = stack.pop();
               int NSR = i;
               int NSL = (stack.empty() == false ? stack.peek() : -1);
               
               int width = NSR - NSL - 1;
               
               maximumArea = Math.max(maximumArea , heights[index] * width);
           }
           stack.push(i);
       }
        
       while(stack.empty() == false)
       {
           int index = stack.pop();
           int NSR = heights.length;
           int NSL = (stack.empty() == false ? stack.peek() : -1);
           
           int width = NSR - NSL - 1;
           
           maximumArea = Math.max(maximumArea , heights[index] * width);
       }
        
       return maximumArea;  
    }
    
    public int maximalRectangle(char[][] matrix) {
        // Consider every row as a histogram 
        int rows = matrix.length;
        int cols = matrix[0].length;
        int areaOfRectangle = 0;
        
        int heights[] = new int[cols];
        
        for(int i = 0 ; i < rows ; i++) // rows * (cols + 2 * cols) 
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            
            areaOfRectangle = Math.max(areaOfRectangle , findHistogramMaxArea(heights));
        }
        
        return areaOfRectangle;
    }
}
// TC : O(rows * (cols + 2 * cols))
// SC : O(cols)
