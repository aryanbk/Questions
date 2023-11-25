class Solution {
    int n;
    int[][] dp;
    public int minimumCoins(int[] prices) {
        n = prices.length;
        dp = new int[n][n];
        for(var row : dp) Arrays.fill(row, -1); //fill
        
        return find(0, 0, prices);
    }
    
    private int find(int i, int freeTill, int[] prices){
        if(i>=n) return 0;
        
        if(dp[i][freeTill] != -1) return dp[i][freeTill];
        
        int ans = Integer.MAX_VALUE;
        
        if(i<=freeTill && i != 0) // eliminate first case
            ans = Math.min(ans, find(i+1, freeTill, prices)); //buy in free
        
        int paid = find(i+1, Math.min(n-1, i+i+1), prices); //paid for i
        dp[i][freeTill] = Math.min(ans, prices[i] + paid);
        
        return dp[i][freeTill];
    }
}