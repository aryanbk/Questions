class Solution {
    public int checkRecord(int n) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[3][4]; // [absent][late]
        
        // pre-fill
        for(int i=0; i<2; ++i)
            for(int j=0; j<3; ++j)
                dp[i][j] = 1;
        
        for(int i=1; i<=n; ++i){
            int[][] newDp = new int[3][4];
            for(int a=0; a<2; ++a){
                for(int l=0; l<3; ++l){
                    newDp[a][l] = dp[a][0];
                    newDp[a][l] = (newDp[a][l] + dp[a+1][0])%MOD;
                    newDp[a][l] = (newDp[a][l] + dp[a][l+1])%MOD;
                }
            }
            dp = newDp;
        }
        
        return dp[0][0];
        
    }
}







// class Solution {
//     int MOD = 1_000_000_007;
//     Integer[][][] dp;
    
//     public int checkRecord(int n) {
//         dp = new Integer[n+1][3][4];
//         return solve(n, 0, 0);
//     }
    
//     int solve(int n, int a, int l){
//         if(a == 2 || l == 3) return 0;
//         if(n==0) return 1;
        
//         if(dp[n][a][l] != null)
//             return dp[n][a][l];
        
//         int ans = solve(n-1, a, 0);
//         ans = (ans + solve(n-1, a+1, 0))%MOD;
//         ans = (ans + solve(n-1, a, l+1))%MOD;
        
//         dp[n][a][l]  = ans;
//         return ans;
//     }
// }
