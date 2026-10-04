class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // zero edge case no elements chosen
        for(int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i < nums.length + 1; i++) {
            int currNum = nums[i - 1];
            for(int j = 1; j < target + 1; j++) {
                // skip number
                dp[i][j] = dp[i - 1][j];

                // choose number
                if(j >= currNum) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - currNum];
                }
            }
        }
        return dp[nums.length][target];
    }
}
