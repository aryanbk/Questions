class Solution {
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; ++i){
            for(int j=1; j*j<=i; ++j){
                if(dp[i - j*j] == 0){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n]==1;
    }
}


// // dp - memo
//
// class Solution {
//     int[] memo;
//     public boolean winnerSquareGame(int n) {
//         memo = new int[n+1];
//         Arrays.fill(memo, -1);
        
//         return solve(n) == 1;
//     }
//     private int solve(int n){
//         if(n<=0) return 0; // method returns 0 if curr player looses
        
//         if(memo[n] != -1) return memo[n];
        
//         for(int i=1; i*i<=n; ++i){
//             if(solve(n- i*i) == 0){
//                 memo[n] = 1;
//                 return 1; // method returns 1 if the other plater looses
//             }
//         }
//         memo[n] = 0;
//         return 0;
//     }
// }

// // recurssion
//
// class Solution {
//     public boolean winnerSquareGame(int n) {
//         return solve(n) == 1;
//     }
//     private int solve(int n){
//         if(n<=0) return 0; // method returns 0 if curr player looses
        
//         for(int i=1; i*i<=n; ++i){
//             if(solve(n- i*i) == 0)
//                 return 1; // method returns 1 if the other plater looses
//         }
//         return 0;
//     }
// }