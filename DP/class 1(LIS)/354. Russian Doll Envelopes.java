class Pair{
    int width , height;
    Pair(int width , int height)
    {
        this.width = width;
        this.height = height;
    }
    public String toString(){
       return "[" + this.width + "," + this.height + "]"; 
        
    }
}
class MyComparator implements Comparator<Pair>{
    public int compare(Pair a , Pair b)
    {
        if(a.width == b.width)
        return (b.height - a.height);
        else
        return (a.width - b.width);    
    }
}
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        List<Pair> envelope = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            Pair p = new Pair(envelopes[i][0] , envelopes[i][1]);
            envelope.add(p);
        }
    // Sort on the basis of width & apply LIS on height 
      Collections.sort(envelope , new MyComparator()); // N log N
      // Apply LIS on height 
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1 ; i < n ; i++) // N ^ 2
        {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(envelope.get(j).height < envelope.get(i).height)
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}
// TC : O(N^2)
// SC : O(N)
