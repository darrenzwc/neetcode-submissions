class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        //Math.min(heights[i], heights[j]) * j - i );
        int start = 0;
        int end = heights.length - 1;
        while(start != end) {
            int water = Math.min(heights[start], heights[end]) * (end - start);
            maxWater = Math.max(maxWater, water);
            if(heights[start] > heights[end]) {
                end--;
            }
            else {
                start++;
            }
        }
        return maxWater;
    }
}
