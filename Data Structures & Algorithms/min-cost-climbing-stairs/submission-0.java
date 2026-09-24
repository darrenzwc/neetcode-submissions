class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // brute force solution 2^n and would be finding every possible
        // path to the top while tracking min

        // Starting from the bottom I will store the cheapest cost for getting to a step i.
        // Start at index 2 since dependent on prev step
        int[] dp = new int[cost.length];
        // We already know that the min cost for steps 1 and 2 are the cost itself..
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int step = 2; step < cost.length; step++) {
            dp[step] = Math.min(dp[step - 1], dp[step - 2]) + cost[step];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
