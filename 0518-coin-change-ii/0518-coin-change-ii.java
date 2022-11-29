class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<dp.length; ++i) dp[i][0] = 1;
        for(int l=1; l<dp.length; ++l){
            for(int t=1; t<dp[0].length; ++t){
                if(t>=coins[l-1]) dp[l][t] = dp[l-1][t] + dp[l][t-coins[l-1]];
                else dp[l][t] = dp[l-1][t];
            }
        }
        return dp[coins.length][amount];
    }
}


// class Solution {
//     public int change(int amount, int[] coins) {
//         int[][] dp = new int[coins.length+1][amount+1];
//         for(int l=0; l<dp.length; ++l){
//             for(int t=0; t<dp[0].length; ++t){
//                 if(t==0) dp[l][t] = 1;
//                 else if(l==0) dp[l][t] = 0;
//                 else{
//                     if(t>=coins[l-1]) dp[l][t] = dp[l-1][t] + dp[l][t-coins[l-1]];
//                     else dp[l][t] = dp[l-1][t];
//                 }
//             }
//         }
//         return dp[coins.length][amount];
//     }
// }