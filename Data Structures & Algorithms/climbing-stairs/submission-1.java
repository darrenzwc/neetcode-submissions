class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        // since if we go from top down and choose to subtract 1 or 2 
        return step(n, dp);
    }

    private static int step(int n, int[] dp) {
        // see if already stored
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = step(n - 1, dp) + step(n - 2, dp);
        return dp[n];
        
    }
}
