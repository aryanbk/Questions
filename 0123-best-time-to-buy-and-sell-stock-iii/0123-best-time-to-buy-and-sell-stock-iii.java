class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        int n = prices.length;
        if (n <= 1) return 0; // Check if there are less than 2 prices

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int kk = 0; kk <= k; ++kk) {
            dp[0][0][kk] = 0;
            dp[0][1][kk] = Integer.MIN_VALUE; // Set an initial value for not holding any stock
        }

        for (int i = 1; i <= n; ++i) {
            for (int kk = 1; kk <= k; ++kk) {
                dp[i][0][kk] = Math.max(dp[i - 1][0][kk], dp[i - 1][1][kk] + prices[i - 1]);
                dp[i][1][kk] = Math.max(dp[i - 1][1][kk], dp[i - 1][0][kk - 1] - prices[i - 1]);
            }
        }

        return dp[n][0][k]; // Maximum profit when not holding any stock after all transactions
    }
}