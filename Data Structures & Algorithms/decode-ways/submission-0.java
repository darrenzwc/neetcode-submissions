class Solution {
    public int numDecodings(String s) {
        // num of ways to decode the first i characters
        int[] dp = new int[s.length() + 1];
        // one way to choose an empty group
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++) {
            // choose one digit
            int num = s.charAt(i) - '0';
            if(num != 0) {
                dp[i + 1] += dp[i];
                // choose two digits
                if(i + 1 < s.length()) {
                    int num2 = s.charAt(i + 1) - '0';
                    if((num == 1 && num2 < 10) || num == 2 && num2 < 7) {
                        dp[i + 2] += dp[i];
                    }
                } 
            }
        }
        return dp[s.length()];
    }
}
