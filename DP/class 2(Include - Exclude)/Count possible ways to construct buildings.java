class Solution
{
    public int TotalWays(int N)
    {
        long endingWithHouse = 1;
        long endingWithSpace = 1;
        long  m = 1000000007;
        for(int i = 2 ; i <= N ; i++) // N
        {
            long total = (endingWithHouse % m + endingWithSpace % m)%m;
            endingWithHouse = endingWithSpace;
            endingWithSpace = total; 
        }
        long totalWays = (endingWithHouse % m + endingWithSpace % m)%m ;
        return (int)((totalWays % m * totalWays % m )%m);
    }
}
// TC : O(N)
// SC : O(1)
