class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDistanceToClosestPerson = 0;
        int i = 0 , j = 0;
        while(i < n) // N 
        {
            if(seats[i] == 1)
            {
                if(seats[j] == 1)
                {
                    maxDistanceToClosestPerson = Math.max(maxDistanceToClosestPerson , (i - j) / 2);
                    j = i;
                }
                else 
                {
                    maxDistanceToClosestPerson = Math.max(maxDistanceToClosestPerson , i );
                    j = i;
                }
                    
            }
            i += 1;
        }
        if(seats[n - 1] == 0)
            maxDistanceToClosestPerson = Math.max(maxDistanceToClosestPerson , (n - 1) - j);
        return maxDistanceToClosestPerson;
    }
}
// TC : O(N)
// SC : O(1)
