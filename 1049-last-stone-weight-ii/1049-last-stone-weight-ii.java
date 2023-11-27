class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sumt = 0;
        for(int s: stones) sumt += s;
        boolean[][] dp = new boolean[n+1][(sumt/2)+1];
        int ans = Integer.MAX_VALUE;
        
        for(int sz=0; sz<=n; ++sz){
            for(int sm=0; sm<=sumt/2; ++sm){
                if(sm==0) dp[sz][sm] = true;
                else if(sz == 0) dp[sz][sm] = false;
                else{
                    dp[sz][sm] = dp[sz-1][sm];
                    if(sm>=stones[sz-1])
                        dp[sz][sm] |= dp[sz-1][sm-stones[sz-1]];
                }
                
                if(sz == n && dp[n][sm]){
                    int currDiff = sumt - 2*sm;
                    ans = Math.min(ans, currDiff);
                }
                
            }
        }
        return ans;
    }
}

// first attempt - accepted
// made some mistakes
// no need to have int[][] dp
// only to go till sumt/2

// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         int sumt = 0;
//         for(int s: stones) sumt += s;
//         int[][] dp = new int[n+1][sumt+1];
//         int ans = Integer.MAX_VALUE;
        
//         for(int sz=0; sz<=n; ++sz){
//             for(int sm=0; sm<=sumt/2; ++sm){
//                 if(sm==0) dp[sz][sm] = 1;
//                 else if(sz == 0) dp[sz][sm] = 0;
//                 else{
//                     dp[sz][sm] = dp[sz-1][sm];
//                     if(sm>=stones[sz-1])
//                         dp[sz][sm] += dp[sz-1][sm-stones[sz-1]];
//                 }
                
//                 if(sz == n && dp[n][sm]>0){
//                     ans = Math.min(ans, sumt - 2*sm);
//                 }
                
//             }
//         }
//         return ans;
//     }
// }