class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int i = 0 , j = 0;
        while(i < n && j < m)
        {
            char c_i = name.charAt(i);
            char c_j = typed.charAt(j);
            if(c_i == c_j)
            {
                i++;
                j++;
            }
            else 
            {
                // mismatch 
                // long pressed condition 
                if(j != 0)
                {
                    char c_prev = typed.charAt(j - 1);
                    if(c_prev == c_j)
                        j++;
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        if(i != n)
         return false;
        else
        {
            char c_prev = typed.charAt(j - 1);
            while(j < m)
            {
                char c_j = typed.charAt(j);
                if(c_j == c_prev)
                    j++;
                else
                    return false;
            }
        }
        return true;
    }
}
// TC : O(N)
// SC : O(1)
