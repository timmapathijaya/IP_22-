class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort array on the basis of width , if two widths have same value sort on the basis of height in decreasing order.
        Arrays.sort(envelopes , (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));  // nlogn
        // Apply LIS on height of envelope.
        int dp[] = new int[envelopes.length];
        int maxEnvelopesCount = 0;
        
        for(int i = 0 ; i < envelopes.length ; i++) // N
        {
            int low = 0 , high = maxEnvelopesCount;
            while(low < high) // Log n 
            {
                int mid = low + (high - low)/2;
                if(dp[mid] < envelopes[i][1])
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = envelopes[i][1];
            if(low == maxEnvelopesCount)
                maxEnvelopesCount += 1;
        }
        
        return maxEnvelopesCount;
    }
}
// TC : nlogn + nlogn => O(2 * nlogn)
// SC : O(n)
