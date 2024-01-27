// // O(n * k)

class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        long MOD = 1_000_000_007;
        dp[0][0] = 1;
        
        for(int i=1; i<=n; ++i){
            dp[i][0] = 1;
            long sumt = 1;
            for(int j=1; j<=k; ++j){
                sumt += dp[i-1][j];
                sumt -= j-i >=0 ? dp[i-1][j-i] : 0;
                dp[i][j] = (int)(sumt % MOD);
            }
        }
        
        return dp[n][k];
    }
}



// // TLE
// // O(n * k * n)
//
// class Solution {
//     Integer[][] memo = new Integer[1001][1001];
//     int MOD = 1_000_000_007;
    
//     public int kInversePairs(int n, int k) {
//         if(k<0) return 0;
//         if(n==0) return k==0 ? 1 : 0;
//         if(memo[n][k] != null) return memo[n][k];
//         memo[n][k] = 0;
//         for(int i=0; i<n; ++i)
//             memo[n][k] = (memo[n][k] + kInversePairs(n-1, k-i)) % MOD;
//         return memo[n][k];
//     }
// }



// // Wrong answer

// class Solution {
//     int[] map;
//     Integer[][] memo;
//     int MOD = 1_000_000_007;
//     public int kInversePairs(int n, int k) {
//         map = new int[n+1];
//         memo = new Integer[n+1][k+1];
//         for(int i=2; i<n+1; ++i) map[i] = map[i-1]+i-1;
//         return dfs(2, n, k);
//     }
//     int dfs(int i, int n, int k){
//         if(k<0) return 0;
//         if(i==n+1) return k==0 ? 1 : 0;
        
//         if(memo[i][k] != null) return memo[i][k];
        
//         memo[i][k] = 0;
//         for(int x=0; x<=map[i] && k-x>=0; ++x){
//             memo[i][k] = (memo[i][k] + dfs(i+1, n, k-x))%MOD;
//         }
//         return memo[i][k];
//     }
// }