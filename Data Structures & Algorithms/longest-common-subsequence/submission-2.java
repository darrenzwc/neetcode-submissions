class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*C R A B T
        C 1
        A   1 2
        R       2 2

          C R A B T
        C 1
        A   1 2
        T       2 3


        dp[text1][text2] = dp[i][j] = letters shared by text1 and text2 up to i, j          respectfully
        */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                // check prefixes diagonal
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    // find better by skipping
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
