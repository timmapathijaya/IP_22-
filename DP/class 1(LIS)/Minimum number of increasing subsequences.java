// Minimum Number of Increasing Subsequence => Longest Decreasing Subsequence
import java.util.*;
class Test
{
    public static int decreasingSubsequence(int[] arr , int n)
    {
        int longestDecreasingSubsequenceLength = 1;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++) // N * N
        {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(arr[j] > arr[i])
                dp[i] = Math.max(dp[j] + 1 , dp[i]); 
            }
            longestDecreasingSubsequenceLength = Math.max(longestDecreasingSubsequenceLength , dp[i]);
        }
        return longestDecreasingSubsequenceLength;
    }
    public static void main(String [] args)
    {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
        arr[i] = sc.nextInt();
        System.out.println(decreasingSubsequence(arr , n));
    }
}
// TC : O(N^2)
// SC : O(N)
