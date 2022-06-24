class Solution {
    public int maxArea(int[] height) {
        int max_water_stored = 0 , water_stored;
        int i = 0 , j = height.length - 1;
        while(i < j)
        {
            water_stored = (j - i) * Math.min(height[i],height[j]);
            max_water_stored = Math.max(max_water_stored , water_stored);
            if(height[i] <= height[j])
                i++;
            else
                j--;
        }
        return max_water_stored;
    }
}
// TC : O(N)
// SC : O(1)
