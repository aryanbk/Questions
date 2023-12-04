class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        for(int i=0; i<=n; ++i){
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = -1000000;
            }
            else{
                // dp[currLength][buy] = Math.max(hodl, buyOrSell);
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]-fee);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]);
            }
        }
        return dp[n][0];
    }
}