class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int max = 0;
        // skip the last house
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            if(i == nums.length - 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            }
            else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        max = dp[nums.length - 1];
        // skip first house
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(max, dp[nums.length - 1]);

    }
}
