class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return attempt(0, dp, nums);
    }
    private int attempt(int i, int[] dp, int[] nums) {
        if(i > nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(attempt(i + 1, dp, nums), nums[i] + attempt(i + 2, dp, nums));
        return dp[i];
    }
}
