class Solution {
    public String swap(String num , int index , int swapIndex)
    {
        char c_index = num.charAt(index);
        char c_swapIndex = num.charAt(swapIndex);
        StringBuilder number = new StringBuilder(num);
        number.setCharAt(index , c_swapIndex);
        number.setCharAt(swapIndex , c_index);
        return number.toString();
    }
    public String reverse(String num , int start, int end)
    {
        StringBuilder number = new StringBuilder(num);
        while(start < end)
        {
            char c_start = num.charAt(start);
            char c_end = num.charAt(end);
            number.setCharAt(start , c_end);
            number.setCharAt(end , c_start);
            start++;
            end--;
        }
        return number.toString();
    }
    public int nextGreaterElement(int n) {
        // 115 => 511 , 151(just next greater element)
// claim 1 : try to perform changes in smallest place value
        String num = String.valueOf(n);
        int index = -1;
        for(int i = num.length() - 2 ; i >= 0 ; i--) // N
        {
            int currDigit = num.charAt(i) - '0';
            int nextDigit = num.charAt(i+1) - '0';
            if(currDigit < nextDigit)
            {
                index = i;
                break;
            }
        }
// claim 2 : if index == -1 Not possible to increase the value 
        // eg : 876
        if(index != -1)
        {
            // increase the num value by swapping the digits 
            int value = num.charAt(index) - '0'; 
            int swapIndex = index + 1;
            for(int i = num.length() - 1 ; i > index ; i--) // N
            {
                int currDigit = num.charAt(i) - '0';
                if(currDigit > value)
                {
                   swapIndex = i;
                   break; 
                    
                }
            }
            num = swap(num , index , swapIndex);
            num = reverse(num , index + 1 , num.length() - 1); // N
        }
        else
            return (-1);
        long ans = Long.parseLong(num);
        if(ans > Integer.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }
}
// TC : N + N + N => O(3N)
// SC : O(1)
