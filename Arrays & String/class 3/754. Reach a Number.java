class Solution {
    public int reachNumber(int target) {
        if(target < 0)
        target *= -1;
        int currentPos = 0 , moves = 1 , totalJumps = 0;
        while(true)
        {
            currentPos += moves;
            totalJumps++;
            if(currentPos == target) // reached the destination 
                break;
            else if(currentPos > target) // already passed the destination 
            {
              int difference = currentPos - target;
              while(difference%2 != 0)
              {
                  moves++;
                  currentPos += moves;
                  totalJumps++;
                  difference = currentPos - target;
              }
              break;  
            }
            moves+=1;
        }
        return totalJumps;
    }
}
