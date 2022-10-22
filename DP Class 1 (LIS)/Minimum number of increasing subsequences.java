import java.util.*;
class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    
	    for(int i = 0 ; i < n ; i++)
	      arr[i] = sc.nextInt();
	    
	    System.out.println(minIncreasingSubsequence(arr , n));  
	    
	}
	public static int minIncreasingSubsequence(int[] arr , int n)
	{
	    // Min Increasing Subsequence = LDS length.
	    
	    int dp[] = new int[n];
	    int LDS_length = 0;
	    
	    for(int value : arr) // N
	    {
	        int low = 0 , high = LDS_length;
	        while(low < high) // log N
	        {
	            int mid = low + (high - low)/2;
	            
	            if(dp[mid] > value)
	            {
	                low = mid + 1;
	            }
	            else 
	            high = mid;
	        }
	        dp[low] = value;
	        if(low == LDS_length)
	        LDS_length += 1;
	    }
	    return LDS_length;
	}
}
