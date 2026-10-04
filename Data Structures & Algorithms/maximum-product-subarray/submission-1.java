class Solution {
    public int maxProduct(int[] nums) {
        int best_max =  nums[0];
        int currMin = 1;
        int currMax = 1;
        for(int num : nums) {  
            int tempMax = currMax * num;
            currMax = Math.max(Math.max(tempMax, num * currMin), num);
            currMin = Math.min(Math.min(tempMax, num * currMin), num);
            best_max = Math.max(best_max, currMax);
        }
        return best_max;
    }
}
