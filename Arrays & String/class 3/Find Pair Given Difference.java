class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        if(size == 1)
        return false;
        // 2 - pointer 
        Arrays.sort(arr); // size * log size
        int i = 0 , j = 1;
        while(i < size && j < size)
        {
            int diff = arr[j] - arr[i];
            if(diff == n && i != j)
            return true;
            else if(diff < n)
            j++;
            else 
            i++;
        }
        return false;
    }
}
// TC : O(NlogN)
// SC : O(1)
