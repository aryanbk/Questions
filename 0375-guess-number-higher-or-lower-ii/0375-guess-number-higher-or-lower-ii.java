class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n; i>0; --i){
            for(int j=i+1; j<=n; ++j){
                
                dp[i][j] = 1000000000;
                for(int k=i; k<j; ++k){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k-1], dp[k+1][j]) + k);
                }
            }
        }
        
        return dp[1][n];
    }
}

// if i==j return 0;