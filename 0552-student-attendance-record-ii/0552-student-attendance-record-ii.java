class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    
    public int checkRecord(int n) {
        dp = new Integer[n+1][3][4];
        return solve(n, 0, 0);
    }
    
    int solve(int n, int a, int l){
        if(a == 2 || l == 3) return 0;
        if(n==0) return 1;
        
        if(dp[n][a][l] != null)
            return dp[n][a][l];
        
        int ans = solve(n-1, a, 0)%MOD;
        ans = (ans + solve(n-1, a+1, 0))%MOD;
        ans = (ans + solve(n-1, a, l+1))%MOD;
        
        dp[n][a][l]  = ans;
        return ans;
    }
}