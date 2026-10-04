class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] storing the num unique ways to this square

        // 2 choices: right or down
        int[][] dp = new int[m][n];
        // Only one way to start
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // Choice 1: Move down
                if(i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                // Choice 2: Move right
                if(j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
