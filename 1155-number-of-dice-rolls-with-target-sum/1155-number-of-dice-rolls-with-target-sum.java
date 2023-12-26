class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1_000_000_007;
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i=1; i<=n; ++i){
            int[] newDp = new int[target+1];
            for(int j=1; j<=target; ++j){
                for(int x=1; x<=k && x<=j; ++x)
                    newDp[j] = (newDp[j] + dp[j-x])%MOD;
            }
            dp = newDp;
        }
        return dp[target];
    }
}



// class Solution {
//     public int numRollsToTarget(int n, int k, int target) {
//         int MOD = 1_000_000_007;
//         int[][] dp = new int[n+1][target+1];
//         dp[0][0] = 1;
        
//         for(int i=1; i<=n; ++i){
//             for(int j=1; j<=target; ++j){
//                 for(int x=1; x<=k && x<=j; ++x)
//                     dp[i][j] = (dp[i][j] + dp[i-1][j-x])%MOD;
//             }
//         }
//         return dp[n][target];
//     }
// }



// // DP - memo
// // O(n*target*k)
// // O(n*target)
//
// class Solution {
//     int MOD = 1_000_000_007;
//     Integer[][] memo = new Integer[31][1001];
//     public int numRollsToTarget(int n, int k, int target) {
//         if(n==0) return target==0 ? 1 : 0;
        
//         if(memo[n][target] != null) return memo[n][target];
        
//         memo[n][target] = 0;
        
//         for(int x=1; x<=k && x<=target; ++x) 
//             memo[n][target] = (memo[n][target] + numRollsToTarget(n-1, k, target-x))%MOD;
        
//         return memo[n][target];
//     }
// }


// // Recursion
// // O(k^n)
//
// class Solution {
//     int MOD = 1_000_000_007;
//     public int numRollsToTarget(int n, int k, int target) {
//         if(n==0) return target==0 ? 1 : 0;
//         int ans = 0;
        
//         for(int x=1; x<=k && x<=target; ++x) ans = (ans + numRollsToTarget(n-1, k, target-x))%MOD;
//         return ans;
//     }
// }