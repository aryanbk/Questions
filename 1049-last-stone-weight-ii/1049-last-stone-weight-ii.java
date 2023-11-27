// dp tab space optimized
// TC O(n * sumt/2)
// SC O(sumt/2)

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sumt = 0;
        int ans = Integer.MAX_VALUE;
        for(int s: stones) sumt += s;

        boolean[] dp = new boolean[(sumt/2)+1];
        dp[0] = true;

        for(int sz = 1; sz <= n; ++sz){
            boolean[] temp = new boolean[(sumt/2)+1];
            for(int sm = 0; sm <= sumt/2; ++sm){
                if(sm == 0) temp[sm] = true;
                else if(sz == 0) temp[sm] = false;
                else{
                    temp[sm] = dp[sm];
                    if(sm >= stones[sz - 1])
                        temp[sm] |= dp[sm - stones[sz - 1]];
                }
                if(sz == n && temp[sm]){
                    int currDiff = sumt - 2 * sm;
                    ans = Math.min(ans, currDiff);
                }
            }
            dp = temp;
        }
        return ans;
    }
}




// dp - tab - without space opti
//
// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         int sumt = 0;
//         for(int s: stones) sumt += s;
//         boolean[][] dp = new boolean[n+1][(sumt/2)+1];
//         int ans = Integer.MAX_VALUE;
        
//         for(int sz=0; sz<=n; ++sz){
//             for(int sm=0; sm<=sumt/2; ++sm){
//                 if(sm==0) dp[sz][sm] = true;
//                 else if(sz == 0) dp[sz][sm] = false;
//                 else{
//                     dp[sz][sm] = dp[sz-1][sm];
//                     if(sm>=stones[sz-1])
//                         dp[sz][sm] |= dp[sz-1][sm-stones[sz-1]];
//                 }
                
//                 if(sz == n && dp[n][sm]){
//                     int currDiff = sumt - 2*sm;
//                     ans = Math.min(ans, currDiff);
//                 }
                
//             }
//         }
//         return ans;
//     }
// }

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