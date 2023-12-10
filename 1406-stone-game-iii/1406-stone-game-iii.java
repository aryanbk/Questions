// DP - tabulation 
// O(n)
// O(n)

class Solution {
    int[] dp;
    public String stoneGameIII(int[] val) {
        int n = val.length;
        dp = new int[n+1];
        
        for(int i=n-1; i>=0; --i){
            int sumt = 0;
            dp[i] = -1000000;
            
            for(int j=i; j<i+3 && j<n; ++j){
                sumt += val[j];
                dp[i] = Math.max(dp[i], sumt - dp[j+1]);
            }
        }
        
        return dp[0]>0 ? "Alice" : (dp[0]<0 ? "Bob" : "Tie");
    }
}


// // DP - memo 
// // O(n)
// // O(n)
// class Solution {
    
//     int[] memo;
//     public String stoneGameIII(int[] val) {
//         memo = new int[val.length];
//         Arrays.fill(memo, -1);
//         int diff = solve(0, val);
//         return diff>0 ? "Alice" : (diff<0 ? "Bob" : "Tie");
//     }
    
//     private int solve(int i, int[] piles){
//         if(i>=piles.length)
//             return 0;
        
//         if(memo[i] != -1) return memo[i];
        
//         int sumt = 0;
//         int ans = -1000000;
        
//         for(int j=i; j<i+3 && j<piles.length; ++j){
//             sumt += piles[j];
//             ans = Math.max(ans, sumt - solve(j+1, piles));
//         }
        
//         memo[i] = ans;
//         return ans;
//     }
// }